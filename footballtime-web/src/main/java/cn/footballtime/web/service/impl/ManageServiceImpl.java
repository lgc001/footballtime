package cn.footballtime.web.service.impl;

import cn.footballtime.dto.common.ResponseDto;
import cn.footballtime.utils.HttpClientUtil;
import cn.footballtime.utils.JsonUtil;
import cn.footballtime.web.config.AppSetting;
import cn.footballtime.web.service.ManageService;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/12.
 */
@Service
public class ManageServiceImpl implements ManageService {
    public boolean login(String userName, String password)
    {
        try {
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("userName", userName);
            params.put("password", password);

            String apiUrl = AppSetting.getDataApiUrl()+"manage/login";
            String result = HttpClientUtil.httpGetRequest(apiUrl, params);

            ResponseDto responseDto = JsonUtil.fromJson(result, new TypeToken<ResponseDto>(){}.getType());//TypeToken，它是gson提供的数据类型转换器，可以支持各种数据集合类型转换。

            return responseDto.getCode().equals("0");
        }
        catch (Exception ex)
        {
            return false;
        }
    }
}
