package com.codestates.after;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AfterEachTest {

    @AfterEach
    public void afterEach() {
        System.out.println("== AfterEachTest.afterEach ==");
    }


    @DisplayName("첫번째 테스트")
    @Test
    public void eachTest1() {
        System.out.println("AfterEachTest.eachTest1");
    }

    @DisplayName("두번째 테스트")
    @Test
    public void eachTest2() {
        System.out.println("AfterEachTest.eachTest2");
    }

}
