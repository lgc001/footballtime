package cn.footballtime.api.service.impl;

import cn.footballtime.api.dao.LeagueRepository;
import cn.footballtime.api.model.League;
import cn.footballtime.api.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/8.
 */
@Service
public class LeagueServiceImpl implements LeagueService {
    @Autowired
    private LeagueRepository leagueRepository;

    public League findByLeagueNo(String leagueNo) {
        return leagueRepository.findByLeagueNo(leagueNo);
    }

    public boolean insert(League league) {
        leagueRepository.insertLeague(league);

        return true;
    }

    public boolean updateLeagueByLeagueNo(League league) {
        leagueRepository.updateLeagueByLeagueNo(league);

        return true;
    }

    public List<League> getLeagueListByCompetitionId(String competitionId, boolean isOver, int pageIndex, int pageSize) {
        List<League> result = null;

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("competitionId", competitionId);
        params.put("startIndex", (pageIndex-1)*pageSize);
        params.put("pageSize", pageSize);

        if (isOver) {
            result = leagueRepository.getLeagueListByCompetitionIdOfOver(params);
        } else {
            result = leagueRepository.getLeagueListByCompetitionIdOfFuture(params);
        }

        return result;
    }
}
