package com.livenow.week1.controller.dto;

import com.livenow.week1.domain.Team;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TeamSaveResponseDto {

    private Long id;

    public TeamSaveResponseDto(Team entity) {
        this.id = entity.getId();
    }
}
