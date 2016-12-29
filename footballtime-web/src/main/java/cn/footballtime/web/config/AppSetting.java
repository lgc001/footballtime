package cn.footballtime.web.config;

import cn.footballtime.utils.PropertiesUtil;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AppSetting {
    static{
        PropertiesUtil util;
        try {
            util = new PropertiesUtil("conf/config.properties");
            cookieDomain = util.readValue("cookieDomain");
            cookieName = util.readValue("cookieName");
            cookieAesEncryptKey = util.readValue("cookieAesEncryptKey");
            siteDomainUrl = util.readValue("siteDomainUrl");
             dataApiUrl = util.readValue("footballApiUrl");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static String cookieDomain;
    /** cookie域
     * @return
     */
    public static String getCookieDomain() {
        return cookieDomain;
    }

    private static String cookieName;
    /** 网站cookieName
     * @return
     */
    public static String getCookieName() {
        return cookieName;
    }

    private static String cookieAesEncryptKey;
    /** 网站cookie aes加密key
     * @return
     */
    public static String getCookieAesEncryptKey() {
        return cookieAesEncryptKey;
    }

    private static String siteDomainUrl;
    /** 网站主网址
     * @return
     */
    public static String getSiteDomainUrl() {
        return siteDomainUrl;
    }

    private static String dataApiUrl;
    /**
     * footballApi接口url（带最后的斜线）
     */
    public static String getDataApiUrl() {
        return  dataApiUrl;
    }
}
