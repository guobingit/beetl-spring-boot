package com.gb.test.action;

import org.beetl.sql.core.SQLManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by guobin on 2017/4/10.
 */
@Controller
@RequestMapping("test")
public class BookAction {

    @Resource
    private SQLManager sqlManager;

    @RequestMapping("book")
    public void book(){

       // List books = sqlManager.select("book.find", Map.class,null);
        List books = sqlManager.execute("select * from ssreader limit 10", Map.class,null);
        System.out.println("success");
    }
}
