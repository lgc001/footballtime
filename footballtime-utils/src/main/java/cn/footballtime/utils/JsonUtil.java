package cn.footballtime.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Administrator on 2016/12/14 0014.
 */
public class JsonUtil {
    public static String toJson(Object obj)
    {
        if(obj==null)
        {
            return "{}";
        }

        Gson gson=new Gson();
        return gson.toJson(obj);
    }

    /**
     * T是不含泛型时,如CompetitionDto
     * @param json
     * @param classOfT
     * @param <T>
     * @return
     */
    public static <T> T fromJson(String json,Class<T> classOfT)
    {
        if (isEmpty(json)) {
            return null;
        }

        Gson gson=new Gson();
        return gson.fromJson(json,classOfT);
    }

    /**
     * T是含泛型时,如ResponseDto<CompetitionDto>
     * @param json
     * @param typeOfT
     * @param <T>
     * @return
     */
    public static <T> T fromJson(String json,Type typeOfT)
    {
        if (isEmpty(json)) {
            return null;
        }

        Gson gson=new Gson();
        return gson.fromJson(json, typeOfT);
    }

    private static boolean isEmpty(String json) {
        return json == null || json.trim().length() == 0;
    }
}
