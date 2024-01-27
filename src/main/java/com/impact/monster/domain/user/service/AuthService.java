package com.impact.monster.domain.user.service;

import com.impact.monster.domain.user.User;
import com.impact.monster.domain.user.presentation.dto.request.auth.SignUpRequestDto;
import com.impact.monster.domain.user.repository.UserRepository;
import com.impact.monster.global.exception.ErrorCodes.ErrorCode;
import com.impact.monster.global.exception.GlobalException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    public void save(SignUpRequestDto dto) {
        try {
            String email = dto.getEmail();
            String name = dto.getName();

            User isExist = userRepository.findByNameAndEmail(email, name);

            if(isExist != null) {
                throw new GlobalException(ErrorCode.USER_ALREADY_EXIST);
            }

            User user = dto.toEntity(passwordEncoder);
            userRepository.save(user);

        } catch (GlobalException e) {
            throw new GlobalException(ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }
}
