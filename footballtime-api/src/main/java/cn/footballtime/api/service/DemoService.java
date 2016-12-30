package cn.footballtime.api.service;

/**
 * Created by Administrator on 2016/12/30 0030.
 */
public interface DemoService {
    /**
     * 相同库事务
     */
    void transInsertSameDb() throws Exception;

    /**
     * 不同库事务
     */
    void transInsertNotSameDb() throws Exception;
}
