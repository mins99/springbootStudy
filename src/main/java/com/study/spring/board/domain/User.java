package com.study.spring.board.domain;

import com.study.spring.board.enums.SocialType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@NoArgsConstructor
@Table
public class User implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String principal;

    @Column
    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Builder
    public User(String name, String password, String email, String principal, SocialType socialType) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.principal = principal;
        this.socialType = socialType;
    }
}
