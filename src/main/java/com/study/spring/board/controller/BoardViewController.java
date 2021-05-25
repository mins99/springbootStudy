package com.study.spring.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardViewController {

    @GetMapping("/boardView")
    public String getBoardView() {
        return "thymeleaf/boardView";
    }
}
