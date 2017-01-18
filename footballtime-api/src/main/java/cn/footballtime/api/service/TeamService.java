package cn.footballtime.api.service;

import cn.footballtime.api.model.Team;

import java.util.List;

public interface TeamService {
    Team findByTeamNo(String teamNo);
    boolean insert(Team team);
    boolean updateTeamByTeamNo(Team team);

    List<Team> getTeamListBySeason(String competitionId,String season);
}
