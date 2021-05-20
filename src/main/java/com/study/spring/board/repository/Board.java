package com.study.spring.board.repository;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Board {

    @Id
    private Long id;

    @Column
    private String title;
}
