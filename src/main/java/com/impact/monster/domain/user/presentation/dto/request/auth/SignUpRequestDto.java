package com.impact.monster.domain.user.presentation.dto.request.auth;

import com.impact.monster.domain.user.User;
import com.impact.monster.domain.user.types.gender.GenderType;
import com.impact.monster.domain.user.types.target.TargetType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequestDto {
    private String name;
    private String email;
    private String password;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birth;
    private String phoneNumber;
    private String gender;
    private int weight;
    private int height;
    private int fat;
    private int skeletalMuscle;
    private String target;

    public User toEntity(BCryptPasswordEncoder passwordEncoder) {
        String encodedPassword = passwordEncoder.encode(password);
        return User.builder()
                .name(name)
                .email(email)
                .password(encodedPassword)
                .birth(java.sql.Date.valueOf(birth))
                .gender(GenderType.valueOf(gender))
                .phoneNumber(phoneNumber)
                .weight(weight)
                .height(height)
                .fat(fat)
                .skeletalMuscle(skeletalMuscle)
                .target(TargetType.valueOf(target))
                .build();
    }
}
