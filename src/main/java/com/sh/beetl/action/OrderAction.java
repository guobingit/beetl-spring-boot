package com.sh.beetl.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by guobin on 2017/2/6.
 */
@Controller
@RequestMapping("order")
public class OrderAction {
    @RequestMapping("skip")
    public String skip(){
        return "order/skip";
    }
}
