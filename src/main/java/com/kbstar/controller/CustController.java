package com.kbstar.controller;

import com.kbstar.dto.Cust;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Slf4j
@Controller
@RequestMapping("/cust")
public class CustController {
    //Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    String dir = "cust/";
    @RequestMapping("")
    public String main(Model model) {
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"center");
        //logger.info("---------");//로그 찍자
        Random r = new Random();
        int inx = r.nextInt(1000) + 1;
        log.info(inx+"");
        return "index";
    }
    @RequestMapping("/add")
    public String add(Model model) {
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir + "add");
        return "index";
    }
    @RequestMapping("/all")
    public String all(Model model) {
        List<Cust> list = new ArrayList<>();
        list.add(new Cust("id01","pwd01", "James Lebron"));
        list.add(new Cust("id02","pwd02", "Stephen Curry"));
        list.add(new Cust("id03","pwd03", "Micheal Jordan"));
        list.add(new Cust("id04","pwd04", "James Harden"));
        list.add(new Cust("id05","pwd05", "Kevin Durant"));

        model.addAttribute("clist", list);
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"all");
        return "index";
    }
    @RequestMapping("/get")
    public String get(Model model, String id) {
        Cust cust = new Cust("id01","pwd01", "James Lebron");
        model.addAttribute("gcust", cust);

        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir + "get");
        return "index";
    }

}
