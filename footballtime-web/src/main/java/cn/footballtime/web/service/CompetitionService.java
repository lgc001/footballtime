package cn.footballtime.web.service;

import cn.footballtime.dto.CompetitionDto;

/**
 * Created by Administrator on 2016/12/15 0015.
 */
public interface CompetitionService {
    CompetitionDto getByCompetitionNo(String competitionNo);
}
