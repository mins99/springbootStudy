package com.study.spring.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

    @GetMapping("/board/list")
    public String getBoardView() {
        return "board/boardList";
    }

    @GetMapping("/boards/create")
    public String createBoardContent() {
        return "board/form";
    }
}
