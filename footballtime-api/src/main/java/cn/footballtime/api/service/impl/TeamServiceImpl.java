package cn.footballtime.api.service.impl;

import cn.footballtime.api.dao.SeasonTeamRepository;
import cn.footballtime.api.dao.TeamRepository;
import cn.footballtime.api.model.Team;
import cn.footballtime.api.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private SeasonTeamRepository seasonTeamRepository;

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

    public List<Team> getTeamListBySeason(String competitionId,String season)
    {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("competitionId", competitionId);
        params.put("season", season);
        return seasonTeamRepository.getTeamListBySeason(params);
    }
}
