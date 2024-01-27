package com.impact.monster.domain.user.types.target;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TargetType {
    // 벌크업
    BULK,
    // 감량
    LOSEWEIGHT,
    // 유지
    KEEP
}
