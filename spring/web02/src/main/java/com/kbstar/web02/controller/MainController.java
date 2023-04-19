package com.kbstar.web02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/")
    public String main(){
        return "index";
    }
    @RequestMapping("/nex")
    public String next(){
        return "next";
    }
    @RequestMapping("/next")
    public String next(Model model){
        model.addAttribute("mydata", "hi");
        return "next";
    }
    @RequestMapping("/second")
    public String second(){
        return "second";
    }


}
