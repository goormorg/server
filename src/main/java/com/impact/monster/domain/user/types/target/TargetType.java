package com.impact.monster.domain.user.types.target;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TargetType {
    // 벌크업
    BULK,
    // 감량
    LOSE_WEIGHT,
    // 유지
    KEEP,
    // 건강한 생활
    HEALTHY_LIFE
}
