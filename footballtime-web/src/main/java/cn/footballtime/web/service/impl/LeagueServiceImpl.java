package cn.footballtime.web.service.impl;

import cn.footballtime.dto.LeagueDto;
import cn.footballtime.dto.common.ResponseDto;
import cn.footballtime.utils.HttpClientUtil;
import cn.footballtime.utils.JsonUtil;
import cn.footballtime.web.config.AppSetting;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/16.
 */
@Service
public class LeagueServiceImpl implements cn.footballtime.web.service.LeagueService {
    public List<LeagueDto> getLeagueListByCompetitionId(String competitionId, boolean isOver, int pageIndex, int pageSize)
    {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("competitionId", competitionId);
            params.put("isOver", isOver);
            params.put("pageIndex", pageIndex);
            params.put("pageSize", pageSize);
            String apiUrl = AppSetting.getDataApiUrl()+"league/getLeagueListByCompetitionId";
            String result = HttpClientUtil.httpGetRequest(apiUrl, params);

            ResponseDto<List<LeagueDto>> responseDto = JsonUtil.fromJson(result, new TypeToken<ResponseDto<List<LeagueDto>>>(){}.getType());//TypeToken，它是gson提供的数据类型转换器，可以支持各种数据集合类型转换。
            List<LeagueDto> list = responseDto.getContent();

            return list;
        }
        catch (Exception ex)
        {
            return null;
        }
    }
}
