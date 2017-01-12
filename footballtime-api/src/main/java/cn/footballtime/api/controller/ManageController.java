package cn.footballtime.api.controller;

import cn.footballtime.api.model.Manager;
import cn.footballtime.api.service.ManageService;
import cn.footballtime.dto.common.ResponseDto;
import cn.footballtime.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/1/9.
 */
@Controller
@RequestMapping("/manage")
public class ManageController {
    @Autowired
    private ManageService _manageService;

    @RequestMapping("/login")
    @ResponseBody
    public ResponseDto login(String userName, String password) {
        ResponseDto responseDto = new ResponseDto();
        if (!_manageService.login(userName, password)) {
            responseDto.setCode("1");
        }

        return responseDto;
    }
}
