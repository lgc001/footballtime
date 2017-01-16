package cn.footballtime.api.dao;

import cn.footballtime.api.model.League;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/8.
 */
@Repository
public interface LeagueRepository {
    League findByLeagueNo(String leagueNo);
    void insertLeague(League league);
    void updateLeagueByLeagueNo(League league);

    /**
     * 已结束
     * @return
     */
    List<League> getLeagueListByCompetitionIdOfOver(Map<String,Object> params);

    /**
     * 未来的
     * @return
     */
    List<League> getLeagueListByCompetitionIdOfFuture(Map<String,Object> params);
}
