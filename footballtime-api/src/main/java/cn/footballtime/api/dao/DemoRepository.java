package cn.footballtime.api.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/12/30 0030.
 */
@Repository
public interface DemoRepository {
    void insertFootballTest(String name);
    void insertMydataTest1(String name);
    void insertMydataTest2(String name);
}
