package com.gb.test.action;

import com.gb.test.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by guobin on 2017/4/10.
 */
@Controller
@RequestMapping("test")
public class UserAction {

    @Autowired
    private UserDao userDao;

    @RequestMapping("user")
    public String index(Model model){
        model.addAttribute("user",userDao.findById(1));
        return "test/user";
    }
}
