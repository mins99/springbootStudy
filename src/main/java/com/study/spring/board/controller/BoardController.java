package com.study.spring.board.controller;

import com.study.spring.board.dto.ResponseBoard;
import com.study.spring.board.repository.Board;
import com.study.spring.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @PostMapping
    public List<ResponseBoard> getBoardName() {
        return boardService.getBoardList().stream().map(ResponseBoard::new).collect(Collectors.toList());
    }
}
