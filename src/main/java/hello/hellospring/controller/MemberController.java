package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller//spring bean에 등록하기 위함
public class MemberController {

    private final MemberService memberService;
    
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
}
