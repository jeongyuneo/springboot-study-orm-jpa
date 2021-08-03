package com.livenow.week1.controller.dto;

import com.livenow.week1.domain.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberDeleteResponseDto {

    private Long id;

    public MemberDeleteResponseDto(Member entity) {
        this.id = entity.getId();
    }
}
