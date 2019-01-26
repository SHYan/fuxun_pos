/**
 * ************************************************************************
 * * The contents of this file are subject to the MRPL 1.2
 * * (the  "License"),  being   the  Mozilla   Public  License
 * * Version 1.1  with a permitted attribution clause; you may not  use this
 * * file except in compliance with the License. You  may  obtain  a copy of
 * * the License at http://www.floreantpos.org/license.html
 * * Software distributed under the License  is  distributed  on  an "AS IS"
 * * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * * License for the specific  language  governing  rights  and  limitations
 * * under the License.
 * * The Original Code is FLOREANT POS.
 * * The Initial Developer of the Original Code is OROCUBE LLC
 * * All portions are Copyright (C) 2015 OROCUBE LLC
 * * All Rights Reserved.
 * ************************************************************************
 */
package com.floreantpos.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ticket")
public class SalesSummary{


	protected Integer id;
	protected Date transactionDate;
	protected Integer itemQty;
	protected Double subtotalAmount;
	protected Double deliveryCharge;
	protected Double discountAmount;
	protected Double taxAmount;
	protected Double serviceCharge;
	protected Double totalAmount;
	protected Integer numberOfGuests;

	/* [CONSTRUCTOR MARKER BEGIN] */
	public SalesSummary () {
		
	}
	
	public java.lang.Integer getId () {
		return id;
	}
	public void setId (java.lang.Integer id) {
		this.id = id;
	}
	
	public java.util.Date getTransactionDate () {
		return transactionDate;
	}
	public void setTransactionDate (java.util.Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	public java.lang.Integer getItemQty() {
		return itemQty;
	}
	public void setItemQty(java.lang.Integer itemQty) {
		this.itemQty = itemQty;
	}
	
	public java.lang.Double getSubtotalAmount () {
		return subtotalAmount == null ? Double.valueOf(0) : subtotalAmount;
	}
	public void setSubtotalAmount (java.lang.Double subtotalAmount) {
		this.subtotalAmount = subtotalAmount;
	}
	
	public java.lang.Double getDeliveryCharge () {
		return deliveryCharge == null ? Double.valueOf(0) : deliveryCharge;
	}
	public void setDeliveryCharge (java.lang.Double deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}
	
	public java.lang.Double getDiscountAmount () {
		return discountAmount == null ? Double.valueOf(0) : discountAmount;
	}
	public void setDiscountAmount (java.lang.Double discountAmount) {
		this.discountAmount = discountAmount;
	}
	
	public java.lang.Double getTaxAmount () {
		return taxAmount == null ? Double.valueOf(0) : taxAmount;
	}
	public void setTaxAmount (java.lang.Double taxAmount) {
		this.taxAmount = taxAmount;
	}
	
	public java.lang.Double getServiceCharge () {
		return serviceCharge == null ? Double.valueOf(0) : serviceCharge;
	}
	public void setServiceCharge (java.lang.Double serviceCharge) {
		this.serviceCharge = serviceCharge;
	}
	
	public java.lang.Double getTotalAmount () {
		return totalAmount == null ? Double.valueOf(0) : totalAmount;
	}
	public void setTotalAmount (java.lang.Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public java.lang.Integer getNumberOfGuests () {
		return numberOfGuests == null ? Integer.valueOf(0) : numberOfGuests;
	}
	public void setNumberOfGuests (java.lang.Integer numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}

}