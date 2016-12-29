package cn.footballtime.api.dao;

import cn.footballtime.api.model.League;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/10/8.
 */
@Repository
public interface LeagueRepository {
    League findByLeagueNo(String leagueNo);
    void insertLeague(League league);
    void updateLeagueByLeagueNo(League league);
}
