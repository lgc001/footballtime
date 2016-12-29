package cn.footballtime.api.controller;

import java.util.ArrayList;
import java.util.List;

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
		List<Team> teams = _teamService.getTeamListOfCurrentSeason(competitionNo);

		List<TeamDto> teamDtos=new ArrayList<TeamDto>();
		for (Team team:teams) {
			TeamDto teamDto=new TeamDto();
			teamDto.setTeamNo(team.getTeamNo());
			teamDto.setName(team.getName());
			teamDto.setFullName(team.getFullName());
			teamDto.setCompetitionId(team.getCompetitionId());
			teamDto.setClub(team.isClub());
			teamDto.setIsCurrentSeason(team.getIsCurrentSeason());

			teamDtos.add(teamDto);
		}
		
		ResponseDto dto=new ResponseDto();
		dto.setCode("0");
		dto.setContent(teamDtos);
		
		return dto;
	}
}
