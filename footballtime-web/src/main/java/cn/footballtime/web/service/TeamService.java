package cn.footballtime.web.service;

import cn.footballtime.dto.TeamDto;

import java.util.List;

/**
 * Created by Administrator on 2016/12/15.
 */
public interface TeamService {
    List<TeamDto> GetTeamListOfCurrentSeason(String competitionNo);
}
