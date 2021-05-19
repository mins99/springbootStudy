package com.study.spring.board.dto;

import com.study.spring.board.repository.Board;

public class ResponseBoard {

    private final Long boardId;

    public ResponseBoard(Board board) {
        this.boardId = board.getId();
    }
}
