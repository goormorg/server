package com.impact.monster.domain.user.presentation.dto.request.bmr;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BmrRequestDto {
    private float weight;
    private float height;
    private float age;
}
