package cn.footballtime.api.controller;

import cn.footballtime.api.model.Competition;
import cn.footballtime.api.service.CompetitionService;
import cn.footballtime.api.service.DemoService;
import cn.footballtime.dto.common.ResponseDto;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by Administrator on 2016/12/13 0013.
 */
@Controller
@RequestMapping("/demo")
public class DemoController {
    @Resource
    private CompetitionService competitionService;

    @Autowired
    private DemoService demoService;

    //这种情况可以使用实体的属性的别名
    @RequestMapping(value = "/getList2", produces = {"application/json;charset=UTF-8"})//为了使用返回中文不乱码
    @ResponseBody
    public String getCompetitionList2() throws UnsupportedEncodingException {
        List<Competition> list = competitionService.getList();

        ResponseDto dto=new ResponseDto();
        dto.setCode("0");
        dto.setContent(list);

        Gson gson=new Gson();
        String result = gson.toJson(dto); //
        return result;
    }

    /**
     * 相同库事务
     */
    @RequestMapping("/transInsertSameDb")
    @ResponseBody
    public String transInsertSameDb()
    {
        try {
            demoService.transInsertSameDb();

            return "true";
        }
        catch(Exception ex)
        {
            return "false";
        }
    }

    /**
     * 不同库事务
     */
    @RequestMapping("/transInsertNotSameDb")
    @ResponseBody
    public String transInsertNotSameDb()
    {
        try {
            demoService.transInsertNotSameDb();

            return "true";
        }
        catch(Exception ex)
        {
            return "false";
        }
    }
}
