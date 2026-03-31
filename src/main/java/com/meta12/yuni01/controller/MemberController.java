package com.meta12.yuni01.controller;

import com.meta12.yuni01.dto.MemberDTO;
import com.meta12.yuni01.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/member/list")
    public String list(){

        return "member/list";
    }

     @GetMapping("/member/view")
    public String view(){

        return "member/view";
    }

     @GetMapping("/member/insert")
    public String insert(){

        return "member/insert";
    }

     @PostMapping("/member/insertProc")
    public String insertProc(MemberDTO memberDTO){
        memberService.setInsert(memberDTO);
        return "redirect:/member/list";
    }

     @GetMapping("/member/update")
    public String update(){

        return "member/update";
    }

    @PostMapping("/member/updateProc")
    public String updateProc(){

         return "redirect:/member/list";
    }

     @GetMapping("/member/delete")
    public String delete(){

        return "member/delete";
    }

    @PostMapping("/member/deleteProc")
    public String deleteProc(){

         return "redirect:/member/list";
    }

}
