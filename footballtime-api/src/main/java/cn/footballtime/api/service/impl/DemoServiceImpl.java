package cn.footballtime.api.service.impl;

import cn.footballtime.api.config.datasource.DataSourceTypeManager;
import cn.footballtime.api.config.datasource.EnumDataSource;
import cn.footballtime.api.dao.DemoRepository;
import cn.footballtime.api.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/12/30 0030.
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoRepository demoRepository;

    //目前事务还是没起上作用
    @Transactional
    public void transInsertSameDb() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String currentDate = df.format(new Date());// new Date()为获取当前系统时间

//        DataSourceTypeManager.set(EnumDataSource.MyConn);
        demoRepository.insertMydataTest1(currentDate);

        int a=5;
        int b=0;
        int c=a/b;

//        DataSourceTypeManager.set(EnumDataSource.MyConn);
        demoRepository.insertMydataTest2(currentDate);

        //事务回滚
//        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
    }

    @Transactional
    public void transInsertNotSameDb() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String currentDate = df.format(new Date());// new Date()为获取当前系统时间

        DataSourceTypeManager.set(EnumDataSource.MyConn);
        demoRepository.insertMydataTest2(currentDate);

        int a=5;
        int b=0;
        int c=a/b;

        DataSourceTypeManager.set(EnumDataSource.FootballConn);
        demoRepository.insertFootballTest(currentDate);
    }
}
