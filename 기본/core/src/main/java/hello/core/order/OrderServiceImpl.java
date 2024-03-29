package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//RequiredArgsConstructor // final을 가지는 2개를 아규먼트로 생성자 주입을 할 수 있도록 생성자를 만들어 줌!
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired // 생성자가 하나일때는 자동으로 붙여준다.  1. 생성자 주입
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
    //public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("fixDiscountPolicy") DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
/*
    @Autowired  2.수정자 주입
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    //@Autowired // 3. 필드주입
    private  MemberRepository memberRepository;
    //@Autowired
    private  DiscountPolicy discountPolicy; // 인터페이스만 의존하게 변경 DIP! 그냥쓰면 NPE


    //4. 일반 메서드
    @Autowired
    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    // 클라이언트인(서비스) 구현체에도 의존함!
    //DIP : 추상 인터페이스 DdiscountPolicy, 구현클래스 모두 의존 FixDiscountPolicy > 추상화에만 의존해야함!!
    //OCP : 구현체 수정을 위해 소스 바꿔줘야함!
*/


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice); //SRP 준수(할인 정책의 관심사 분리)

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
