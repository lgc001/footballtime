package cn.footballtime.api.service;

import cn.footballtime.api.model.Competition;

import java.util.List;

/**
 * Created by Administrator on 2016/9/12.
 */
public interface CompetitionService {
    Competition getByCompetitionNo(String competitionNo);
    List<Competition> getList();
    List<Competition> getList1();
}
