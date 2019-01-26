package com.floreantpos.model.mybatis;


import java.sql.Timestamp;

public class PayoutM {
    private Timestamp  transactionDate;
    private Double amount;
    private String note;
    private String recp_name;
    private String reason;
    
    private Double In;
    private Double Out;
    
	public Timestamp getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Timestamp transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
	public String getRecp_name() {
		return recp_name;
	}
	public void setRecp_name(String recp_name) {
		this.recp_name = recp_name;
	}
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Double getIn() {
		return In;
	}
	public void setIn(Double in) {
		In = in;
	}
	public Double getOut() {
		return Out;
	}
	public void setOut(Double out) {
		Out = out;
	}
}
