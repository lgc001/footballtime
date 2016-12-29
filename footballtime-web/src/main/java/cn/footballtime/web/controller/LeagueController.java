package cn.footballtime.web.controller;

import cn.footballtime.dto.CompetitionDto;
import cn.footballtime.dto.LeagueTableDto;
import cn.footballtime.dto.TeamDto;
import cn.footballtime.web.service.CompetitionService;
import cn.footballtime.web.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/10.
 */
@Controller
@RequestMapping("/league")
public class LeagueController {
    @Autowired
    private CompetitionService competitionService;
    @Autowired
    private TeamService teamService;

    @RequestMapping(value="/{competitionNo:[aA]{1}\\d{2}}")//参数配这种形式时，参数前需要加@PathVariable
    public String index(@PathVariable String competitionNo, Model model) {
        CompetitionDto obj =competitionService.getByCompetitionNo(competitionNo);

        model.addAttribute("title", obj.getFullName());
        model.addAttribute("competitionName", obj.getName());

        List<TeamDto> teamList = teamService.GetTeamListOfCurrentSeason(competitionNo);
        model.addAttribute("teamList", teamList);

        return "league/index";
    }
    /**
     * 联赛总积分榜
     */
    @RequestMapping("/table")
    public String table(Model model) {
        //赛季
        String season = "2008-2009";

        List<LeagueTableDto> tableList=new ArrayList<LeagueTableDto>();
        //table.gt

        return "league/table";
    }

    /**
     * 联赛比赛结果
     */
    @RequestMapping("/result")
    public String result(Model model) {

        return "league/result";
    }
}
