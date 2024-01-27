package com.impact.monster.domain.user.presentation.dto.request.info;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HeightChangeRequestDto {
    private int height;
    private String email;
}
