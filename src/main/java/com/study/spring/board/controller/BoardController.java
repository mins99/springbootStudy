package com.study.spring.board.controller;

import com.study.spring.board.dto.ResponseBoard;
import com.study.spring.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BoardController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/list")
    public List<ResponseBoard> getBoardList() {
        return boardService.getBoardList().stream().map(ResponseBoard::new).collect(Collectors.toList());
    }

    @PostMapping("/board")
    public ResponseBoard getBoardContent(@RequestParam Long id) {
        //return ResponseBoard.success(boardService.getBoardContent(id));
        return ResponseBoard.builder().board(boardService.getBoardContent(id)).build();
    }
}
