package cn.footballtime.api.model.cbdfc;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2016/10/18 0018.
 */
public class Cbdfc_People {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getIsCard() {
        return isCard;
    }

    public void setIsCard(int isCard) {
        this.isCard = isCard;
    }

    public int getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(int isEnable) {
        this.isEnable = isEnable;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    private int id;
    private String name;
    private String realName;
    private int isCard;
    private int isEnable;
    private BigDecimal balance;
}
