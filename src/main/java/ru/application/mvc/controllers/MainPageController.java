package ru.application.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    @GetMapping()
    public String mainPage() {
        return "main/index";
    }
}
