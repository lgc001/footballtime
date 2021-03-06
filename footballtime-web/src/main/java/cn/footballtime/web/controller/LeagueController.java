package cn.footballtime.web.controller;

import cn.footballtime.dto.CompetitionDto;
import cn.footballtime.dto.LeagueDto;
import cn.footballtime.dto.LeagueTableDto;
import cn.footballtime.dto.TeamDto;
import cn.footballtime.web.config.AppSetting;
import cn.footballtime.web.service.CompetitionService;
import cn.footballtime.web.service.LeagueService;
import cn.footballtime.web.service.TeamService;
import cn.footballtime.web.util.CommonUtil;
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
    @Autowired
    private LeagueService leagueService;

    @RequestMapping(value="/{code:[aA]{1}\\d{2}}")//参数配这种形式时，参数前需要加@PathVariable
    public String index(@PathVariable String code, Model model) {
        String competitionId = CommonUtil.getCompetitionId(code);

        CompetitionDto obj =competitionService.getCompetitionById(competitionId);

        model.addAttribute("title", obj.getFullName());
        model.addAttribute("competitionName", obj.getName());

        List<TeamDto> teamList = teamService.GetTeamListByCompeitionIdAndSeason(obj.getId(),obj.getCurrentSeason());
        model.addAttribute("teamList", teamList);

        List<LeagueDto> overLeagueList = leagueService.getLeagueListByCompetitionId(obj.getId(),true,1,10);
        model.addAttribute("overLeagueList", overLeagueList);

        List<LeagueDto> futureLeagueList = leagueService.getLeagueListByCompetitionId(obj.getId(),false,1,10);
        model.addAttribute("futureLeagueList", futureLeagueList);

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
