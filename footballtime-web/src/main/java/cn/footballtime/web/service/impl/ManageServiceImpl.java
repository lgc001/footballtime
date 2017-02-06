package cn.footballtime.web.service.impl;

import cn.footballtime.dto.common.ResponseDto;
import cn.footballtime.utils.HttpClientUtil;
import cn.footballtime.utils.JsonUtil;
import cn.footballtime.web.config.AppSetting;
import cn.footballtime.web.daoservice.ManageDao;
import cn.footballtime.web.service.ManageService;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/12.
 */
@Service
public class ManageServiceImpl implements ManageService {
    @Autowired
    private ManageDao _manageDao;

    public boolean login(String userName, String password)
    {
        return _manageDao.login(userName,password);
    }
}
