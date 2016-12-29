package cn.footballtime.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/12/11.
 */
@Controller
@RequestMapping("/team")
public class TeamController {

    @RequestMapping(value="/{teamNo:\\d{1,4}}")//参数配这种形式时，参数前需要加@PathVariable
    public String index(@PathVariable String teamNo, Model model) {


        return "league/index";
    }

    /**
     * 球队赛果
     */
    @RequestMapping("/result")
    public String player() {
        return "star/player";
    }
}
