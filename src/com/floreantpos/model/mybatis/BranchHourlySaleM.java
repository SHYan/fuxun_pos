package com.floreantpos.model.mybatis;

import java.sql.Date;

public final class BranchHourlySaleM extends Sale {

    private Date factdate;
    private int hourPeriod;
    private Double saleSum;
    private Double saleQty;
    private int saleOrder;
    private Double ratioOf;
    private int totalCustomer;
    
    public final Date getFactdate() {
        return factdate;
    }
    public final void setFactdate(Date factdate) {
        this.factdate = factdate;
    }
    public final int getHourPeriod() {
        return hourPeriod;
    }
    public final void setHourPeriod(int hourPeriod) {
        this.hourPeriod = hourPeriod;
    }
    public final Double getSaleSum() {
        return saleSum;
    }
    public final void setSaleSum(Double saleSum) {
        this.saleSum = saleSum;
    }
    public final Double getSaleQty() {
        return saleQty;
    }
    public final void setSaleQty(Double saleQty) {
        this.saleQty = saleQty;
    }
    public final int getSaleOrder() {
        return saleOrder;
    }
    public final void setSaleOrder(int saleOrder) {
        this.saleOrder = saleOrder;
    }
    public final Double getRatioOf() {
        return ratioOf;
    }
    public final void setRatioOf(Double ratioOf) {
        this.ratioOf = ratioOf;
    }
	public int getTotalCustomer() {
		return totalCustomer;
	}
	public void setTotalCustomer(int totalCustomer) {
		this.totalCustomer = totalCustomer;
	}
    
}
