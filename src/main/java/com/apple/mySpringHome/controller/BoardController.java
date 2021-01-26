package com.apple.mySpringHome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")   // 경로 지정
public class BoardController {

    @GetMapping("/list")
    public String list() {
        return "board/list";
    }
}
