package cn.footballtime.api.config.datasource;

/**
 * Created by Administrator on 2016/12/21 0021.
 */
public class DataSourceTypeManager {
    private static final ThreadLocal<String> dataSourceTypes = new ThreadLocal<String>(){
        @Override
        protected String initialValue(){
            return EnumDataSource.FootballConn.toString();
        }
    };

    public static String get(){
        return dataSourceTypes.get();
    }

    public static void set(EnumDataSource dataSource){
        dataSourceTypes.set(dataSource.toString());
    }

    public static void reset(){
        dataSourceTypes.set(EnumDataSource.FootballConn.toString());
    }
}
