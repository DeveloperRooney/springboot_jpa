package com.sh.jpaboard.service;

import com.sh.jpaboard.repository.MemberRepository;
import org.springframework.stereotype.Service;


@Service
public class MemberService{

    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


}
