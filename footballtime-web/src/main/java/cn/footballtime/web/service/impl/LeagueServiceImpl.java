package cn.footballtime.web.service.impl;

import cn.footballtime.dto.LeagueDto;
import cn.footballtime.dto.common.ResponseDto;
import cn.footballtime.utils.HttpClientUtil;
import cn.footballtime.utils.JsonUtil;
import cn.footballtime.web.config.AppSetting;
import cn.footballtime.web.daoservice.LeagueDao;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/16.
 */
@Service
public class LeagueServiceImpl implements cn.footballtime.web.service.LeagueService {
    @Autowired
    private LeagueDao _leagueDao;

    public List<LeagueDto> getLeagueListByCompetitionId(String competitionId, boolean isOver, int pageIndex, int pageSize)
    {
        return _leagueDao.getLeagueListByCompetitionId(competitionId,isOver,pageIndex,pageSize);
    }
}
