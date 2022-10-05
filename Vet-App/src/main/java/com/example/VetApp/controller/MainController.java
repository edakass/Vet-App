package com.example.VetApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @GetMapping("/login")
    public  String login(){
        return "login";
    }

    @RequestMapping("/main_page")
    public String getPage() {
        return "main_page";
    }

    @RequestMapping("/settings")
    public String getSettingsPage() {
        return "settings";
    }

    @RequestMapping("/detail")
    public String getDetailPage() {
        return "detail";
    }

}
