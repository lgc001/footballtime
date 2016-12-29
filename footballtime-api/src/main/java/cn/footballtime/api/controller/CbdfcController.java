package cn.footballtime.api.controller;

import cn.footballtime.api.service.CbdfcService;
import cn.footballtime.api.model.cbdfc.Cbdfc_ActivityRecord;
import cn.footballtime.api.model.cbdfc.Cbdfc_Issue;
import cn.footballtime.api.model.cbdfc.Cbdfc_People;
import cn.footballtime.api.model.cbdfc.Cbdfc_RechargeRecord;
import cn.footballtime.dto.common.ResponseDto;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2016/9/8 0008.
 */
@Controller
@RequestMapping("/cbdfc")
public class CbdfcController {
    @Autowired
    private CbdfcService _cbdfcService;

    @RequestMapping("/insertPeople")
    @ResponseBody
    public ResponseDto insertPeople(String jsonMsg)
    {
        ResponseDto dto=new ResponseDto();

        if(true) {
            return dto;
        }

        Gson gson=new Gson();
        Cbdfc_People newPeople = gson.fromJson(jsonMsg,Cbdfc_People.class);
        if(newPeople.getId()==0)
        {
            dto.setCode("1");
            dto.setMsg("id不能为空");

            return dto;
        }

        Cbdfc_People oldPeople = _cbdfcService.findPeopleById(newPeople.getId());
        if(oldPeople == null)
        {
            boolean result = _cbdfcService.insertPeople(newPeople);
            dto.setCode(result?"0":"1");
        }
        else
        {
            boolean result = _cbdfcService.updatePeopleById(newPeople);
            dto.setCode(result?"0":"1");
        }

        return dto;
    }

    @RequestMapping("/insertIssue")
    @ResponseBody
    public ResponseDto insertIssue(String jsonMsg)
    {
        ResponseDto dto=new ResponseDto();

        if(true) {
            return dto;
        }

        Gson gson=new Gson();
        Cbdfc_Issue newIssue = gson.fromJson(jsonMsg,Cbdfc_Issue.class);
        if(newIssue.getId()==0)
        {
            dto.setCode("1");
            dto.setMsg("id不能为空");

            return dto;
        }

        boolean result = _cbdfcService.insertIssue(newIssue);
        dto.setCode(result?"0":"1");

        return dto;
    }

    @RequestMapping("/insertActivityRecord")
    @ResponseBody
    public ResponseDto insertActivityRecord(String jsonMsg)
    {
        ResponseDto dto=new ResponseDto();

        if(true) {
            return dto;
        }

        Gson gson=new Gson();
        Cbdfc_ActivityRecord newRecorde = gson.fromJson(jsonMsg,Cbdfc_ActivityRecord.class);
        if(newRecorde.getId()==0)
        {
            dto.setCode("1");
            dto.setMsg("id不能为空");

            return dto;
        }

        boolean result = _cbdfcService.insertActivityRecord(newRecorde);
        dto.setCode(result?"0":"1");

        return dto;
    }

    @RequestMapping("/insertRechargeRecord")
    @ResponseBody
    public ResponseDto insertRechargeRecord(String jsonMsg)
    {
        ResponseDto dto=new ResponseDto();

        if(true) {
            return dto;
        }

        Gson gson=new Gson();
        Cbdfc_RechargeRecord newRecorde = gson.fromJson(jsonMsg,Cbdfc_RechargeRecord.class);
        if(newRecorde.getId()==0)
        {
            dto.setCode("1");
            dto.setMsg("id不能为空");

            return dto;
        }

        boolean result = _cbdfcService.insertRechargeRecord(newRecorde);
        dto.setCode(result?"0":"1");

        return dto;
    }
}
