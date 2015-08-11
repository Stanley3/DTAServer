package com.dta.vo;

import javax.ws.rs.QueryParam;

public class LatestNumberVo {
	@QueryParam("lastQueryPrecontractTime")
	private String lastQueryPrecontractTime;
	@QueryParam("lastQueryCancelTime")
	private String lastQueryCancelTime;
	@QueryParam("lastQueryEvaluationTime")
	private String lastQueryEvaluationTime;
	@QueryParam("coach_id")
	private Integer coach_id;

	public Integer getCoach_id() {
		return coach_id;
	}

	public void setCoach_id(Integer coach_id) {
		this.coach_id = coach_id;
	}

	public String getLastQueryPrecontractTime() {
		return lastQueryPrecontractTime;
	}

	public void setLastQueryPrecontractTime(String lastQueryPrecontractTime) {
		this.lastQueryPrecontractTime = lastQueryPrecontractTime;
	}

	public String getLastQueryCancelTime() {
		return lastQueryCancelTime;
	}

	public void setLastQueryCancelTime(String lastQueryCancelTime) {
		this.lastQueryCancelTime = lastQueryCancelTime;
	}

	public String getLastQueryEvaluationTime() {
		return lastQueryEvaluationTime;
	}

	public void setLastQueryEvaluationTime(String lastQueryEvaluationTime) {
		this.lastQueryEvaluationTime = lastQueryEvaluationTime;
	}
}
