package cn.footballtime.dto;

import lombok.Data;

/**
 * Created by Administrator on 2016/12/14 0014.
 */
//@Data
//public class CompetitionDto {
//    private int id;
//    private String competitionNo;
//    private String name;
//    private String country;
//    private String fullName;
//    private boolean isLeague;
//}

public class CompetitionDto {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompetitionNo() {
        return competitionNo;
    }

    public void setCompetitionNo(String competitionNo) {
        this.competitionNo = competitionNo;
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

    public void setLeague(boolean league) {
        isLeague = league;
    }

    private int id;
    private String competitionNo;
    private String name;
    private String country;
    private String fullName;
    private boolean isLeague;
}
