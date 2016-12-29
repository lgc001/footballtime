package cn.footballtime.api.service;

import cn.footballtime.api.model.cbdfc.Cbdfc_ActivityRecord;
import cn.footballtime.api.model.cbdfc.Cbdfc_Issue;
import cn.footballtime.api.model.cbdfc.Cbdfc_People;
import cn.footballtime.api.model.cbdfc.Cbdfc_RechargeRecord;

/**
 * Created by Administrator on 2016/10/18 0018.
 */
public interface CbdfcService {
    Cbdfc_People findPeopleById(int id);
    boolean insertPeople(Cbdfc_People people);
    boolean updatePeopleById(Cbdfc_People people);

    boolean insertIssue(Cbdfc_Issue issue);

    boolean insertActivityRecord(Cbdfc_ActivityRecord record);

    boolean insertRechargeRecord(Cbdfc_RechargeRecord record);
}
