package cn.footballtime.web.daoservice;

import cn.footballtime.dto.ConfigInfoDto;

import java.util.List;

/**
 * Created by Administrator on 2017/2/6.
 */
public interface ConfigDao {
    List<ConfigInfoDto> getList(String category);
}
