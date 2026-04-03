package com.meta12.yuni01.controller;

import com.meta12.yuni01.dto.GuestBookDTO;
import com.meta12.yuni01.entity.GuestBook;
import com.meta12.yuni01.service.GuestBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class GuestBookController {
    private final GuestBookService guestBookService;


    @GetMapping("/guestBook/list")
    public String list(Model model)
    {
        //List<GuestBook> list = guestBookService.getSelectAll();
        model.addAttribute("list", guestBookService.getSelectAll());//java의 내용을 html에서 쓰기 위한 변환
        return "guestBook/list";
    }

    @GetMapping("/guestBook/view/{id}")
    public String view(
            Model model,
            @PathVariable("id") Long id
    )
    {
        GuestBook guestBook = guestBookService.getSelectOne(id);
        if (guestBook == null)
        {
            model.addAttribute("errorCode", "Error2");
            model.addAttribute("errorMsg", "해당 글이 없습니다.");
            return "error/error";
        }
        model.addAttribute("guestBook",guestBook);
        return "guestBook/view";
    }

    @GetMapping("/guestBook/insert")
    public String insert()
    {
        return "guestBook/insert";
    }

    @GetMapping("/guestBook/update/{id}")
    public String update(
            Model model,
            @PathVariable("id") Long id
    )
    {
        GuestBook guestBook = guestBookService.getSelectOne(id);
        if (guestBook == null)
        {
            model.addAttribute("errorCode", "Error2");
            model.addAttribute("errorMsg", "해당 글이 없습니다.");
            return "error/error";
        }
        model.addAttribute("guestBook",guestBook);
        return "guestBook/update";
    }
    @GetMapping("/guestBook/delete/{id}")
    public String delete(
            Model model,
            @PathVariable("id") Long id
    )
    {
        GuestBook guestBook = guestBookService.getSelectOne(id);
        if (guestBook == null)
        {
            model.addAttribute("errorCode", "Error2");
            model.addAttribute("errorMsg", "해당 글이 없습니다.");
            return "error/error";
        }

        model.addAttribute("guestBook",guestBook);
        return "guestBook/delete";
    }

    @PostMapping("/guestBook/insertProc")
    public String insertProc(GuestBookDTO guestBookDTO)
    {
        guestBookService.setInsert(guestBookDTO);
        return "redirect:/guestBook/list";//처리 페이지는 리다이렉트로 보내기 때문에 model을 쓸 필요가 없다.
    }

    @PostMapping("/guestBook/updateProc")
    public String updateProc(
            GuestBookDTO guestBookDTO
    )
    {
        guestBookService.setUpdate(guestBookDTO);
        return "redirect:/guestBook/view/" + guestBookDTO.getId();
    }

    @PostMapping("/guestBook/deleteProc")
    public String deleteProc(
            GuestBookDTO guestBookDTO
    )
    {
        guestBookService.setDelete(guestBookDTO);
        return "redirect:/guestBook/list";
    }

}
