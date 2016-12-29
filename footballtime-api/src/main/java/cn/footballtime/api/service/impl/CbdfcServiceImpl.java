package cn.footballtime.api.service.impl;

import cn.footballtime.api.dao.CbdfcRepository;
import cn.footballtime.api.model.cbdfc.Cbdfc_ActivityRecord;
import cn.footballtime.api.model.cbdfc.Cbdfc_Issue;
import cn.footballtime.api.model.cbdfc.Cbdfc_People;
import cn.footballtime.api.model.cbdfc.Cbdfc_RechargeRecord;
import cn.footballtime.api.service.CbdfcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/10/18 0018.
 */
@Service
public class CbdfcServiceImpl implements CbdfcService {
    @Autowired
    private CbdfcRepository cbdfcRepository;

    public Cbdfc_People findPeopleById(int id)
    {
        return cbdfcRepository.findPeopleById(id);
    }

    public boolean insertPeople(Cbdfc_People people)
    {
        cbdfcRepository.insertPeople(people);

        return true;
    }

    public boolean updatePeopleById(Cbdfc_People people)
    {
        cbdfcRepository.updatePeopleById(people);

        return true;
    }

    public boolean insertIssue(Cbdfc_Issue issue)
    {
        cbdfcRepository.insertIssue(issue);

        return true;
    }

    public boolean insertActivityRecord(Cbdfc_ActivityRecord record)
    {
        cbdfcRepository.insertActivityRecord(record);

        return true;
    }

    public boolean insertRechargeRecord(Cbdfc_RechargeRecord record)
    {
        cbdfcRepository.insertRechargeRecord(record);

        return true;
    }
}
