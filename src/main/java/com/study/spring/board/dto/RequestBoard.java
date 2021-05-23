package com.study.spring.board.dto;

import lombok.Getter;

@Getter
public class RequestBoard {

    private Long boardId;

    private String writer;

    private String title;

    private String contents;

}
