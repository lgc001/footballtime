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
	private Boolean isClub;
	private String picNo;
	private String picName;
	public String getPicName()
	{
		if(getPicNo().length()==18)
		{
			return getPicNo()+getPicNo().substring(17).replace("1",".jpg").replace("2",".png").replace("3",".gif");
		}
		else
		{
			return "";
		}
	}
}
