package com.sh.jpaboard.vo;

import com.sh.jpaboard.entity.Article;
import com.sh.jpaboard.entity.Member;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberVo {

    private Long id;

    private String userId;

    private String userPass;

    private LocalDateTime regDate;

    private LocalDateTime loginDate;

    public Member toEntity() {
        Member member = Member.builder()
                .id(id)
                .userId(userId)
                .userPass(userPass)
                .regDate(regDate)
                .loginDate(loginDate)
                .build();

        return member;
    }

}
