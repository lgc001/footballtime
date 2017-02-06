package cn.footballtime.web.daoservice;

import cn.footballtime.dto.TeamDto;

import java.util.List;

/**
 * Created by Administrator on 2017/2/6.
 */
public interface TeamDao {
    List<TeamDto> GetTeamListByCompeitionIdAndSeason(String competitionId, String season);
    boolean modifyTeamLogo(String teamNo,String picNo);
}
