package com.impact.monster.domain.user.presentation;

import com.impact.monster.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/detail")
    public Object[] getList(@RequestParam String email) {
        Object[] result = userService.getUserInfo(email);
        return result;
    }

}
