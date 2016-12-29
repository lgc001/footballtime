package cn.footballtime.api.model.cbdfc;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2016/10/28 0028.
 */
public class Cbdfc_Issue {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public BigDecimal getOneExpense() {
        return oneExpense;
    }

    public void setOneExpense(BigDecimal oneExpense) {
        this.oneExpense = oneExpense;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public int getNumberOfCardPeople() {
        return numberOfCardPeople;
    }

    public void setNumberOfCardPeople(int numberOfCardPeople) {
        this.numberOfCardPeople = numberOfCardPeople;
    }

    public BigDecimal getReceivedMoney() {
        return receivedMoney;
    }

    public void setReceivedMoney(BigDecimal receivedMoney) {
        this.receivedMoney = receivedMoney;
    }

    public String getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(String activityTime) {
        this.activityTime = activityTime;
    }

    public BigDecimal getEarn() {
        return earn;
    }

    public void setEarn(BigDecimal earn) {
        this.earn = earn;
    }

    public BigDecimal getOtherEarn() {
        return otherEarn;
    }

    public void setOtherEarn(BigDecimal otherEarn) {
        this.otherEarn = otherEarn;
    }

    public String getOtherEarnExplain() {
        return otherEarnExplain;
    }

    public void setOtherEarnExplain(String otherEarnExplain) {
        this.otherEarnExplain = otherEarnExplain;
    }

    public int getIsHaveData() {
        return isHaveData;
    }

    public void setIsHaveData(int isHaveData) {
        this.isHaveData = isHaveData;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    private int id;
    private String sequence;
    private String batch;
    private BigDecimal oneExpense;
    private int numberOfPeople;
    private int numberOfCardPeople;
    private BigDecimal receivedMoney;
    private String activityTime;
    private BigDecimal earn;
    private BigDecimal otherEarn;
    private String otherEarnExplain;
    private int isHaveData;
    private BigDecimal balance;
    private String remark;
}
