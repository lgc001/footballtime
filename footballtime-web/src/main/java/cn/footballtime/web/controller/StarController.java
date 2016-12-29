package cn.footballtime.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/12/11.
 */
@Controller
@RequestMapping("/star")
public class StarController {
    @RequestMapping("/index")
    public String index() {
        return "star/index";
    }

    @RequestMapping("/player")
    public String player() {
        return "star/player";
    }
}
