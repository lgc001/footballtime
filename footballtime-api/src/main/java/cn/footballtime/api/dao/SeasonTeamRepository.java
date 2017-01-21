package cn.footballtime.api.dao;

import cn.footballtime.api.model.Team;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SeasonTeamRepository {
    List<Team> getTeamListBySeason(Map<String,Object> params);
}
