package com.floreantpos.model.mybatis;


public class OrderStatusReportM {
	
	private int rankSeq;
	private int id;
	private String factdate;
	private long number_of_guests;
	private double item_subtotal;
	private double sub_total;
	private double total_discount;
	private int item_qty;
	private double total_tax;
	private double total_price;
	private double paid_amount;
	private double due_amount;
	private double service_charge;
	private String ticket_type;
	private int shift_id;
	private int terminal_id;
	private String owner_name;
	private boolean voided;
	private boolean paid;
	private boolean settled;
	private String void_by_user_name;
	private String status;
	/**
	 * @return the rankSeq
	 */
	public int getRankSeq() {
		return rankSeq;
	}
	/**
	 * @param rankSeq the rankSeq to set
	 */
	public void setRankSeq(int rankSeq) {
		this.rankSeq = rankSeq;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	/**
	 * @return the number_of_guests
	 */
	public long getNumber_of_guests() {
		return number_of_guests;
	}
	/**
	 * @param number_of_guests the number_of_guests to set
	 */
	public void setNumber_of_guests(long number_of_guests) {
		this.number_of_guests = number_of_guests;
	}
	/**
	 * @return the item_subtotal
	 */
	public double getItem_subtotal() {
		return item_subtotal;
	}
	/**
	 * @param item_subtotal the item_subtotal to set
	 */
	public void setItem_subtotal(double item_subtotal) {
		this.item_subtotal = item_subtotal;
	}
	/**
	 * @return the sub_total
	 */
	public double getSub_total() {
		return sub_total;
	}
	/**
	 * @param sub_total the sub_total to set
	 */
	public void setSub_total(double sub_total) {
		this.sub_total = sub_total;
	}
	/**
	 * @return the total_discount
	 */
	public double getTotal_discount() {
		return total_discount;
	}
	/**
	 * @param total_discount the total_discount to set
	 */
	public void setTotal_discount(double total_discount) {
		this.total_discount = total_discount;
	}
	
	/**
	 * @return the total_tax
	 */
	public double getTotal_tax() {
		return total_tax;
	}
	/**
	 * @param total_tax the total_tax to set
	 */
	public void setTotal_tax(double total_tax) {
		this.total_tax = total_tax;
	}
	/**
	 * @return the total_price
	 */
	public double getTotal_price() {
		return total_price;
	}
	/**
	 * @param total_price the total_price to set
	 */
	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}
	/**
	 * @return the paid_amount
	 */
	public double getPaid_amount() {
		return paid_amount;
	}
	/**
	 * @param paid_amount the paid_amount to set
	 */
	public void setPaid_amount(double paid_amount) {
		this.paid_amount = paid_amount;
	}
	/**
	 * @return the due_amount
	 */
	public double getDue_amount() {
		return due_amount;
	}
	/**
	 * @param due_amount the due_amount to set
	 */
	public void setDue_amount(double due_amount) {
		this.due_amount = due_amount;
	}
	/**
	 * @return the service_charge
	 */
	public double getService_charge() {
		return service_charge;
	}
	/**
	 * @param service_charge the service_charge to set
	 */
	public void setService_charge(double service_charge) {
		this.service_charge = service_charge;
	}
	/**
	 * @return the ticket_type
	 */
	public String getTicket_type() {
		return ticket_type;
	}
	/**
	 * @param ticket_type the ticket_type to set
	 */
	public void setTicket_type(String ticket_type) {
		this.ticket_type = ticket_type;
	}
	/**
	 * @return the shift_id
	 */
	public int getShift_id() {
		return shift_id;
	}
	/**
	 * @param shift_id the shift_id to set
	 */
	public void setShift_id(int shift_id) {
		this.shift_id = shift_id;
	}
	/**
	 * @return the terminal_id
	 */
	public int getTerminal_id() {
		return terminal_id;
	}
	/**
	 * @param terminal_id the terminal_id to set
	 */
	public void setTerminal_id(int terminal_id) {
		this.terminal_id = terminal_id;
	}
	
	/**
	 * @return the voided
	 */
	public boolean isVoided() {
		return voided;
	}
	/**
	 * @param voided the voided to set
	 */
	public void setVoided(boolean voided) {
		this.voided = voided;
	}
	/**
	 * @return the paid
	 */
	public boolean isPaid() {
		return paid;
	}
	/**
	 * @param paid the paid to set
	 */
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	/**
	 * @return the settled
	 */
	public boolean isSettled() {
		return settled;
	}
	/**
	 * @param settled the settled to set
	 */
	public void setSettled(boolean settled) {
		this.settled = settled;
	}
	
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	public String getVoid_by_user_name() {
		return void_by_user_name;
	}
	public void setVoid_by_user_name(String void_by_user_name) {
		this.void_by_user_name = void_by_user_name;
	}
	public int getItem_qty() {
		return item_qty;
	}
	public void setItem_qty(int item_qty) {
		this.item_qty = item_qty;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
