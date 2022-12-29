package org.example.customer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class MenuTest {

    @DisplayName("메뉴판에서 메뉴이름에 해당하는 메뉴를 반환한다.")
    @Test
    void chooseTest() {
        Menu menu = new Menu(List.of(new MenuItem("돈까스", 5000), new MenuItem("냄면", 4000)));

        MenuItem menuItem = menu.choose("돈까스");

        assertThat(menuItem).isEqualTo(new MenuItem("돈까스", 5000));
    }

    @DisplayName("메뉴판에 없는 메뉴를 선택할시 예외를 반환한다.")
    @Test
    void chooseTest2() {
        Menu menu = new Menu(List.of(new MenuItem("돈까스", 5000), new MenuItem("냄면", 4000)));
        assertThatCode(()-> menu.choose("통닥"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 메뉴다요");
    }
}
