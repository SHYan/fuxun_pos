package com.floreantpos.model.mybatis;

public class SaleSummaryM {

	private Integer rank;
	private String name;
	private Double totalQty;
	private Double totalSale;
	private Double saleRatio;
	
	public String toString() {
		return super.toString()+"{"
		+ rank + " "
		+ name + " "
		+ totalQty + " "
		+ totalSale + " "
		+ saleRatio +"}";
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getTotalQty() {
		return totalQty;
	}
	public void setTotalQty(Double totalQty) {
		this.totalQty = totalQty;
	}
	public Double getTotalSale() {
		return totalSale;
	}
	public void setTotalSale(Double totalSale) {
		this.totalSale = totalSale;
	}
	public Double getSaleRatio() {
		return saleRatio;
	}
	public void setSaleRatio(Double saleRatio) {
		this.saleRatio = saleRatio;
	}
	
}
