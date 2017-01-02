package cn.footballtime.api.service.impl;

import cn.footballtime.api.dao.TeamRepository;
import cn.footballtime.api.model.Team;
import cn.footballtime.api.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public Team findByTeamNo(String teamNo)
    {
        return teamRepository.findByTeamNo(teamNo);
    }

    public boolean insert(Team team)
    {
        teamRepository.insertTeam(team);

        return true;
    }

    public boolean updateTeamByTeamNo(Team team)
    {
        teamRepository.updateTeamByTeamNo(team);

        return true;
    }

    public List<Team> getTeamListOfCurrentSeason(String competitionId)
    {
        return teamRepository.getTeamListOfCurrentSeason(competitionId);
    }
}