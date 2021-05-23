package com.study.spring.board.repository;

import com.study.spring.board.dto.RequestBoard;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Board {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String title;

    @Column
    private String contents;

    @Column
    private String writer;

    @Column
    private LocalDateTime writeDate;

    @Builder
    public Board(String title, String contents, String writer) {
        this.title = title;
        this.contents = contents;
        this.writer = writer;
        this.writeDate = LocalDateTime.now();
    }

    public void updateBoard(RequestBoard board) {
        this.title = board.getTitle();
        this.contents = board.getContents();
    }

}
