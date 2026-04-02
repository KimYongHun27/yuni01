package com.meta12.yuni01.controller;

import com.meta12.yuni01.dto.MemberDTO;
import com.meta12.yuni01.entity.Member;
import com.meta12.yuni01.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/member/list")
    public String list(Model model){
        //DB 데이터 읽어오기
        List<Member> list = memberService.getSelectAll();
        model.addAttribute("list", list);

        return "member/list";//forwording
    }

     @GetMapping("/member/view/{id}")
    public String view(
            Model model,
            @PathVariable("id") Long id
     ){
        Member member = memberService.getSelectOne(id);

        if (member == null)
        {
            model.addAttribute("errorCode", "Error001");
            model.addAttribute("errorMsg", "존재하지 않는 회원입니다.");
            return "error/error";
        }

        model.addAttribute("member", member);
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

     @GetMapping("/member/update/{id}")
    public String update(
             Model model,
             @PathVariable("id") Long id
     ){
         Member member = memberService.getSelectOne(id);

         if (member == null)
         {
             model.addAttribute("errorCode", "Error001");
             model.addAttribute("errorMsg", "존재하지 않는 회원입니다.");
             return "error/error";
         }

         model.addAttribute("member", member);

        return "member/update";
    }

    @PostMapping("/member/updateProc")
    public String updateProc(MemberDTO memberDTO){

        Member member = memberService.getSelectOne(memberDTO.getId());
        if (member == null) {
            return "redirect:/member/list";
        }

        if (!member.getPassword().equals(memberDTO.getPassword())) {
            return "redirect:/member/update/"+ memberDTO.getId();
        }
        else {
            memberDTO.setUsername(member.getUsername());
            memberDTO.setName(member.getName());
            memberDTO.setSsn(member.getSsn());

            memberService.setUpdate(memberDTO);
        }
         return "redirect:/member/view/" + memberDTO.getId();
    }

     @GetMapping("/member/delete/{id}")
    public String delete(
             Model model,
             @PathVariable("id") Long id
     ){
         Member member = memberService.getSelectOne(id);

         if (member == null)
         {
             model.addAttribute("errorCode", "Error001");
             model.addAttribute("errorMsg", "존재하지 않는 회원입니다.");
             return "error/error";
         }

         model.addAttribute("member", member);

        return "member/delete";
    }

    @PostMapping("/member/deleteProc")
    public String deleteProc(MemberDTO memberDTO){
        Member member = memberService.getSelectOne(memberDTO.getId());
        if (member == null) {
            return "redirect:/member/list";
        }

        if (!member.getPassword().equals(memberDTO.getPassword())) {
            return "redirect:/member/list";
        }
        else {
            memberService.setDelete(memberDTO);
        }
         return "redirect:/member/list";
    }

}