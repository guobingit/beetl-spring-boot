package com.gb.test.action;

import com.gb.test.service.BookService;
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

    @Resource
    private BookService bookService;

    @RequestMapping("book")
    public void book(){

       // List books = sqlManager.select("book.find", Map.class,null);
        List books = sqlManager.execute("select * from ssreader limit 10", Map.class,null);
        System.out.println("success");
    }

    @RequestMapping("bookupdate")
    public void bookupdate(){
        bookService.bupdate();
    }

}
