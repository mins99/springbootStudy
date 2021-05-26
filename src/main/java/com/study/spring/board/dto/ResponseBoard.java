package com.study.spring.board.dto;

import com.study.spring.board.domain.Board;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ResponseBoard {

    private final Long boardId;

    private final String title;

    private final String writer;

    private final String contents;

    private final String writeDate;

    @Builder
    public ResponseBoard(Board board) {
        this.boardId = board.getId();
        this.title = board.getTitle();
        this.writer = board.getWriter();
        this.contents = board.getContents();
        this.writeDate = board.getWriteDate().toString();
    }

//    public static ResponseBoard success(Board board) {
//        return ResponseBoard.builder().board(board).build();
//    }
}
