package com.tianshouzhi.security.springboot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by tianshouzhi on 2018/5/17.
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
