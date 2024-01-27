package com.impact.monster.domain.user.presentation.dto.response.user.detail;

import com.impact.monster.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailResponseDto {
    private String name;
    private String birth;
    private String gender;
    private int weight;
    private int height;
    private int fat;
    private int skeletalMuscle;
    private String target;

}
