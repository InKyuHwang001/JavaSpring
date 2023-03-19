package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    //private final MemberRepository memberRepository = new MemoryMemberRepository();//dip, ocp 위반
    private final MemberRepository memberRepository;

    @Autowired //의존관계를 설정해주는 방법이 없어서 생성자 타입에 맞는 스프링 빈을 주입해줌. -  ac.getBean(MemberRepository.class)
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }

}
