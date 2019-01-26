package com.floreantpos.model.mybatis;

import java.sql.Date;

public class PromoteReportM {
	private Date factdate;
	private String promotename;
	private long sumorders;
	private long sumqty;
	private double sumdiscount;
    private String branchname;
    private String groupname;
	/**
	 * @return the factdate
	 */
	public Date getFactdate() {
		return factdate;
	}
	/**
	 * @param factdate the factdate to set
	 */
	public void setFactdate(Date factdate) {
		this.factdate = factdate;
	}
	/**
	 * @return the promotename
	 */
	public String getPromotename() {
		return promotename;
	}
	/**
	 * @param promotename the promotename to set
	 */
	public void setPromotename(String promotename) {
		this.promotename = promotename;
	}
	/**
	 * @return the sumorders
	 */
	public long getSumorders() {
		return sumorders;
	}
	/**
	 * @param sumorders the sumorders to set
	 */
	public void setSumorders(long sumorders) {
		this.sumorders = sumorders;
	}
	/**
	 * @return the sumqty
	 */
	public long getSumqty() {
		return sumqty;
	}
	/**
	 * @param sumqty the sumqty to set
	 */
	public void setSumqty(long sumqty) {
		this.sumqty = sumqty;
	}
	/**
	 * @return the sumdiscount
	 */
	public double getSumdiscount() {
		return sumdiscount;
	}
	/**
	 * @param sumdiscount the sumdiscount to set
	 */
	public void setSumdiscount(double sumdiscount) {
		this.sumdiscount = sumdiscount;
	}
	/**
	 * @return the branchname
	 */
	public String getBranchname() {
		return branchname;
	}
	/**
	 * @param branchname the branchname to set
	 */
	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}
	/**
	 * @return the groupname
	 */
	public String getGroupname() {
		return groupname;
	}
	/**
	 * @param groupname the groupname to set
	 */
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
    
}
