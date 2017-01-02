package cn.footballtime.api.common;

/**
 * Created by Administrator on 2016/12/10.
 */
public class FootballCommon {
    public static String getCompetitionName(String competitionNo) {
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

    public static String getCompetitionId(String competitionNo) {
        String competitionId = "1";

        competitionNo = competitionNo.toUpperCase();
        switch (competitionNo) {
            case "A01":
                competitionId = "1";
                break;
            case "A02":
                competitionId = "2";
                break;
            case "A03":
                competitionId = "3";
                break;
            case "A04":
                competitionId = "4";
                break;
            case "A05":
                competitionId = "5";
                break;
            default:
                break;
        }

        return competitionId;
    }
}
