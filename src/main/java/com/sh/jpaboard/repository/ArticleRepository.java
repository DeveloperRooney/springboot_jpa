package com.sh.jpaboard.repository;

import com.sh.jpaboard.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    Page<Article> findByTitleContainingOrContentContainingOrWriterContaining(String title,
                                                                             String content,
                                                                             String writer,
                                                                             Pageable pageable);

}
