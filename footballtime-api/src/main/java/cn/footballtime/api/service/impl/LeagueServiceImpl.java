package cn.footballtime.api.service.impl;

import cn.footballtime.api.dao.LeagueRepository;
import cn.footballtime.api.model.League;
import cn.footballtime.api.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/10/8.
 */
@Service
public class LeagueServiceImpl implements LeagueService {
    @Autowired
    private LeagueRepository leagueRepository;

    public League findByLeagueNo(String leagueNo)
    {
        return leagueRepository.findByLeagueNo(leagueNo);
    }

    public boolean insert(League league)
    {
        leagueRepository.insertLeague(league);

        return true;
    }

    public boolean updateLeagueByLeagueNo(League league)
    {
        leagueRepository.updateLeagueByLeagueNo(league);

        return true;
    }
}
