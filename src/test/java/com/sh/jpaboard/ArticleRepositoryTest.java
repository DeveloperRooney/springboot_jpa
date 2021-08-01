package com.sh.jpaboard;

import com.sh.jpaboard.entity.Article;
import com.sh.jpaboard.repository.ArticleRepository;
import com.sh.jpaboard.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ArticleRepositoryTest{

    @Autowired
    ArticleService articleService;


    @Test
    public void searchTitle() {

        String title = "案件テスト";

        Article article = articleService.searchTitle(title);

        System.out.println(article.getTitle());

    }
}
