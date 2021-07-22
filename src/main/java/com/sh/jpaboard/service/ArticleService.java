package com.sh.jpaboard.service;

import com.sh.jpaboard.entity.Article;
import com.sh.jpaboard.repository.ArticleRepository;
import com.sh.jpaboard.vo.ArticleVo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    private ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public void insert(ArticleVo articleVo) {

        articleVo.setRegDate(LocalDateTime.now());
        articleVo.setUpdateDate(LocalDateTime.now());

        articleRepository.save(articleVo.toEntity());
    }

    public ArticleVo articleView(Long id) {

        Optional<Article> optArticle = articleRepository.findById(id);

        Article article = optArticle.get();

        ArticleVo articleVo = ArticleVo.builder()
                .id(article.getId())
                .writer(article.getWriter())
                .regDate(article.getRegDate())
                .title(article.getTitle())
                .content(article.getContent())
                .build();

        return articleVo;
    }

    public List<Article> articleList() {
        List<Article> list = articleRepository.findAll();
        return list;
    }
}
