package com.impact.monster.domain.user.service;

import com.impact.monster.domain.user.repository.UserRepository;
import com.impact.monster.global.exception.ErrorCodes.ErrorCode;
import com.impact.monster.global.exception.GlobalException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public Object[] getUserInfo(String email) {
        try {
            if (email == null) {
                throw new GlobalException(ErrorCode.BAD_REQUEST_AUTH);
            }

            Object[] user = userRepository.findDetailByEmail(email);
            return user;
        } catch (GlobalException e) {
            throw new GlobalException(ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }
}
