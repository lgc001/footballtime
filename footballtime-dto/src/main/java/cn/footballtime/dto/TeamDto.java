package cn.footballtime.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamDto {
	private String teamNo;
	private String name;
	private String fullName;
	private String competitionId;
	private boolean isClub;
	private String picNo;
}
