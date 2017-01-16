package cn.footballtime.api.controller;

import java.util.ArrayList;
import java.util.List;

import cn.footballtime.api.common.FootballCommon;
import cn.footballtime.api.model.Team;
import cn.footballtime.api.service.TeamService;
import cn.footballtime.dto.TeamDto;
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

	@RequestMapping("/getTeamListOfCurrentSeason")
	@ResponseBody
	public ResponseDto getTeamListOfCurrentSeason(String competitionNo)
	{
		String competitionId = FootballCommon.getCompetitionId(competitionNo);
		List<Team> teams = _teamService.getTeamListOfCurrentSeason(competitionId);
		
		ResponseDto dto=new ResponseDto();
		dto.setCode("0");
		dto.setContent(teams);
		
		return dto;
	}
}
