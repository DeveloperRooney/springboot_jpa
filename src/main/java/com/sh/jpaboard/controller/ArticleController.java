package com.sh.jpaboard.controller;

import com.sh.jpaboard.entity.Article;
import com.sh.jpaboard.service.ArticleService;
import com.sh.jpaboard.vo.ArticleVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class ArticleController {

    private ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }


    @GetMapping("/")
    public String index(Model model) {

        model.addAttribute("articleList", articleService.articleList());

        return "index";
    }

    @GetMapping("/article/view")
    public String articleView(Model model, long id) {

        ArticleVo article = articleService.articleView(id);

        System.out.println(article.getContent());
        System.out.println(article.getTitle());

        model.addAttribute("article", article);

        return "article_view";
    }

    @GetMapping("/article/write")
    public String articleWrite() {

        return "article_write";
    }

    @PostMapping("/article/write")
    public String articleWrite(ArticleVo articleVo) {

        System.out.println(articleVo.getTitle());
        System.out.println(articleVo.getContent());

        articleVo.setWriter(1L);
        articleService.insert(articleVo);

        return "redirect:/";
    }

}
