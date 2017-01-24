package cn.footballtime.api.config;

import cn.footballtime.api.model.ConfigInfo;
import cn.footballtime.api.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by Administrator on 2016/11/16 0016.
 */
@Component
public class AppSetting {
    @Autowired
    private ConfigService configService;

    private static AppSetting appSetting;

    //弄这个为了实现注入
    @PostConstruct
    public void init() {
        appSetting = this;
        appSetting.configService = this.configService;
    }

    static{
    }

    private static Dictionary<String,String> configDict;
    /** cookie域
     * @ret
     */
    public static Dictionary<String,String> getConfigDict() {
        if(configDict!=null && configDict.size()>0)
        {
            return configDict;
        }

        List<ConfigInfo> list = appSetting.configService.getList("api");
        Dictionary<String,String> dict=new Hashtable<String, String>();
        for (ConfigInfo item:
                list) {
            dict.put(item.configKey,item.configValue);
        }
        configDict = dict;
        return configDict;
    }

    public static String getApiSecurityKey()
    {
        return getConfigDict().get("apiSecurityKey");
    }
}
