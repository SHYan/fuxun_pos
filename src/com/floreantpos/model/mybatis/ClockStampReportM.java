package com.floreantpos.model.mybatis;

public class ClockStampReportM {
	private String branchId;
	private String sale_period;
	private String displayname;
    private int worktime;
	private String clockin_time;
	private String clockout_time;
	private String username;
	private String branchName;
	private String job;
	
	
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchname(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public String getSale_period() {
		return sale_period;
	}
	public void setSale_period(String sale_period) {
		this.sale_period = sale_period;
	}
	public String getDisplayname() {
		return displayname;
	}
	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}
	public int getWorktime() {
		return worktime;
	}
	public void setWorktime(int worktime) {
		this.worktime = worktime;
	}
	public String getClockin_time() {
		return clockin_time;
	}
	public void setClockin_time(String clockin_time) {
		this.clockin_time = clockin_time;
	}
	public String getClockout_time() {
		return clockout_time;
	}
	public void setClockout_time(String clockout_time) {
		this.clockout_time = clockout_time;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}