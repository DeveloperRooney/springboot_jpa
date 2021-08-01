package com.sh.jpaboard.vo;

import com.sh.jpaboard.entity.Article;
import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticleVo {

    private Long id;
    private String writer;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;
    private String title;
    private String content;


    public Article toEntity() {

        Article article = Article.builder()
                .id(id)
                .writer(writer)
                .regDate(regDate)
                .updateDate(updateDate)
                .title(title)
                .content(content)
                .build();

        return article;
    }

}