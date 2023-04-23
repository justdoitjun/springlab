package com.kbstar.controller;

import com.kbstar.dto.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/tables")
public class ItemController {
    @RequestMapping("")
    public String tables(Model model) {
        List<Item> list = new ArrayList<>();

        for(int i=1 ; i <= 100 ; i++ ){
            list.add(new Item(i, "Item"+ i, Math.round((Math.random()*10000)), "a.jpg", new Date()));
        }
        model.addAttribute("itemList", list);
        model.addAttribute("center", "tables/hiddenTables");
        return "index";
    }


}
