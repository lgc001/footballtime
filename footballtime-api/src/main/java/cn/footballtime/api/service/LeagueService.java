package cn.footballtime.api.service;

import cn.footballtime.api.model.League;

import java.util.List;

/**
 * Created by Administrator on 2016/10/8.
 */
public interface LeagueService {
    League findByLeagueNo(String leagueNo);
    boolean insert(League league);
    boolean updateLeagueByLeagueNo(League league);

    List<League> getLeagueListByCompetitionId(String competitionId,boolean isOver,int pageIndex,int pageSize);
}
