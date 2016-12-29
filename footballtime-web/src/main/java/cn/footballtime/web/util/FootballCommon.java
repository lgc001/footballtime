package cn.footballtime.web.util;

/**
 * Created by Administrator on 2016/12/10.
 */
public class FootballCommon {
    public static String GetCompetitionName(String competitionNo) {
        String name = "";

        competitionNo = competitionNo.toUpperCase();
        switch (competitionNo) {
            case "A01":
                name = "德甲";
                break;
            case "A02":
                name = "英超";
                break;
            case "A03":
                name = "意甲";
                break;
            case "A04":
                name = "西甲";
                break;
            case "A05":
                name = "法甲";
                break;
            default:
                break;
        }

        return name;
    }
}
