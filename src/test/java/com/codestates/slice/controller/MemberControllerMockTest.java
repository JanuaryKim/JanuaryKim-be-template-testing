package com.codestates.slice.controller;

import com.codestates.member.dto.MemberDto;
import com.codestates.member.entity.Member;
import com.codestates.member.mapper.MemberMapper;
import com.codestates.member.service.MemberService;
import com.codestates.stamp.Stamp;
import com.google.gson.Gson;
import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class MemberControllerMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private Gson gson;



    @Test
    void postMemberTest() throws Exception {



        //given
        MemberDto.Post post = new MemberDto.Post("hgd@naver.com",
                "홍길동","010-2234-2313");

        Member member = memberMapper.memberPostToMember(post);
        member.setStamp(new Stamp());

        // @SpringBootTest 으로 인해 실제 앱이 띄워졌고, 빈으로 등록 되도록 선언한 클래스들이 (MemberService) 빈으로 등록된 상태인데,
        // 그 중 MemberService 에게 Member 클래스가 매개변수로 들어오고, member 를 리턴하라고 명령을 내려 놓는 부분이라고 생각하자.
        // 그로인해, 실제 MemberService 내부로 들어가지 않고 지정한 member 객체를 리턴해버림.
        given(memberService.createMember(Mockito.any(Member.class)))
                .willReturn(member);

        String content = gson.toJson(post);

        ResultActions actions = mockMvc.perform(
                post("/v11/members")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content)
        );

        MvcResult mvcResult = actions.andExpect(status().isCreated())
                .andExpect(jsonPath("$.data.email").value(post.getEmail()))
                .andExpect(jsonPath("$.data.name").value(post.getName()))
                .andExpect(jsonPath("$.data.phone").value(post.getPhone()))
                .andReturn();


        System.out.println(mvcResult.getResponse().getContentAsString());
    }
}
