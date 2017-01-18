package cn.footballtime.api.dao;

import cn.footballtime.api.model.Team;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeasonTeamRepository {
    List<Team> getTeamListBySeason(String competitionId, String season);
}
