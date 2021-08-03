package com.sh.jpaboard.service;

import com.sh.jpaboard.entity.Member;
import com.sh.jpaboard.repository.MemberRepository;
import com.sh.jpaboard.vo.MemberVo;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService implements UserDetailsService {

    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public UserDetails login(MemberVo memberVo) {

        Optional<Member> optMember = memberRepository.findByUserIdAndUserPass(memberVo.getUserId(), memberVo.getUserPass());

        Member member = new Member();



        if(optMember.isPresent()) {
            member = optMember.get();
        }

        return User.builder()
                .username(member.getUserId())
                .password(member.getUserPass())
                .build();

    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Member member = memberRepository.findByUserId(userId);

        return User.builder()
                .username(member.getUserId())
                .password(member.getUserPass())
                .build();
    }
}
