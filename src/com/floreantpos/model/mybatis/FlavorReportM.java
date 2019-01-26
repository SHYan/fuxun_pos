package com.floreantpos.model.mybatis;

import java.sql.Date;

public class FlavorReportM {
	private Date factDate;
	private String flavorName;
	private double amount;
	private double qty;
    private double orderCount;
    private String branchName;
    private String groupName;
    
	public Date getFactDate() {
		return factDate;
	}
	public void setFactDate(Date factDate) {
		this.factDate = factDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getFlavorName() {
		return flavorName;
	}
	public void setFlavorName(String flavorName) {
		this.flavorName = flavorName;
	}
	public double getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(double orderCount) {
		this.orderCount = orderCount;
	}
	/**
	 * @return the qty
	 */
	public double getQty() {
		return qty;
	}
	/**
	 * @param qty the qty to set
	 */
	public void setQty(double qty) {
		this.qty = qty;
	}
}
