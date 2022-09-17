package com.codestates.exception;

import com.codestates.crypto.CryptoCurrency;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class AssertionExceptionTest {

    @DisplayName("예외 발생 테스트")
    @Test
    public void assertionThrowExceptionTest() {
        Assertions.assertThrows(NullPointerException.class, ()-> getCryptoCurrency("AA"));
    }

    private String getCryptoCurrency(String key) {
        return CryptoCurrency.map.get(key).toUpperCase(Locale.ROOT);
    }
}
