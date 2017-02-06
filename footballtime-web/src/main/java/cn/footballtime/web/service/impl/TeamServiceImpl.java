package cn.footballtime.web.service.impl;

import cn.footballtime.dto.TeamDto;
import cn.footballtime.dto.common.ResponseDto;
import cn.footballtime.utils.HttpClientUtil;
import cn.footballtime.utils.JsonUtil;
import cn.footballtime.web.config.AppSetting;
import cn.footballtime.web.daoservice.TeamDao;
import cn.footballtime.web.service.TeamService;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/15.
 */
@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamDao _teamDao;

    public List<TeamDto> GetTeamListByCompeitionIdAndSeason(String competitionId,String season)
    {
        return _teamDao.GetTeamListByCompeitionIdAndSeason(competitionId,season);
    }

    public boolean modifyTeamLogo(String teamNo,String picNo)
    {
        return _teamDao.modifyTeamLogo(teamNo,picNo);
    }
}
