package cn.footballtime.api.controller;

import java.util.List;

import cn.footballtime.api.model.Team;
import cn.footballtime.api.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.footballtime.dto.common.ResponseDto;

@Controller
@RequestMapping("/team")
public class TeamController {
	@Autowired
	private TeamService _teamService;

	@RequestMapping("/getTeamListBySeason")
	@ResponseBody
	public ResponseDto getTeamListBySeason(String competitionId,String season)
	{
		List<Team> teams = _teamService.getTeamListBySeason(competitionId,season);
		
		ResponseDto dto=new ResponseDto();
		dto.setCode("0");
		dto.setContent(teams);
		
		return dto;
	}

	@RequestMapping("/modifyTeamLogo")
	@ResponseBody
	public ResponseDto modifyTeamLogo(String teamNo,String picNo)
	{
		boolean isSuccess = _teamService.modifyTeamLogo(teamNo,picNo);

		ResponseDto dto=new ResponseDto();
		dto.setCode("0");

		return dto;
	}
}
