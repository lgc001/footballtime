package cn.footballtime.web.service;

import cn.footballtime.dto.ConfigInfoDto;

import java.util.List;

/**
 * Created by Administrator on 2016/11/16 0016.
 */
public interface ConfigService {
    List<ConfigInfoDto> getList(String category);
}
