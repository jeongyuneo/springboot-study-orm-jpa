package com.livenow.week1.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@SpringBootTest
@Transactional
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private EntityManager em;

    @Test
    void memberGetTeam() {
        //given
//        Member member = Member.builder()
//                .id(1L)
//                .name("나는 정윤")
//                .age(23)
//                .build();
        Team team = Team.builder()
                .id(1L)
                .name("네카라쿠배")
                .build();
        //when
        teamRepository.save(team);
        Team findTeam = teamRepository.findById(1L);
        //Member findMember = memberRepository.findById(1L);
        //then
        Assertions.assertThat(team.getId()).isEqualTo(findTeam.getId());
    }

/*    @Test
    void memberGetTeam2() {
        //given
        Member member = Member.builder()
                .id(1L)
                .name("나는 정윤")
                .age(23)
                .build();
        Team team = Team.builder()
                .id(1L)
                .name("네카라쿠배")
                .build();
        member.changeTeam(team);
        //when
        //teamRepository.save(team);
        memberRepository.save(member);
        Member findMember = memberRepository.findById(1L);
        em.flush();
        em.clear();
        Team team2 = teamRepository.findById(1L);
        //then
        Assertions.assertThat(findMember.getTeam()).isNotNull();
        Assertions.assertThat(team2).isNotNull();
    }*/
}
