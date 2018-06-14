package com.sh.beetl.action;

import javax.annotation.Resource;
import com.sh.beetl.dao.UserDao;
import com.sh.beetl.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexAction {
	
	@Resource
	private UserDao userDao;
	
	@RequestMapping("/demo")
	public String index(Model model) {
		User user = userDao.findById(1);
		model.addAttribute("user", user);
		return "test/index";
	}
}
