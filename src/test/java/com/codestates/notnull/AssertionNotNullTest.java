package com.codestates.notnull;

import com.codestates.crypto.CryptoCurrency;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AssertionNotNullTest {

    @DisplayName("어설트 낫널 테스트")
    @Test
    public void assertNotNullTest() {


        Assertions.assertNotNull(getCryptoCurrency("ETH"), "널이다");
    }

    private String getCryptoCurrency(String key) {

        return CryptoCurrency.map.get(key);
    }
}
