package cn.footballtime.web.util;

/**
 * Created by Administrator on 2017/1/10.
 */
public class CommonUtil {
    public static String getPicNoByPicExtendName(String picExtendName)
    {
        picExtendName = picExtendName.toLowerCase();
        if(picExtendName.equals(".jpg"))
        {
            return "1";
        }
        else if(picExtendName.equals(".png"))
        {
            return "2";
        }
        else if(picExtendName.equals(".gif"))
        {
            return "3";
        }
        else
        {
            return "";
        }
    }
}
