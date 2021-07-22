package com.sh.jpaboard.service;

import com.sh.jpaboard.entity.Member;
import com.sh.jpaboard.repository.MemberRepository;
import com.sh.jpaboard.vo.MemberVo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public int login(MemberVo memberVo) {

        Optional<Member> member = memberRepository.findByUserIdAndUserPass(memberVo.getUserId(), memberVo.getUserPass());

        if (member.isPresent()) {
            System.out.println(member);
            return 1;
        }else {
            System.out.println(member);
            return 0;
        }

    }
}
