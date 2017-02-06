package cn.footballtime.web.daoservice;

import cn.footballtime.dto.CompetitionDto;

/**
 * Created by Administrator on 2017/2/6.
 */
public interface CompetitionDao {
    CompetitionDto getCompetitionById(String id);
}
