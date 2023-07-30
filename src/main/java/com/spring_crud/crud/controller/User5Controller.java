package com.spring_crud.crud.controller;

import com.spring_crud.crud.domain.User5;
import com.spring_crud.crud.request.User5Create;
import com.spring_crud.crud.request.User5Update;
import com.spring_crud.crud.request.cond.User5SearchCond;
import com.spring_crud.crud.response.User5UpdateForm;
import com.spring_crud.crud.service.User5Service;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user5")
public class User5Controller {
    private final User5Service user5Service;

    @GetMapping("/members")
    public String userList(@ModelAttribute("userCond") User5SearchCond userCond, Model model) {
        List<User5> members = user5Service.getList(userCond);
        model.addAttribute("members", members);
        return "user5/members";
    }

    @GetMapping("/members/create-form")
    public String userCreateForm(Model model) {
        model.addAttribute("dto", new User5Create());
        return "user5/memberCreate";
    }

    @PostMapping("/members")
    public String createUser(@Valid User5Create dto) {
        Long uid = user5Service.create(dto);
        return String.format("redirect:members/%d", uid);
    }

    @GetMapping("/members/{uid}")
    public String userDetail(@PathVariable Long uid, Model model) {
        User5 findOne = user5Service.getOne(uid);
        model.addAttribute("user", findOne);
        return "user5/member";
    }

    @GetMapping("/members/{uid}/updateForm")
    public String userUpdateForm(@PathVariable Long uid, Model model) {
        User5UpdateForm updateForm = user5Service.getUpdateForm(uid);
        model.addAttribute("user", updateForm);
        return "user5/memberUpdate";
    }

    @PostMapping("/members/{uid}/update")
    public String userUpdate(@PathVariable Long uid, @Valid User5Update dto) {
        Long userId = user5Service.updateUser(uid, dto);
        return String.format("redirect:/user5/members/%d", userId);
    }

    @PostMapping("/members/{uid}/delete")
    public String userDelete(@PathVariable Long uid) {
        user5Service.deleteUser(uid);
        return "redirect:/user5/members";
    }
}
