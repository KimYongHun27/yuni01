package com.meta12.yuni01.controller;

import com.meta12.yuni01.dto.QnaDTO;
import com.meta12.yuni01.entity.Qna;
import com.meta12.yuni01.service.QnaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class QnaController {
    private final QnaService qnaService;


    @GetMapping("/qna/list")
    public String list(Model model)
    {
        //List<Qna> list = qnaService.getSelectAll();
        model.addAttribute("list", qnaService.getSelectAll());//java의 내용을 html에서 쓰기 위한 변환
        return "qna/list";
    }

    @GetMapping("/qna/view/{id}")
    public String view(
            Model model,
            @PathVariable("id") Long id
    )
    {
        Qna qna = qnaService.getSelectOne(id);
        if (qna == null)
        {
            model.addAttribute("errorCode", "Error2");
            model.addAttribute("errorMsg", "해당 글이 없습니다.");
            return "error/error";
        }
        model.addAttribute("qna",qna);
        return "qna/view";
    }

    @GetMapping("/qna/insert")
    public String insert()
    {
        return "qna/insert";
    }

    @GetMapping("/qna/update/{id}")
    public String update(
            Model model,
            @PathVariable("id") Long id
    )
    {
        Qna qna = qnaService.getSelectOne(id);
        if (qna == null)
        {
            model.addAttribute("errorCode", "Error2");
            model.addAttribute("errorMsg", "해당 글이 없습니다.");
            return "error/error";
        }
        model.addAttribute("qna",qna);
        return "qna/update";
    }
    @GetMapping("/qna/delete/{id}")
    public String delete(
            Model model,
            @PathVariable("id") Long id
    )
    {
        Qna qna = qnaService.getSelectOne(id);
        if (qna == null)
        {
            model.addAttribute("errorCode", "Error2");
            model.addAttribute("errorMsg", "해당 글이 없습니다.");
            return "error/error";
        }

        model.addAttribute("qna",qna);
        return "qna/delete";
    }

    @PostMapping("/qna/insertProc")
    public String insertProc(QnaDTO qnaDTO)
    {
        qnaService.setInsert(qnaDTO);
        return "redirect:/qna/list";//처리 페이지는 리다이렉트로 보내기 때문에 model을 쓸 필요가 없다.
    }

    @PostMapping("/qna/updateProc")
    public String updateProc(
            QnaDTO qnaDTO
    )
    {
        qnaService.setUpdate(qnaDTO);
        return "redirect:/qna/view/" + qnaDTO.getId();
    }

    @PostMapping("/qna/deleteProc")
    public String deleteProc(
            QnaDTO qnaDTO
    )
    {
        qnaService.setDelete(qnaDTO);
        return "redirect:/qna/list";
    }

}
