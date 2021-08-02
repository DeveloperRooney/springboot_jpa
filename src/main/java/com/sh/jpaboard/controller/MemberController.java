package com.sh.jpaboard.controller;

import com.sh.jpaboard.entity.Member;
import com.sh.jpaboard.service.MemberService;
import com.sh.jpaboard.vo.MemberVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/user/login")
    public String login() {

        return "login";
    }

    @PostMapping("/user/login")
    public String login(MemberVo memberVo) {

        System.out.println("넘어옴");
        
        System.out.println(memberVo.getUserId());
        System.out.println(memberVo.getUserPass());

        memberService.loadUserByUsername(memberVo.getUserId());

        return "redirect:/article/list";
    }

}
