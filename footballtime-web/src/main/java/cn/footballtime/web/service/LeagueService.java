package cn.footballtime.web.service;

import cn.footballtime.dto.LeagueDto;

import java.util.List;

/**
 * Created by Administrator on 2017/1/16.
 */
public interface LeagueService {
    List<LeagueDto> getLeagueListByCompetitionId(String competitionId, boolean isOver, int pageIndex, int pageSize);
}
