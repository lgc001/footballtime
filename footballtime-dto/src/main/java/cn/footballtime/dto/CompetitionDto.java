package cn.footballtime.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Administrator on 2016/12/14 0014.
 */
@Getter
@Setter
public class CompetitionDto {
    private int id;
    private String competitionNo;
    private String name;
    private String country;
    private String fullName;
    private boolean isLeague;
    private String CurrentSeason;
}
