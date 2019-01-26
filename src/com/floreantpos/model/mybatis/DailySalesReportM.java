package com.floreantpos.model.mybatis;

import java.sql.Timestamp;

public class DailySalesReportM {
	//private String id;
	
	private String factdate;
	private Long customer_subtotal;
	private Long qty_subtotal;
	private Double item_subtotal;
	private Double service_charge_subtotal;
	private Double tax_subtotal;
	private Double due_subtotal;
	private Double discount_subtotal;
	private Double payment_subtotal;
	private Double revalue_subtotal;
	private Double sale;
	private Double beverage_subtotal;
	private Double food_subtotal;
	
	private Double total_price;
	private Double delivery_charge;
	private Timestamp transactionDate;
	
	
	
	/**
	 * @return the qty_subtotal
	 */
	public Long getQty_subtotal() {
		return qty_subtotal;
	}
	/**
	 * @param qty_subtotal the qty_subtotal to set
	 */
	public void setQty_subtotal(Long qty_subtotal) {
		this.qty_subtotal = qty_subtotal;
	}
	/**
	 * @return the item_subtotal
	 */
	public Double getItem_subtotal() {
		return item_subtotal;
	}
	/**
	 * @param item_subtotal the item_subtotal to set
	 */
	public void setItem_subtotal(Double item_subtotal) {
		this.item_subtotal = item_subtotal;
	}
	/**
	 * @return the service_charge_subtotal
	 */
	public Double getService_charge_subtotal() {
		return service_charge_subtotal;
	}
	/**
	 * @param service_charge_subtotal the service_charge_subtotal to set
	 */
	public void setService_charge_subtotal(Double service_charge_subtotal) {
		this.service_charge_subtotal = service_charge_subtotal;
	}
	/**
	 * @return the tax_subtotal
	 */
	public Double getTax_subtotal() {
		return tax_subtotal;
	}
	/**
	 * @param tax_subtotal the tax_subtotal to set
	 */
	public void setTax_subtotal(Double tax_subtotal) {
		this.tax_subtotal = tax_subtotal;
	}
	
	/**
	 * @return the discount_subtotal
	 */
	public Double getDiscount_subtotal() {
		return discount_subtotal;
	}
	/**
	 * @param discount_subtotal the discount_subtotal to set
	 */
	public void setDiscount_subtotal(Double discount_subtotal) {
		this.discount_subtotal = discount_subtotal;
	}
	
	/**
	 * @return the revalue_subtotal
	 */
	public Double getRevalue_subtotal() {
		return revalue_subtotal;
	}
	/**
	 * @param revalue_subtotal the revalue_subtotal to set
	 */
	public void setRevalue_subtotal(Double revalue_subtotal) {
		this.revalue_subtotal = revalue_subtotal;
	}
	/**
	 * @return the sale
	 */
	public Double getSale() {
		return sale;
	}
	/**
	 * @param sale the sale to set
	 */
	public void setSale(Double sale) {
		this.sale = sale;
	}
	/**
	 * @return the customer_subtotal
	 */
	public Long getCustomer_subtotal() {
		return customer_subtotal;
	}
	/**
	 * @param customer_subtotal the customer_subtotal to set
	 */
	public void setCustomer_subtotal(Long customer_subtotal) {
		this.customer_subtotal = customer_subtotal;
	}
	/**
	 * @return the factdate
	 */
	public String getFactdate() {
		return factdate;
	}
	/**
	 * @param factdate the factdate to set
	 */
	public void setFactdate(String factdate) {
		this.factdate = factdate;
	}
	public Double getDue_subtotal() {
		return due_subtotal;
	}
	public void setDue_subtotal(Double due_subtotal) {
		this.due_subtotal = due_subtotal;
	}
	public Double getPayment_subtotal() {
		return payment_subtotal;
	}
	public void setPayment_subtotal(Double payment_subtotal) {
		this.payment_subtotal = payment_subtotal;
	}
	public Double getBeverage_subtotal() {
		return beverage_subtotal;
	}
	public void setBeverage_subtotal(Double beverage_subtotal) {
		this.beverage_subtotal = beverage_subtotal;
	}
	public Double getFood_subtotal() {
		return food_subtotal;
	}
	public void setFood_subtotal(Double food_subtotal) {
		this.food_subtotal = food_subtotal;
	}
	public Timestamp getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}
	public Double getDelivery_charge() {
		return delivery_charge;
	}
	public void setDelivery_charge(Double delivery_charge) {
		this.delivery_charge = delivery_charge;
	}
	public Double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(Double total_price) {
		this.total_price = total_price;
	}
	
	

}
