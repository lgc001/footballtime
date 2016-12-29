package cn.footballtime.api.controller;

import cn.footballtime.api.service.LeagueService;
import cn.footballtime.dto.common.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2016/9/12.
 */
@Controller
public class LeagueController {
    @Autowired
    private LeagueService _leagueService;

    /**
     * 得到一个联赛的比赛
     * @param competitionId
     * @param isOver 是否是已结束的比赛
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @RequestMapping("/getLeagueListByCompetitionId")
    @ResponseBody
    public ResponseDto getLeagueListByCompetitionId(String competitionId,boolean isOver,int pageIndex,int pageSize) {
        return null;
    }

    /**
     * 得到一个球队的比赛
     * @param teamNo
     * @param isOver 是否是已结束的比赛
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @RequestMapping("/getLeagueListByTeamNo")
    @ResponseBody
    public ResponseDto getLeagueListByTeamNo(String teamNo,boolean isOver,int pageIndex,int pageSize) {
        return null;
    }

    /**
     * 得到一个联赛的赛程
     * @param competitionId
     * @param season
     * @param round
     * @return
     */
    @RequestMapping("/getLeagueSchedule")
    @ResponseBody
    public ResponseDto getLeagueSchedule(String competitionId,String season,int round) {
        return null;
    }
}
