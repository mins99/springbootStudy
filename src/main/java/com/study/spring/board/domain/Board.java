package com.study.spring.board.domain;

import com.study.spring.board.dto.RequestBoard;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table
public class Board implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String contents;

    @Column(name = "name")
    private String writer;

    @Column
    private LocalDateTime writeDate;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "writer", updatable = false, insertable = false)
//    private User user;

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
