package com.impact.monster.domain.user.presentation;

import com.impact.monster.domain.user.presentation.dto.request.auth.SignUpRequestDto;
import com.impact.monster.domain.user.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    @PostMapping("/signUp")
    public void signUp(@RequestBody SignUpRequestDto dto) {
        authService.save(dto);
    }
}
