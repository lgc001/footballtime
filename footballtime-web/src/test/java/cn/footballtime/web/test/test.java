package cn.footballtime.web.test;

import java.util.HashMap;
import java.util.Map;

import cn.footballtime.web.util.FreemarkerUtil;
//import org.junit.Before;
//import org.junit.Test;

public class test {
	FreemarkerUtil fu = null;
    
    //@Before
    public void init(){
        if(fu==null){
            fu = new FreemarkerUtil();
        }
    }
    
    //@Test
    public void show(){
        //1.创建数据模型
        Map<String, Object> root = new HashMap<String, Object>();
        //2.赋值
        root.put("name", "测试");
        root.put("price", "5");
        root.put("users", new String[]{"Tom1","Jack","Rose"});
        //3.将数据模型和模版进行结合输出到控制台显示
        //fu.print("product.html", root);
        fu.print("product.ftl", root);
    }
}
