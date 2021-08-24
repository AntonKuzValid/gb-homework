package ru.geekbrains.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/alive")
public class AliveController {

    private final Date upDate;

    public AliveController() {
        this.upDate = new Date();
    }

    @GetMapping
    public String lifeCheck() {
        return upDate.toString();
    }
}
