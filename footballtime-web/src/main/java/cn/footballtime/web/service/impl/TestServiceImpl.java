package cn.footballtime.web.service.impl;

import cn.footballtime.web.service.TestService;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/9/11.
 */
@Service("testService")
public class TestServiceImpl implements TestService {
    public String test(){
        String a="testaaabc";
        return  a;
    }
}
