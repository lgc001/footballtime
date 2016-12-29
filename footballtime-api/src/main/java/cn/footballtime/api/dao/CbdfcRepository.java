package cn.footballtime.api.dao;

import cn.footballtime.api.model.cbdfc.Cbdfc_ActivityRecord;
import cn.footballtime.api.model.cbdfc.Cbdfc_Issue;
import cn.footballtime.api.model.cbdfc.Cbdfc_People;
import cn.footballtime.api.model.cbdfc.Cbdfc_RechargeRecord;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/10/18 0018.
 */
@Repository
public interface CbdfcRepository {
    Cbdfc_People findPeopleById(int id);
    void insertPeople(Cbdfc_People people);
    void updatePeopleById(Cbdfc_People people);

    void insertIssue(Cbdfc_Issue issue);

    void insertActivityRecord(Cbdfc_ActivityRecord record);

    void insertRechargeRecord(Cbdfc_RechargeRecord record);
}
