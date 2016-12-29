package cn.footballtime.web.controller;

import cn.footballtime.web.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;


	@RequestMapping("/index")
	public String product(Model model) {

		model.addAttribute("name", testService.test());
		model.addAttribute("price", "This is price1 ");
		model.addAttribute("users", new String[]{"Tom112","Jack2","Rose3"});

		return "test/product";
	}
}
