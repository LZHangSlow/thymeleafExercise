package com.example.admin.controller;

import com.example.admin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class DataTableController {

    @GetMapping("/basic_table")
    public String basic_table(){
        return "datatable/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model){
        List<User> users = Arrays.asList(new User("lzh", "123"),
                new User("qwe", "123"),
                new User("zzz", "123"));
        model.addAttribute("users",users);
        return "datatable/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "datatable/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){
        return "datatable/editable_table";
    }
}
