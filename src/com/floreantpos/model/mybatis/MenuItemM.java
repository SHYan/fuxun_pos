package com.floreantpos.model.mybatis;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *  java bean for product listbox option
 * @author dieter
 */
public class MenuItemM {

    private int productNo;
    private String productName;
    private String translatedName;
    private String productBarcode;
    private Boolean beverage;
    private String unitName;
    private Double buyPrice;
    private Double price;
    private Double beforeChange;
    private Double changeQty;
    
    private Double stockAmount;
    private String categoryName;
    private String groupName;
    private String sortOrder;
    private int categoryId; 
    private String vendorName;
    private String remark;
    private String transactionType;
    private Timestamp transactionDate;
    
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	/**
	 * @return the beforeChange
	 */
	public Double getBeforeChange() {
		return beforeChange;
	}
	/**
	 * @param beforeChange the beforeChange to set
	 */
	public void setBeforeChange(Double beforeChange) {
		this.beforeChange = beforeChange;
	}
	/**
	 * @return the changeQty
	 */
	public Double getChangeQty() {
		return changeQty;
	}
	/**
	 * @param changeQty the changeQty to set
	 */
	public void setChangeQty(Double changeQty) {
		this.changeQty = changeQty;
	}
	/**
	 * @return the ventorName
	 */
	public String getVendorName() {
		return vendorName;
	}
	/**
	 * @param ventorName the ventorName to set
	 */
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * @param productNo the productNo to set
	 */
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @return the productNo
	 */
	public int getProductNo() {
		return productNo;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the translatedName
	 */
	public String getTranslatedName() {
		return translatedName;
	}
	/**
	 * @param translatedName the translatedName to set
	 */
	public void setTranslatedName(String translatedName) {
		this.translatedName = translatedName;
	}
	/**
	 * @return the productBarcode
	 */
	public String getProductBarcode() {
		return productBarcode;
	}
	/**
	 * @param productBarcode the productBarcode to set
	 */
	public void setProductBarcode(String productBarcode) {
		this.productBarcode = productBarcode;
	}
	/**
	 * @return the unitName
	 */
	public String getUnitName() {
		return unitName;
	}
	/**
	 * @param unitName the unitName to set
	 */
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	/**
	 * @return the buyPrice
	 */
	public Double getBuyPrice() {
		return buyPrice;
	}
	/**
	 * @param buyPrice the buyPrice to set
	 */
	public void setBuyPrice(Double buyPrice) {
		this.buyPrice = buyPrice;
	}
	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	/**
	 * @return the stockAmount
	 */
	public Double getStockAmount() {
		return stockAmount;
	}
	/**
	 * @param stockAmount the stockAmount to set
	 */
	public void setStockAmount(Double stockAmount) {
		this.stockAmount = stockAmount;
	}
	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}
	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public Boolean getBeverage() {
		return beverage;
	}
	public void setBeverage(Boolean beverage) {
		this.beverage = beverage;
	}
	public String getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
	public Timestamp getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}
    

}
