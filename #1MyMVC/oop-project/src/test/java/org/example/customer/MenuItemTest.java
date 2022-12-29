package org.example.customer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



import static org.assertj.core.api.Assertions.*;
public class MenuItemTest {

    @DisplayName("메뉴항목 생성한다.")
    @Test
    void createTest() {
        assertThatCode(()-> new MenuItem("만두", 5000))
                .doesNotThrowAnyException();
    }
}
