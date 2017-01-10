package cn.footballtime.api.controller;

import cn.footballtime.api.model.Manager;
import cn.footballtime.dto.common.ResponseDto;
import cn.footballtime.utils.SecurityUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/1/9.
 */
@Controller
@RequestMapping("/manage")
public class ManageController {
    @RequestMapping("/login")
    public ResponseDto login(String userName,String password)
    {
        Manager manager = new Manager();

        password = SecurityUtil.encryptMD5(manager.getSaltFigure()+password).toUpperCase();

        ResponseDto responseDto = new ResponseDto();
        return responseDto;

//        if(!password.equals(manager.getPassword())) {
//            responseDto.setCode("1");
//        }
//
//        return responseDto;
    }
}
