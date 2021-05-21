package com.study.spring.board.repository;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Board {

    @Id
    private Long id;

    @Column
    private String title;

    @Column
    private String contents;

    @Column
    private String writer;

    @Column
    @CreatedDate
    private LocalDateTime writeDate;

}
