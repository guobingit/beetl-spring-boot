package com.gb.test.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeAction {

    @RequestMapping("/")
    public String index(Model model){
        return "index";
    }
}
