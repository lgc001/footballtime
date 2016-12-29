package cn.footballtime.api.model;

public class Team {
	public String getTeamNo() {
		return teamNo;
	}

	public void setTeamNo(String teamNo) {
		this.teamNo = teamNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getCompetitionId() {
		return competitionId;
	}

	public void setCompetitionId(String competitionId) {
		this.competitionId = competitionId;
	}

	public boolean isClub() {
		return isClub;
	}

	public void setIsClub(boolean isClub) {
		this.isClub = isClub;
	}

	public int getIsCurrentSeason() {
		return isCurrentSeason;
	}

	public void setIsCurrentSeason(int isCurrentSeason) {
		this.isCurrentSeason = isCurrentSeason;
	}

	private String teamNo;
	private String name;
	private String fullName;
	private String competitionId;
	private boolean isClub;
	private int isCurrentSeason;
}
