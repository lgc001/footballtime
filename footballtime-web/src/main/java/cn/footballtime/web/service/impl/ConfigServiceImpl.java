package cn.footballtime.web.service.impl;

import cn.footballtime.dto.ConfigInfoDto;
import cn.footballtime.dto.LeagueDto;
import cn.footballtime.dto.common.ResponseDto;
import cn.footballtime.utils.HttpClientUtil;
import cn.footballtime.utils.JsonUtil;
import cn.footballtime.web.config.AppSetting;
import cn.footballtime.web.daoservice.ConfigDao;
import cn.footballtime.web.service.ConfigService;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/16 0016.
 */
@Service
public class ConfigServiceImpl implements ConfigService {
    @Autowired
    private ConfigDao _configDao;

    public List<ConfigInfoDto> getList(String category)
    {
        return _configDao.getList(category);
    }
}
