package cn.footballtime.api.dao;

import cn.footballtime.api.model.Team;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TeamRepository {
    Team findByTeamNo(String teamNo);
    void insertTeam(Team team);
    void updateTeamByTeamNo(Team team);
    void modifyTeamLogo(Map<String,Object> params);
}
