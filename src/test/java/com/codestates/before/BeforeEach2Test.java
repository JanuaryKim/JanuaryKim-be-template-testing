package com.codestates.before;

import org.junit.jupiter.api.*;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class BeforeEach2Test {

    private Map<String,String> cryptoCurrency;

    @BeforeEach
    public void init() {
        cryptoCurrency = new HashMap();
        cryptoCurrency.put("BTC", "Bitcoin");
        cryptoCurrency.put("ADA", "ADA");
        cryptoCurrency.put("POT", "Polkadot");

    }



    @DisplayName("첫번째 각각 테스트")
    @Test
    public void eachTest1() {
        cryptoCurrency.put("ETH","eth");
        Assertions.assertDoesNotThrow(()->getCryptoCurrency("ETH"));
    }

    @DisplayName("두번째 각각 테스트")
    @Test
    public void eachTest2() {
        Assertions.assertThrows(NullPointerException.class, ()-> getCryptoCurrency("ETH"));
    }

    private String getCryptoCurrency(String key) {
        return cryptoCurrency.get(key).toUpperCase(Locale.ROOT);
    }
}
