package cn.footballtime.api.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2016/9/12.
 */
public class Competition {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isLeague() {
        return isLeague;
    }

    public void setIsLeague(boolean isLeague) {
        this.isLeague = isLeague;
    }

    public String getCurrentSeason() {
        return currentSeason;
    }

    public void setCurrentSeason(String currentSeason) {
        this.currentSeason = currentSeason;
    }

    private String id;
    private String code;
    @SerializedName("competitionName")//别名
    private String name;
    private String country;
    private String fullName;
    private boolean isLeague;
    private String currentSeason;
}
