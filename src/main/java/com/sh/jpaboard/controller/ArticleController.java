package com.sh.jpaboard.controller;

import com.sh.jpaboard.entity.Article;
import com.sh.jpaboard.service.ArticleService;
import com.sh.jpaboard.vo.ArticleVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/article")
public class ArticleController {

    private ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/list")
    public String index(Model model, @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

        Page<Article> articleList = articleService.articleList(pageable);

        int startPage = Math.max(1, articleList.getPageable().getPageNumber() - 4);
        int endPage = Math.min(articleList.getTotalPages(), articleList.getPageable().getPageNumber() + 4);

        model.addAttribute("articleList", articleList);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        return "index";
    }

    @GetMapping("/view")
    public String articleView(Model model, long id) {

        ArticleVo article = articleService.articleView(id);

        System.out.println(article.getContent());
        System.out.println(article.getTitle());

        model.addAttribute("article", article);

        return "article_view";
    }

    @GetMapping("/write")
    public String articleWrite() {

        return "article_write";
    }

    @PostMapping("/write")
    public String articleWrite(ArticleVo articleVo) {

        return "redirect:/";
    }

}
