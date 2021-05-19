package com.study.spring.board.repository;

import jdk.nashorn.internal.objects.annotations.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Board {

    @Id
    private Long id;

    @Column
    private String title;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
