package cn.footballtime.api.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Administrator on 2017/1/19.
 */
@Getter
@Setter
public class SeasonTeam {
    private int id;
    private String competitionId;
    private String season;
    private String teamNo;
}
