package cn.footballtime.api.service.impl;

import cn.footballtime.api.dao.ConfigRepository;
import cn.footballtime.api.model.ConfigInfo;
import cn.footballtime.api.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/11/16 0016.
 */
@Service
public class ConfigServiceImpl implements ConfigService {
    @Autowired
    private ConfigRepository configRepository;

    public String getValueByKey(String key)
    {
        return configRepository.getValueByKey(key);
    }

    public List<ConfigInfo> getList()
    {
        return configRepository.getList();
    }
}
