package com.livenow.week1.controller;

import com.livenow.week1.controller.dto.MemberDeleteResponseDto;
import com.livenow.week1.controller.dto.MemberSaveRequestDto;
import com.livenow.week1.domain.Member;
import com.livenow.week1.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = MemberController.class)
public class MemberControllerTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MockMvc mvc;

    @Test
    public void deleteMember2() throws Exception {
        Member member = Member.builder()
                .id(1L)
                .name("정윤")
                .age(23)
                .build();
        MemberSaveRequestDto memberSaveRequestDto = new MemberSaveRequestDto(member);

        Long id = memberService.save(memberSaveRequestDto).getId();

        mvc.perform(delete("/" + id))
                .andExpect(status().isOk());
    }
}
