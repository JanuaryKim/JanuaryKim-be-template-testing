package com.codestates.slice.service;

import com.codestates.exception.BusinessLogicException;
import com.codestates.member.entity.Member;
import com.codestates.member.repository.MemberRepository;
import com.codestates.member.service.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class MemberServiceMockTest {

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    @Test
    public void createMemberTest() {

        //given
        Member member = new Member("hgd@naver.com","홍길동","010-1111-1111");
        Optional<Member> optionalMember = Optional.of(member);
        given(memberRepository.findByEmail(Mockito.anyString())).willReturn(optionalMember);

        assertThrows(BusinessLogicException.class, ()-> memberService.createMember(member));
    }

}
