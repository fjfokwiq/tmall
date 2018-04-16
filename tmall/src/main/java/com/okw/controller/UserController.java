package com.okw.controller;

import com.okw.pojo.User;
import com.okw.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    @Qualifier("userService")
    private IUserService userService;

    @RequestMapping("admin_user_list")
    public String listUser(Model model) {
        List<User> users= userService.listUser();
        model.addAttribute("users", users);
        return "admin/listUser";
    }
}
