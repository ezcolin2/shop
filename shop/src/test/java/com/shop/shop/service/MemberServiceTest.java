package com.shop.shop.service;

import com.shop.shop.dto.MemberFormDto;
import com.shop.shop.entity.Member;
import jakarta.transaction.Transactional;
//import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
@Transactional
public class MemberServiceTest {
    @Autowired
    private MemberService memberService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Member createMember() {
        MemberFormDto memberFormDto = new MemberFormDto();
        memberFormDto.setName("chulsoo");
        memberFormDto.setEmail("chulsoo@daum.net");
        memberFormDto.setPassword("000000");
        memberFormDto.setAddress("서울특별시");

        Member member = Member.createMember(memberFormDto, passwordEncoder);
        return member;
    }

    @Test
    @DisplayName("회원가입 테스트")
    public void saveMemberTest() {
        Member member = createMember();
        Member createdMember = memberService.saveMember(member);
        Assertions.assertEquals(member.getName(), createdMember.getName());
        Assertions.assertEquals(member.getEmail(), createdMember.getEmail());
        Assertions.assertEquals(member.getAddress(), createdMember.getAddress());
        Assertions.assertEquals(member.getPassword(), createdMember.getPassword());
    }

    @Test
    public void 중복_회원가입_테스트() {
        Member member = createMember();
        memberService.saveMember(member);
        Assertions.assertThrows(IllegalStateException.class,
                () -> memberService.saveMember(member)
        );
    }
}
