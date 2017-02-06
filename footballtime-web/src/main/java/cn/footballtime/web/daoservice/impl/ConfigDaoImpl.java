package cn.footballtime.web.daoservice.impl;

import cn.footballtime.dto.ConfigInfoDto;
import cn.footballtime.dto.common.ResponseDto;
import cn.footballtime.utils.HttpClientUtil;
import cn.footballtime.utils.JsonUtil;
import cn.footballtime.web.config.AppSetting;
import cn.footballtime.web.daoservice.ConfigDao;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/2/6.
 */
@Component
public class ConfigDaoImpl implements ConfigDao {
    public List<ConfigInfoDto> getList(String category)
    {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("category", category);
            String apiUrl = AppSetting.getDataApiUrl()+"config/getList";
            String result = HttpClientUtil.httpGetRequest(apiUrl, params);

            ResponseDto<List<ConfigInfoDto>> responseDto = JsonUtil.fromJson(result, new TypeToken<ResponseDto<List<ConfigInfoDto>>>(){}.getType());//TypeToken，它是gson提供的数据类型转换器，可以支持各种数据集合类型转换。
            List<ConfigInfoDto> list = responseDto.getContent();

            return list;
        }
        catch (Exception ex)
        {
            return null;
        }
    }
}
