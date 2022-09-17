package com.codestates.after;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AfterAllTest {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("AfterAllTest.beforeAll");
    }


    @DisplayName("첫번째 테스트")
    @Test
    public void test1() {
        System.out.println("AfterAllTest.test1");
    }


    @DisplayName("두번째 테스트")
    @Test
    public void test2() {
        System.out.println("AfterAllTest.test2");
    }
}
