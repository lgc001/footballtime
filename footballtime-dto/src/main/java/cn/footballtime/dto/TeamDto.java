package cn.footballtime.dto;

import cn.footballtime.dto.common.BasePicDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamDto extends BasePicDto {
	private String teamNo;
	private String name;
	private String fullName;
	private String competitionId;
	private Boolean isClub;
	private String picNo;
	private String picPath;
	public String getPicPath()
	{
		return getPicPath(getPicNo());
	}
}
