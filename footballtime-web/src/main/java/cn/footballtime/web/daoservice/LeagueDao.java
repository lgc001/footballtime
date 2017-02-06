package cn.footballtime.web.daoservice;

import cn.footballtime.dto.LeagueDto;

import java.util.List;

/**
 * Created by Administrator on 2017/2/6.
 */
public interface LeagueDao {
    List<LeagueDto> getLeagueListByCompetitionId(String competitionId, boolean isOver, int pageIndex, int pageSize);
}
