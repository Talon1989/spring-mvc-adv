package com.fabio.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/access_denied")
    public String notAuth(){
        return "access_denied";
    }

    @GetMapping("login")
    public String login(){
        return "login";
    }

}
