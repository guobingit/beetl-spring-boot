package com.gb.test.action;

import com.gb.test.dao.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by guobin on 2017/4/10.
 */
@Controller
@RequestMapping("test")
public class UserAction {

    @Resource
    private UserDao userDao;

    @RequestMapping("user")
    public String index(Model model){
        model.addAttribute("user",userDao.findById(2));
        return "test/user";
    }
}
