package cn.footballtime.api.controller;

import cn.footballtime.api.config.AppSetting;
import cn.footballtime.api.model.League;
import cn.footballtime.api.model.Team;
import cn.footballtime.api.service.ConfigService;
import cn.footballtime.api.service.LeagueService;
import cn.footballtime.api.service.TeamService;
import cn.footballtime.dto.common.ResponseDto;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2016/9/7 0007.
 */
@Controller
@RequestMapping("/dataImport")
public class DataImportController {

    @Autowired
    private TeamService _teamService;

    @Autowired
    private LeagueService _leagueService;

    @Autowired
    private static ConfigService _configService;

    @RequestMapping("/insertTeam")
    @ResponseBody
    public ResponseDto insertTeam(String jsonMsg,String securityKey)
    {
        String realSecurityKey = AppSetting.getApiSecurityKey();
        if(!realSecurityKey.equals(securityKey))
        {
            return new ResponseDto();
        }

        //http://localhost:8080/api/dataImport/insertTeam?jsonMsg={"teamNo":"679","name":"加尔斯","fullName":"加尔斯","competitionId":"21"}
        ResponseDto dto=new ResponseDto();

        Gson gson=new Gson();
        Team newTeam = gson.fromJson(jsonMsg,Team.class);
        if(StringUtils.isEmpty(newTeam.getTeamNo()))
        {
            dto.setCode("1");
            dto.setMsg("编号不能为空");

            return dto;
        }

        Team oldTeam = _teamService.findByTeamNo(newTeam.getTeamNo());
        if(oldTeam == null)
        {
            boolean result = _teamService.insert(newTeam);
            dto.setCode(result?"0":"1");
        }
        else
        {
            if(newTeam.getName() == oldTeam.getName() && newTeam.getFullName() == oldTeam.getFullName() && newTeam.getCompetitionId() == oldTeam.getCompetitionId())
            {
                dto.setCode("0");
            }
            else
            {
                boolean result = _teamService.updateTeamByTeamNo(newTeam);
                dto.setCode(result?"0":"1");
            }
        }

        return dto;
    }

    @RequestMapping("/insertLeague")
    @ResponseBody
    public ResponseDto insertLeague(String jsonMsg,String securityKey)
    {
        String realSecurityKey = AppSetting.getApiSecurityKey();
        if(!realSecurityKey.equals(securityKey))
        {
            return new ResponseDto();
        }

//        --导联赛数据
//        insert into FootballNew.dbo.League(LeagueNo, CompetitionId, Season, Round, BjTime, HomeTeamNo, GuestTeamNo, HalfScore, FullScore, HDrillmasterId, GDrillmasterId, UmpireId)
//        select ID, GAMENAMEID, MATCHSEASON, LUNCI, BEIJINGTIME, HID, VID, HALFSCORE, FULLSCORE, HDRILLMASTERID, VDRILLMASTERID, UMPIREID from PEILV.FB_LEAGUEDATA where GAMENAMEID<=5

        //http://localhost:8080/api/dataImport/insertLeague?jsonMsg={"teamNo":"679","name":"加尔斯","fullName":"加尔斯","competitionId":"21"}
        ResponseDto dto=new ResponseDto();

        Gson gson=new Gson();
        League newLeague = gson.fromJson(jsonMsg,League.class);
        if(StringUtils.isEmpty(newLeague.getLeagueNo()))
        {
            dto.setCode("1");
            dto.setMsg("编号不能为空");

            return dto;
        }

        League oldLeague = _leagueService.findByLeagueNo(newLeague.getLeagueNo());
        if(oldLeague == null)
        {
            boolean result = _leagueService.insert(newLeague);
            dto.setCode(result?"0":"1");
        }
        else
        {
            if(newLeague.getBjTime() == oldLeague.getBjTime() && newLeague.getHalfScore() == oldLeague.getHalfScore() && newLeague.getFullScore() == oldLeague.getFullScore())
            {
                dto.setCode("0");
            }
            else
            {
                boolean result = _leagueService.updateLeagueByLeagueNo(newLeague);
                dto.setCode(result?"0":"1");
            }
        }

        return dto;
    }
}
