package com.meta12.yuni01.service;

import com.meta12.yuni01.dto.MemberDTO;
import com.meta12.yuni01.entity.Member;
import com.meta12.yuni01.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public void getSelectAll(){
        System.out.println("- get select all -");
    }

    public void getSelectOne(){
        System.out.println("- get select one -");
    }

    public void setInsert(MemberDTO memberDTO){
        Member member = new Member();
        member.setUsername(memberDTO.getUsername());
        member.setPassword(memberDTO.getPassword());
        member.setPasswordChk(memberDTO.getPasswordChk());
        member.setName(memberDTO.getName());
        member.setSsn(memberDTO.getSsn());
        member.setPhone(memberDTO.getPhone());
        member.setEmail(memberDTO.getEmail());
        member.setAddress1(memberDTO.getAddress1());
        member.setAddress2(memberDTO.getAddress2());
        member.setAddress3(memberDTO.getAddress3());
        member.setAddress4(memberDTO.getAddress4());
        member.setGrade(memberDTO.getGrade());

        memberRepository.save(member);
    }

    public void setUpdate(){
        System.out.println("- set update -");
    }

    public void setDelete(){
        System.out.println("- set delete -");
    }
}
