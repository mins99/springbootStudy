package com.study.spring.board.controller;

import com.study.spring.board.domain.User;
import com.study.spring.login.annotation.SocialUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class BoardController {

    @GetMapping("/board/list")
    public String getBoardView(@SocialUser User user, HttpServletRequest request) {
        //HttpSession session = request.getSession();
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();

        session.setAttribute("user", user);

        return "board/boardList";
    }

    @GetMapping("/boards/create")
    public String createBoardContent() {
        return "board/form";
    }
}
