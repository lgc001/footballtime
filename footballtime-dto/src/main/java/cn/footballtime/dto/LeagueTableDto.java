package cn.footballtime.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 积分榜
 */
@Data
public class LeagueTableDto implements Serializable {
    private String id;
    private String competitionNo;
    private String season;
    private String round;
    private String teamNo;
    private int point;
}
