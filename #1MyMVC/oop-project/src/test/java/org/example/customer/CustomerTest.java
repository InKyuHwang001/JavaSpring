package org.example.customer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
/**
 * 음식점에서 음식을 주문하는 과정 구현

 * 요구사항
 * 1.도메인을 구성하는 객체에는 어떤 것들이 있는지 고민
 *      ㄴ손님, 메뉴판, 음식, 요리사
 * 2.객체들 간의 관계를 고민
 *      ㄴ손님 -- 메뉴판
 *      ㄴ손님 -- 요리사
 *      ㄴ요리사 -- 요리
 * 3.동적인 객체를 정적인 타입으로 추상화해서 도메인 모델링 하기
 *      ㄴ손님 -- 손님
 *      ㄴ요리 -- 요리
 *      ㄴ메뉴판 -- 메뉴
 * 4.협력을 설계
 * 5.객체들을 포괗하는 타입에 적절한 책임을 할당
 * 6.구현하기
 */
public class CustomerTest {

    @DisplayName("메뉴이름에 해당하는 요리를 주문한다.")
    @Test
    void orderTest() {
        Customer customer = new Customer();
        Menu menu = new Menu(List.of(new MenuItem("돈까스", 5000), new MenuItem("냄면", 4000)));
        Cooking cooking = new Cooking();

        assertThatCode(()-> {
            customer.order("돈까스", menu, cooking);
        })
                .doesNotThrowAnyException();

    }
}
