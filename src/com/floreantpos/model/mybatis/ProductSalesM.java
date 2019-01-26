package com.floreantpos.model.mybatis;

public class ProductSalesM {
	private int rankSeq;
	private String productNo;
	private String categoryName;
	private String productName;
	private Boolean beverage;
	private double itemPrice;
	private double totalQty;
	private double subtotal;
	private double taxAmount;
	private double scAmount;
	
	private double discount;
	private double totalSale;
	
	private double qtyRatio;
	private double saleRatio;
	
	private double totalFractionQty;
	
	
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	public String toString() {
		return super.toString()
		+ "{" + productName
		+ ", " + totalQty
		+ ", " + totalSale
		+ ", " + qtyRatio
		+ ", " + saleRatio
		+ "}";
	}

	public void setRankSeq(int rankSeq) {
		this.rankSeq = rankSeq;
	}
	public int getRankSeq() {
		return rankSeq;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getTotalQty() {
		return totalQty;
	}
	public void setTotalQty(double totalQty) {
		this.totalQty = totalQty;
	}
	public double getScAmount() {
		return scAmount;
	}

	public void setScAmount(double scAmount) {
		this.scAmount = scAmount;
	}
	public double getTotalSale() {
		return totalSale;
	}
	public void setTotalSale(double totalSale) {
		this.totalSale = totalSale;
	}
	public double getQtyRatio() {
		return qtyRatio;
	}
	public void setQtyRatio(double qtyRatio) {
		this.qtyRatio = qtyRatio;
	}
	public double getSaleRatio() {
		return saleRatio;
	}
	public void setSaleRatio(double saleRatio) {
		this.saleRatio = saleRatio;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public Boolean getBeverage() {
		return beverage;
	}

	public void setBeverage(Boolean beverage) {
		this.beverage = beverage;
	}

	public double getTotalFractionQty() {
		return totalFractionQty;
	}

	public void setTotalFractionQty(double totalFractionQty) {
		this.totalFractionQty = totalFractionQty;
	}
}
