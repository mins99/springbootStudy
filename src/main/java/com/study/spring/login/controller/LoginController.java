package com.study.spring.login.controller;

import com.study.spring.board.domain.User;
import com.study.spring.login.annotation.SocialUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping({"/", "/login", "/logout"})
    public String login() {
        return "login";
    }

    @GetMapping("/loginSuccess")
    public String loginComplete(@SocialUser User user) {
        return "redirect:/board/list";
    }

    @GetMapping("/loginFailure")
    public String loginFailure() { return "login"; }

}
