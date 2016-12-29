package cn.footballtime.api.dao;

import cn.footballtime.api.model.Competition;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/9/12.
 */
@Repository
public interface CompetitionRepository {
    Competition getByCompetitionNo(String competitionNo);
    List<Competition> getList();
    List<Competition> getList1();
}
