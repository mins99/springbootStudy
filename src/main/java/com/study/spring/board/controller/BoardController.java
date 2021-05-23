package com.study.spring.board.controller;

import com.study.spring.board.dto.RequestBoard;
import com.study.spring.board.dto.ResponseBoard;
import com.study.spring.board.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public List<ResponseBoard> getBoardList() {
        return boardService.getBoardList().stream().map(ResponseBoard::new).collect(Collectors.toList());
    }

    @PostMapping("/board")
    public ResponseBoard getBoardContent(@RequestBody Map<String, Long> id) {
        //return ResponseBoard.success(boardService.getBoardContent(id));
        return ResponseBoard.builder().board(boardService.getBoardContent(id.get("id"))).build();
    }

    @PostMapping("/create")
    public void createBoardContent(@RequestBody RequestBoard board) {
        boardService.createBoardContent(board);
    }

    @PostMapping("/modify")
    public void modifyBoardContent(@RequestBody RequestBoard board) {
        boardService.modifyBoardContent(board);
    }

    @PostMapping("/delete")
    public void deleteBoardContent(@RequestBody Map<String, Long> id) {
        boardService.deleteBoardContent(id.get("id"));
    }

}
