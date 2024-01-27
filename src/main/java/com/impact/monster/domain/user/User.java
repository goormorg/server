package com.impact.monster.domain.user;

import com.impact.monster.domain.user.types.gender.GenderType;
import com.impact.monster.domain.user.types.target.TargetType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

@Entity @Table
@Getter @NoArgsConstructor(access = AccessLevel.PROTECTED) @ToString
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    private int weight;
    private int height;
    @Enumerated(EnumType.STRING)
    private GenderType gender;
    @Max(100)
    @Min(0)
    private int fat; // 체지방률 (단위 : %)
    @Max(100)
    @Min(0)
    private int skeletalMuscle; // 골격근량 (단위 : %)
    @Enumerated(EnumType.STRING)
    private TargetType target; // BULK, LOSEWEIGHT, KEEP
    private String interest;

    @Builder
    public User(
            Long id, String name, String email, String password,
            int weight, int height, GenderType gender, int fat,
            int skeletalMuscle, TargetType target, String interest
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.weight = weight;
        this.height = height;
        this.gender = gender;
        this.fat = fat;
        this.skeletalMuscle = skeletalMuscle;
        this.target = target;
        this.interest = interest;
    }
}