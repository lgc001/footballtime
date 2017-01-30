package cn.footballtime.dto.common;

/**
 * Created by Administrator on 2017/1/24.
 */
public class BasePicDto {
    public String getPicPath(String picNo)
    {
        if(picNo != null && picNo.length()==18)
        {
            return "http://img.footballtime.cn/pic/" + picNo.substring(0,6) + "/" + picNo+picNo.substring(17).replace("1",".jpg").replace("2",".png").replace("3",".gif");
        }
        else
        {
            return "";
        }
    }
}
