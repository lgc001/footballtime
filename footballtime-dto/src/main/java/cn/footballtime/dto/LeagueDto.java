package cn.footballtime.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Administrator on 2017/1/16.
 */
@Getter
@Setter
public class LeagueDto {
    private String leagueNo;
    private String competitionId;
    private String season;
    private int round;
    private String bjTime;
    private String homeTeamNo;
    private String homeTeamName;
    private String guestTeamNo;
    private String guestTeamName;
    private String halfScore;
    private String fullScore;
    private int hDrillmasterId;
    private int gDrillmasterId;
    private int umpireId;
}
