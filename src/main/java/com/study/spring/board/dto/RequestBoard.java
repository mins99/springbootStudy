package com.study.spring.board.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class RequestBoard {

    private Long boardId;

    @Setter
    private String writer;

    private String title;

    private String contents;

}
