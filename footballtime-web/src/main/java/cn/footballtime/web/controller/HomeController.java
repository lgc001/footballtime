package cn.footballtime.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/9/8.
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String  index(Model model)
    {
        model.addAttribute("title", "首页");

        return "home/index";
    }
}
