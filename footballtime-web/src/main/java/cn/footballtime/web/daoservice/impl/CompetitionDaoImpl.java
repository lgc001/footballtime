package cn.footballtime.web.daoservice.impl;

import cn.footballtime.dto.CompetitionDto;
import cn.footballtime.dto.common.ResponseDto;
import cn.footballtime.utils.HttpClientUtil;
import cn.footballtime.utils.JsonUtil;
import cn.footballtime.web.config.AppSetting;
import cn.footballtime.web.daoservice.CompetitionDao;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/6.
 */
@Component
public class CompetitionDaoImpl implements CompetitionDao {
    public CompetitionDto getCompetitionById(String id)
    {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("id", id);
            String apiUrl = AppSetting.getDataApiUrl()+"competition/getCompetitionById";
            String result = HttpClientUtil.httpGetRequest(apiUrl, params);

            ResponseDto<CompetitionDto> responseDto = JsonUtil.fromJson(result, new TypeToken<ResponseDto<CompetitionDto>>(){}.getType());//TypeToken，它是gson提供的数据类型转换器，可以支持各种数据集合类型转换。
            CompetitionDto competitionDto = responseDto.getContent();

            return competitionDto;
        }
        catch (Exception ex)
        {
            return null;
        }
    }
}
