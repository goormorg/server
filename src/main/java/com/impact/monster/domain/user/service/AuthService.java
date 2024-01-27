package com.impact.monster.domain.user.service;

import com.impact.monster.domain.user.User;
import com.impact.monster.domain.user.presentation.dto.request.auth.SignInRequestDto;
import com.impact.monster.domain.user.presentation.dto.request.auth.SignUpRequestDto;
import com.impact.monster.domain.user.presentation.dto.response.auth.SignInResponseDto;
import com.impact.monster.domain.user.repository.UserRepository;
import com.impact.monster.global.exception.ErrorCodes.ErrorCode;
import com.impact.monster.global.exception.GlobalException;
import com.impact.monster.global.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Value("${jwt.secret}")
    private String secretKey;

    private final Long exprTime = (long) (1000 * 60 * 60);

    @Transactional
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

    @Transactional
    public SignInResponseDto register(SignInRequestDto dto) throws GlobalException {
        String email = dto.getEmail();
        String password = dto.getPassword();
        try {
            if (email == null) {
                throw new GlobalException(ErrorCode.BAD_REQUEST_AUTH);
            }
            String dbPassword = userRepository.findPasswordByEmail(email);
            // 저장된 BCrypt 해시와 입력된 비밀번호를 비교
            boolean passwordMatches = passwordEncoder.matches(password, dbPassword);

            if (!passwordMatches) {
                // 패스워드가 일치하지 않는 경우
                throw new GlobalException(ErrorCode.BAD_REQUEST_AUTH);
            }

            // 인증 성공 시 토큰 생성
            String token = jwtUtil.createJwt(email, secretKey, exprTime);

            System.out.println("token = " + token);
            return new SignInResponseDto(token, email);
        } catch (GlobalException e) {
            throw new GlobalException(ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }
}
