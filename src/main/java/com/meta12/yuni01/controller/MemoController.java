package com.meta12.yuni01.controller;

import com.meta12.yuni01.dto.MemoDTO;
import com.meta12.yuni01.entity.Memo;
import com.meta12.yuni01.service.MemoService;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MemoController {

    private final MemoService memoService;

    @GetMapping("/memo/list")
    public String list(Model model)
    {
        //List<Memo> list = memoService.getSelectAll();
        model.addAttribute("list", memoService.getSelectAll());//java의 내용을 html에서 쓰기 위한 변환
        return "memo/list";
    }

    @GetMapping("/memo/view/{id}")
    public String view(
            Model model,
            @PathVariable("id") Long id
    )
    {
        Memo memo = memoService.getSelectOne(id);
        if (memo == null)
        {
            model.addAttribute("errorCode", "Error2");
            model.addAttribute("errorMsg", "해당 글이 없습니다.");
            return "error/error";
        }
        model.addAttribute("memo",memo);
        return "memo/view";
    }

    @GetMapping("/memo/insert")
    public String insert(Model model)
    {
        return "memo/insert";
    }

    @GetMapping("/memo/update/{id}")
    public String update(
            Model model,
            @PathVariable("id") Long id
    )
    {
        Memo memo = memoService.getSelectOne(id);
        if (memo == null)
        {
            model.addAttribute("errorCode", "Error2");
            model.addAttribute("errorMsg", "해당 글이 없습니다.");
            return "error/error";
        }
        model.addAttribute("memo",memo);
        return "memo/update";
    }
    @GetMapping("/memo/delete/{id}")
    public String delete(
            Model model,
            @PathVariable("id") Long id
    )
    {
        Memo memo = memoService.getSelectOne(id);
        if (memo == null)
        {
            model.addAttribute("errorCode", "Error2");
            model.addAttribute("errorMsg", "해당 글이 없습니다.");
            return "error/error";
        }

        model.addAttribute("memo",memo);
        return "memo/delete";
    }

    @PostMapping("/memo/insertProc")
    public String insertProc(MemoDTO memoDTO)
    {
        memoService.setInsert(memoDTO);
        return "redirect:/memo/list";//처리 페이지는 리다이렉트로 보내기 때문에 model을 쓸 필요가 없다.
    }

    @PostMapping("/memo/updateProc")
    public String updateProc(
            MemoDTO memoDTO
    )
    {
        memoService.setUpdate(memoDTO);
        return "redirect:/memo/view/" + memoDTO.getId();
    }

    @PostMapping("/memo/deleteProc")
    public String deleteProc(
            MemoDTO memoDTO
    )
    {
        memoService.setDelete(memoDTO);
        return "redirect:/memo/list";
    }

}
