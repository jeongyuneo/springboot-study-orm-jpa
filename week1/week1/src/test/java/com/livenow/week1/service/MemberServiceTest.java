package com.livenow.week1.service;

import com.livenow.week1.controller.dto.MemberDeleteResponseDto;
import com.livenow.week1.controller.dto.MemberSaveRequestDto;
import com.livenow.week1.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    void deleteMember() {
        //given
        Member member = Member.builder()
                .id(1L)
                .name("정윤")
                .age(23)
                .build();
        MemberSaveRequestDto memberSaveRequestDto = new MemberSaveRequestDto(member);

        Long id = memberService.save(memberSaveRequestDto).getId();
        //when
        MemberDeleteResponseDto memberDeleteResponseDto = memberService.delete(id);
        //then
        Assertions.assertThat(member.getId()).isEqualTo(memberDeleteResponseDto.getId());
    }
}
