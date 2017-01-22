package cn.footballtime.web.controller;

import cn.footballtime.dto.LeagueDto;
import cn.footballtime.web.service.LeagueService;
import cn.footballtime.web.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Administrator on 2016/9/8.
 */
@Controller
public class HomeController {
    @Autowired
    private LeagueService leagueService;

    @RequestMapping("/")
    public String  index(Model model)
    {
        model.addAttribute("title", "首页");

        String competitionId = CommonUtil.getCompetitionId("A01");
        List<LeagueDto> overLeagueList = leagueService.getLeagueListByCompetitionId(competitionId,true,1,10);
        model.addAttribute("leagueListA01", overLeagueList);

        competitionId = CommonUtil.getCompetitionId("A02");
        overLeagueList = leagueService.getLeagueListByCompetitionId(competitionId,true,1,10);
        model.addAttribute("leagueListA02", overLeagueList);

        competitionId = CommonUtil.getCompetitionId("A03");
        overLeagueList = leagueService.getLeagueListByCompetitionId(competitionId,true,1,10);
        model.addAttribute("leagueListA03", overLeagueList);

        competitionId = CommonUtil.getCompetitionId("A04");
        overLeagueList = leagueService.getLeagueListByCompetitionId(competitionId,true,1,10);
        model.addAttribute("leagueListA04", overLeagueList);

        return "home/index";
    }
}
