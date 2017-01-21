package cn.footballtime.web.service.impl;

import cn.footballtime.dto.TeamDto;
import cn.footballtime.dto.common.ResponseDto;
import cn.footballtime.utils.HttpClientUtil;
import cn.footballtime.utils.JsonUtil;
import cn.footballtime.web.config.AppSetting;
import cn.footballtime.web.service.TeamService;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/15.
 */
@Service
public class TeamServiceImpl implements TeamService {
    public List<TeamDto> GetTeamListByCompeitionIdAndSeason(String competitionId,String season)
    {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("competitionId", competitionId);
            params.put("season", season);
            String apiUrl = AppSetting.getDataApiUrl()+"team/getTeamListBySeason";
            String result = HttpClientUtil.httpPostRequest(apiUrl, params);

            ResponseDto<List<TeamDto>> responseDto = JsonUtil.fromJson(result, new TypeToken<ResponseDto<List<TeamDto>>>(){}.getType());//TypeToken，它是gson提供的数据类型转换器，可以支持各种数据集合类型转换。
            List<TeamDto> teamList =responseDto.getContent();

            return teamList;
        }
        catch (Exception ex)
        {
            return new ArrayList<TeamDto>();
        }
    }
}
