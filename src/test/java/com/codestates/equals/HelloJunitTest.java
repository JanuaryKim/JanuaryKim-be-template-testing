package com.codestates.equals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HelloJunitTest {


    @Test
    @DisplayName("헬로 제이유닛 테스트")
    public void helloJunitTest() {
        String expected = "Hello1";
        String result ="Hello";

        Assertions.assertEquals(expected,result);
    }
}
