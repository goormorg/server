package com.impact.monster.domain.user.presentation;

import com.impact.monster.domain.user.presentation.dto.request.bmr.BmrRequestDto;
import com.impact.monster.domain.user.presentation.dto.request.info.HeightChangeRequestDto;
import com.impact.monster.domain.user.presentation.dto.request.info.WeightChangeRequestDto;
import com.impact.monster.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/bmr")
    public float getBmr(@RequestParam("weight") int weight,
                       @RequestParam("height") int height,
                       @RequestParam("age") int age,
                        @RequestParam("gender") String gender)  {
        float result = userService.getUserBmrInfo(weight, height, age, gender);
        return result;
    }

    @PutMapping("/info-change/weight")
    public void weightChange(@RequestBody WeightChangeRequestDto dto) {
        userService.updateWeight(dto);
    }

    @PutMapping("/info-change/height")
    public void heightChange(@RequestBody HeightChangeRequestDto dto) {
        userService.updateHeight(dto);
    }
}
