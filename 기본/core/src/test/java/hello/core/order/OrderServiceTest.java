package hello.core.order;

import hello.core.AppConfig;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    OrderService orderService;
    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }
    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA",10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }


    @Test
    void createOrder2() { //생성자 주입을 사용하면 다음처럼 주입 데이터를 누락 했을 때 컴파일 오류가 발생
        OrderServiceImpl orderService = new OrderServiceImpl(new MemoryMemberRepository(), new RateDiscountPolicy());
        orderService.createOrder(1L, "itemA", 10000);
    }
}
