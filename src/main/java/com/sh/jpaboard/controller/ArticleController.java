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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/article")
public class ArticleController {

    private ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/list")
    public String index(Model model, @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                        @RequestParam(name = "keyword", required = false) String keyword) {

        Page<Article> articleList = null;

        if(keyword != null) {
            articleList = articleService.articleSearchList(keyword, pageable);
        }else {
            articleList = articleService.articleList(pageable);
        }

        int startPage = Math.max(1, articleList.getPageable().getPageNumber() - 4);

        int endPage = 0;
        if((articleList.getPageable().getPageNumber() + 4) < 10) {
            endPage = Math.min(10, articleList.getTotalPages());
        }else {
            endPage = Math.min(articleList.getTotalPages(), articleList.getPageable().getPageNumber() + 4);
        }

        model.addAttribute("totalArticle", articleList.getTotalElements());
        model.addAttribute("articleList", articleList);
        model.addAttribute("nowPage", pageable.getPageNumber() + 1);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        return "index";
    }

    @GetMapping("/view")
    public String articleView(Model model, long id) {

        ArticleVo article = articleService.articleView(id);

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
