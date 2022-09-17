package com.codestates.slice.controller;

import com.codestates.member.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class MockBeanTest {

    @MockBean
//    @Autowired
    private MemberService memberService;

    @Test
    void mockBeanAndAutowiredAnnotationTest() {
        /**
         * 빈 전체 조회
         */
//        String[] definitionNames = BeanUtils.getDefinitionNames();
//        for (String definitionName : definitionNames) {
//            Object bean = BeanUtils.getBean(definitionName);
//            System.out.println(bean);
//        }

        String[] definitionNames = BeanUtils.getDefinitionNames();
        for (String definitionName : definitionNames) {
            Object bean = BeanUtils.getBean(definitionName);

            if(bean.getClass().getName().contains("MemberService"))
                System.out.println(bean);
        }
    }
}
