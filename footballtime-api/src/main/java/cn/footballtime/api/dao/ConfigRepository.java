package cn.footballtime.api.dao;

import cn.footballtime.api.model.ConfigInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/11/16 0016.
 */
@Repository
public interface ConfigRepository {
    String getValueByKey(String configKey);
    List<ConfigInfo> getList(String category);
}
