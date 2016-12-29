package cn.footballtime.api.model.cbdfc;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2016/11/16 0016.
 */
public class Cbdfc_ActivityRecord {
    private Integer id;

    private Integer issueId;

    private Integer peopleId;

    private BigDecimal expense;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIssueId() {
        return issueId;
    }

    public void setIssueId(Integer issueId) {
        this.issueId = issueId;
    }

    public Integer getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(Integer peopleId) {
        this.peopleId = peopleId;
    }

    public BigDecimal getExpense() {
        return expense;
    }

    public void setExpense(BigDecimal expense) {
        this.expense = expense;
    }
}
