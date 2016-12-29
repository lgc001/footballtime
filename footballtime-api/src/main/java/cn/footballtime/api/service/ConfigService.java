package cn.footballtime.api.service;

import cn.footballtime.api.model.ConfigInfo;

import java.util.List;

/**
 * Created by Administrator on 2016/11/16 0016.
 */
public interface ConfigService {
    String getValueByKey(String key);
    List<ConfigInfo> getList();
}
