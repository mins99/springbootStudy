package com.study.spring.board.controller;

import com.study.spring.board.domain.Board;
import com.study.spring.board.domain.User;
import com.study.spring.board.repository.BoardRepository;
import com.study.spring.board.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BoardControllerTest {
    private final String boardTestTitle = "테스트";

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    UserRepository userRepository;

    @Before
    public void init() {
        User user = userRepository.save(User.builder()
                .name("민성").password("test").build());

        boardRepository.save(Board.builder()
                .title(boardTestTitle).contents("내용입니다").writer(user.getName()).build());
    }

    @Test
    public void 유저생성_게시글등록_테스트() {
        User user = userRepository.findByName("민성");
        assertThat(user.getName(), is("민성"));
        assertThat(user.getPassword(), is("test"));

        Board board = boardRepository.findByWriter("민성");
        assertThat(board.getTitle(), is(boardTestTitle));
        assertThat(board.getContents(), is("내용입니다"));
    }
}
