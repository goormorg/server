package com.impact.monster.global.exception;

import com.impact.monster.global.exception.ErrorCodes.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GlobalException extends RuntimeException{
    private final ErrorCode errorCode;
}
