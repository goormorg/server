package com.impact.monster.domain.user.presentation.dto.request.info;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WeightChangeRequestDto {
    private int weight;
    private String email;
}
