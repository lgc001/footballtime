package cn.footballtime.web.service.impl;

import cn.footballtime.dto.CompetitionDto;
import cn.footballtime.dto.common.ResponseDto;
import cn.footballtime.utils.HttpClientUtil;
import cn.footballtime.utils.JsonUtil;
import cn.footballtime.web.config.AppSetting;
import cn.footballtime.web.daoservice.CompetitionDao;
import cn.footballtime.web.service.CompetitionService;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/15 0015.
 */
@Service
public class CompetitionServiceImpl implements CompetitionService {
    @Autowired
    private CompetitionDao _competitionDao;

    public CompetitionDto getCompetitionById(String id)
    {
        return _competitionDao.getCompetitionById(id);
    }
}
