package cn.footballtime.api.service.impl;

import cn.footballtime.api.dao.CompetitionRepository;
import cn.footballtime.api.model.Competition;
import cn.footballtime.api.service.CompetitionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2016/9/12.
 */
@Service
public class CompetitionServiceImpl implements CompetitionService {
    @Resource
    private CompetitionRepository competitionRepository;

    public Competition getByCompetitionId(String id)
    {
        return competitionRepository.getByCompetitionId(id);
    }

    public List<Competition> getList()
    {
        return competitionRepository.getList();
    }

    public List<Competition> getList1()
    {
        return competitionRepository.getList1();
    }
}
