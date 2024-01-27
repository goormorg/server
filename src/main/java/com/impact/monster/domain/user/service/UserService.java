package com.impact.monster.domain.user.service;

import com.impact.monster.domain.user.User;
import com.impact.monster.domain.user.presentation.dto.request.bmr.BmrRequestDto;
import com.impact.monster.domain.user.presentation.dto.request.info.HeightChangeRequestDto;
import com.impact.monster.domain.user.presentation.dto.request.info.WeightChangeRequestDto;
import com.impact.monster.domain.user.repository.UserRepository;
import com.impact.monster.global.exception.ErrorCodes.ErrorCode;
import com.impact.monster.global.exception.GlobalException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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

    @Transactional(readOnly = true)
    public float getUserBmrInfo(int weight, int height, int age, String gender) {
        try {
            if(gender.equals("MALE")) {
                return (float) (66.47 + (13.75 * weight) + (5 * height) - (6.76 * age));
            }
            return (float) (655.1 + (9.56 * weight) + (1.85 * height) - (4.68 * age));
        } catch (GlobalException e) {
            throw new GlobalException(ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    public void updateWeight(WeightChangeRequestDto dto) {
        try {
            User user = userRepository.findByEmail(dto.getEmail());
            user.setWeight(dto.getWeight());

            userRepository.save(user);
        } catch(GlobalException e) {
            throw new GlobalException(ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Transactional
    public void updateHeight(HeightChangeRequestDto dto) {
        try {
            User user = userRepository.findByEmail(dto.getEmail());
            user.setHeight(dto.getHeight());

            userRepository.save(user);
        } catch(GlobalException e) {
            throw new GlobalException(ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }
}
