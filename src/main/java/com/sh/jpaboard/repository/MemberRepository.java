package com.sh.jpaboard.repository;

import com.sh.jpaboard.entity.Member;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("select userId from Member where userId = :userId and userPass = :userPass")
    Optional<Member> findByUserIdAndUserPass(String userId, String userPass);

    Member findByUserId(String userId);
}
