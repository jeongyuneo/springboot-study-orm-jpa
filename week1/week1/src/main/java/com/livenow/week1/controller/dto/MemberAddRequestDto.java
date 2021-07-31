package com.livenow.week1.controller.dto;

import com.livenow.week1.domain.Member;
import com.livenow.week1.domain.Team;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberAddRequestDto {

    private Long teamId;
    private Long memberId;

    public MemberAddRequestDto(Team team, Member member) {
        this.teamId = team.getId();
        this.memberId = member.getId();
    }
}
