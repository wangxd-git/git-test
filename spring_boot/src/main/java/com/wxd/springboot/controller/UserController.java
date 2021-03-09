package com.wxd.springboot.controller;

import com.wxd.springboot.model.User;
import com.wxd.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    IUserService userService;
    @RequestMapping("/userLogin")
     public String getUserList(Model model){
        List<User> userList = userService.getUserList();
        model.addAttribute("userList",userList);
        return "UserLogin";
     }
}
