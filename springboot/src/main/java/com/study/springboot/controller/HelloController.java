package com.study.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


@Controller
public class HelloController {
    @RequestMapping("/success")
    public String success(Map<String,String> map){
        map.put("Hello","你好");
        return "success";
    }

}
