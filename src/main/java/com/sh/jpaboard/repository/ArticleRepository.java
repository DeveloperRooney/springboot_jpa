package com.sh.jpaboard.repository;

import com.sh.jpaboard.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query("select title from Article where title = :title")
    Article findByTitle(String title);

}
