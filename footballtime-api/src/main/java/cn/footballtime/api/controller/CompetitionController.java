package cn.footballtime.api.controller;

import cn.footballtime.api.common.FootballCommon;
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

    @RequestMapping("/getCompetitionByCode")
    @ResponseBody
    public ResponseDto getCompetitionByCode(String code)
    {
        String competitionId = FootballCommon.getCompetitionId(code);
        Competition obj = competitionService.getByCompetitionId(competitionId);

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
