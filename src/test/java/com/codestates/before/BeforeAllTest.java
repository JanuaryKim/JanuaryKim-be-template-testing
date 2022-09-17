package com.codestates.before;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class BeforeAllTest {
    private static Map<String,String> cryptoCurrency;

    @BeforeAll
    public static void init() { //@BeforeAll 가 붙은 메소드는 static 이여야함.
        cryptoCurrency = new HashMap();
        cryptoCurrency.put("BTC", "Bitcoin");
        cryptoCurrency.put("ADA", "ADA");
        cryptoCurrency.put("POT", "Polkadot");

    }

    @DisplayName("첫번째 테스트")
    @Test
    public void eachTest1() {
        cryptoCurrency.put("ETH","eth");
        Assertions.assertDoesNotThrow(()->getCryptoCurrency("ETH"));
    }

    @DisplayName("두번째 테스트")
    @Test
    public void eachTest2() { //BeforeAll은 최초 한번만 실행되므로 eachTest1에서 cryptoCurrency에 put을 한 상태에서 다시 초기화 되지 않는다.
        Assertions.assertDoesNotThrow(()->getCryptoCurrency("ETH"));
    }

    private String getCryptoCurrency(String key) {
        return cryptoCurrency.get(key).toUpperCase(Locale.ROOT);
    }
}
