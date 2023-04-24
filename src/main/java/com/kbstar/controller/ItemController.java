package com.kbstar.controller;

import com.kbstar.dto.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/item")
public class ItemController {
    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
    String dir = "item/";
    @RequestMapping("")
    public String main(Model model) {
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"center");
        return "index";
    }
    @RequestMapping("/add")
    public String add(Model model) {
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"add");
        return "index";
    }
    @RequestMapping("/all")
    public String all(Model model) {
        List<Item> list = new ArrayList<>();
        list.add(new Item(1,"tomato1", 100, "a.jp드eg", new Date()));
        list.add(new Item(2,"tomato2", 200, "b.jpeg", new Date()));
        list.add(new Item(3,"tomato3", 300, "c.jpeg", new Date()));
        list.add(new Item(4,"tomato4", 400, "d.jpeg", new Date()));
        list.add(new Item(5,"tomato5", 500, "e.jpeg", new Date()));
        model.addAttribute("ilist", list);
        model.addAttribute("left", dir+"left");
        model.addAttribute("center", dir+"all");
        return "index";
    }

}
