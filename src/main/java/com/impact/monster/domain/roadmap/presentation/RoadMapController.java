package com.impact.monster.domain.roadmap.presentation;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roadmap")
public class RoadMapController {
    @PostMapping
    public void upload() {

    }
}
