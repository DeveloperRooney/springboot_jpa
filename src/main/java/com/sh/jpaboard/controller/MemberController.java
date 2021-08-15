package com.sh.jpaboard.controller;

import com.sh.jpaboard.entity.Member;
import com.sh.jpaboard.service.MemberService;
import com.sh.jpaboard.vo.MemberVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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


}
