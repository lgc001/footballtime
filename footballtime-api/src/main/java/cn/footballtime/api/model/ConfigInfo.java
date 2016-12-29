package cn.footballtime.api.model;

/**
 * Created by Administrator on 2016/11/16 0016.
 */
public class ConfigInfo {
    public String getConfigKey() {
        return configKey;
    }

    public void setConfigKey(String configKey) {
        this.configKey = configKey;
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    public String configKey;
    public String configValue;
}
