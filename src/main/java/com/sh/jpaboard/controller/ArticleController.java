package com.sh.jpaboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticleController {

    @GetMapping("/")
    public String index() {

        return "index";
    }

    @GetMapping("/article/view")
    public String aritcleView() {

        return "article_view";
    }

    @GetMapping("/article/write")
    public String articleWrite() {

        return "article_write";
    }

}
