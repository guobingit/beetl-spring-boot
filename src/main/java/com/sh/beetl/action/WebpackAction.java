package com.sh.beetl.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("wp")
public class WebpackAction {
	
	@RequestMapping("demo")
	public String demo(){
		return "/webpack/hello";
	}
}
