package com.codestates.assumption;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AssumptionTest {

    @DisplayName("어썸션 테스트")
    @Test
    public void assumptionTest() {

        Assumptions.assumeTrue(System.getProperty("os.name").startsWith("Mac"));
//        Assumptions.assumeTrue(System.getProperty("os.name").startsWith("Windows"));
        System.out.println("윈도우가 맞습니다.");
    }
}
