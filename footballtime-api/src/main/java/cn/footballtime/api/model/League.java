package cn.footballtime.api.model;

/**
 * Created by Administrator on 2016/10/8.
 */
public class League {
    public String getLeagueNo() {
        return leagueNo;
    }

    public void setLeagueNo(String leagueNo) {
        this.leagueNo = leagueNo;
    }

    public String getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(String competitionId) {
        this.competitionId = competitionId;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public String getBjTime() {
        return bjTime;
    }

    public void setBjTime(String bjTime) {
        this.bjTime = bjTime;
    }

    public String getHomeTeamNo() {
        return homeTeamNo;
    }

    public void setHomeTeamNo(String homeTeamNo) {
        this.homeTeamNo = homeTeamNo;
    }

    public String getGuestTeamNo() {
        return guestTeamNo;
    }

    public void setGuestTeamNo(String guestTeamNo) {
        this.guestTeamNo = guestTeamNo;
    }

    public String getHalfScore() {
        return halfScore;
    }

    public void setHalfScore(String halfScore) {
        this.halfScore = halfScore;
    }

    public String getFullScore() {
        return fullScore;
    }

    public void setFullScore(String fullScore) {
        this.fullScore = fullScore;
    }

    public int gethDrillmasterId() {
        return hDrillmasterId;
    }

    public void sethDrillmasterId(int hDrillmasterId) {
        this.hDrillmasterId = hDrillmasterId;
    }

    public int getgDrillmasterId() {
        return gDrillmasterId;
    }

    public void setgDrillmasterId(int gDrillmasterId) {
        this.gDrillmasterId = gDrillmasterId;
    }

    public int getUmpireId() {
        return umpireId;
    }

    public void setUmpireId(int umpireId) {
        this.umpireId = umpireId;
    }

    //LeagueNo, CompetitionId, Season, Round, BjTime, HomeTeamNo, GuestTeamNo, HalfScore, FullScore, HDrillmasterId, GDrillmasterId, UmpireId
    private String leagueNo;
    private String competitionId;
    private String season;
    private int round;
    private String bjTime;
    private String homeTeamNo;
    private String guestTeamNo;
    private String halfScore;
    private String fullScore;
    private int hDrillmasterId;
    private int gDrillmasterId;
    private int umpireId;
}
