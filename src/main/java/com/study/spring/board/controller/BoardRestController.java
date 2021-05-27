package com.study.spring.board.controller;

import com.study.spring.board.domain.User;
import com.study.spring.board.dto.RequestBoard;
import com.study.spring.board.dto.ResponseBoard;
import com.study.spring.board.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class BoardRestController {

    private final BoardService boardService;

    @GetMapping("/list")
    public List<ResponseBoard> getBoardList() {
        return boardService.getBoardList().stream().map(ResponseBoard::new).collect(Collectors.toList());
    }

    @GetMapping("/list2")
    public List<ResponseBoard> findBoardList(@PageableDefault Pageable pageable) {
        return boardService.findBoardList(pageable).stream().map(ResponseBoard::new).collect(Collectors.toList());
    }

    @PostMapping("/board")
    public ResponseBoard getBoardContent(@RequestBody Map<String, Long> id) {
        //return ResponseBoard.success(boardService.getBoardContent(id));
        return ResponseBoard.builder().board(boardService.getBoardContent(id.get("id"))).build();
    }

    @GetMapping("/board2")
    public ResponseBoard board(@RequestParam(value = "idx", defaultValue = "0") Long idx) {
        return ResponseBoard.builder().board(boardService.findBoardByIdx(idx)).build();
    }

    @PostMapping("/boards")
    public void createBoardContent(@RequestBody RequestBoard board) {
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
        //HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        board.setWriter(user.getName());
        boardService.createBoardContent(board);
    }

    @PutMapping("/boards/{idx}")
    public void modifyBoardContent(@RequestBody RequestBoard board) {
        boardService.modifyBoardContent(board);
    }

    @DeleteMapping("/boards/{idx}")
    public void deleteBoardContent(@PathVariable("idx") Long idx) {
        boardService.deleteBoardContent(idx);
    }

}
