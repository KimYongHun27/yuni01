package com.meta12.yuni01.controller;

import com.meta12.yuni01.dto.AddressDTO;
import com.meta12.yuni01.entity.Address;
import com.meta12.yuni01.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/address/list")
    public String list(Model model)
    {
        //List<Address> list = addressService.getSelectAll();
        model.addAttribute("list", addressService.getSelectAll());//java의 내용을 html에서 쓰기 위한 변환
        return "/address/list";
    }

    @GetMapping("/address/view/{id}")
    public String view(
            Model model,
            @PathVariable("id") Long id
    )
    {
        Address address = addressService.getSelectOne(id);
        if (address == null)
        {
            model.addAttribute("errorCode", "Error2");
            model.addAttribute("errorMsg", "해당 글이 없습니다.");
            return "error/error";
        }
        model.addAttribute("address",address);
        return "/address/view";
    }

    @GetMapping("/address/insert")
    public String insert(Model model)
    {
        return "/address/insert";
    }

    @GetMapping("/address/update/{id}")
    public String update(
            Model model,
            @PathVariable("id") Long id
    )
    {
        Address address = addressService.getSelectOne(id);
        if (address == null)
        {
            model.addAttribute("errorCode", "Error2");
            model.addAttribute("errorMsg", "해당 글이 없습니다.");
            return "error/error";
        }
        model.addAttribute("address",address);
        return "/address/update";
    }
    @GetMapping("/address/delete/{id}")
    public String delete(
            Model model,
            @PathVariable("id") Long id
    )
    {
        Address address = addressService.getSelectOne(id);
        if (address == null)
        {
            model.addAttribute("errorCode", "Error2");
            model.addAttribute("errorMsg", "해당 글이 없습니다.");
            return "error/error";
        }

        model.addAttribute("address",address);
        return "/address/delete";
    }

    @PostMapping("/address/insertProc")
    public String insertProc(AddressDTO addressDTO)
    {
        addressService.setInsert(addressDTO);
        return "redirect:/address/list";//처리 페이지는 리다이렉트로 보내기 때문에 model을 쓸 필요가 없다.
    }

    @PostMapping("/address/updateProc")
    public String updateProc(
            AddressDTO addressDTO
    )
    {
        addressService.setUpdate(addressDTO);
        return "redirect:/address/view/" + addressDTO.getId();
    }

    @PostMapping("/address/deleteProc")
    public String deleteProc(
            AddressDTO addressDTO
    )
    {
        addressService.setDelete(addressDTO);
        return "redirect:/address/list";
    }

}
