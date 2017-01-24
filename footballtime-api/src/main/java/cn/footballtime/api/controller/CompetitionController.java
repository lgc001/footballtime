package cn.footballtime.api.controller;

import cn.footballtime.api.config.AppSetting;
import cn.footballtime.api.model.Competition;
import cn.footballtime.api.service.CompetitionService;
import cn.footballtime.dto.CompetitionDto;
import cn.footballtime.dto.common.ResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;



/**
 * Created by Administrator on 2016/9/12.
 */
@Controller
@RequestMapping("/competition")
public class CompetitionController {
    @Resource
    private CompetitionService competitionService;

    @RequestMapping("/getCompetitionById")
    @ResponseBody
    public ResponseDto getCompetitionByCode(String id)
    {
        Competition obj = competitionService.getByCompetitionId(id);

        CompetitionDto dto=new CompetitionDto();
        dto.setId(obj.getId());
        dto.setCode(obj.getCode());
        dto.setName(obj.getName());
        dto.setFullName(obj.getFullName());
        dto.setCountry(obj.getCountry());
        dto.setLeague(obj.isLeague());
        dto.setCurrentSeason(obj.getCurrentSeason());

        ResponseDto responseDto=new ResponseDto();
        responseDto.setCode("0");
        responseDto.setContent(dto);

        return responseDto;
    }

    @RequestMapping("/getList")
    @ResponseBody
    public ResponseDto getCompetitionList()
    {
        List<Competition> list = competitionService.getList1();

        ResponseDto dto=new ResponseDto();
        dto.setCode("0");
        dto.setContent(list);

        return dto;
    }
}
