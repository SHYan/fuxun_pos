package com.floreantpos.model.mybatis;

public class AllOrderSearchPaymentM {

    private float cashTotal=0.0f;
    private float creditCardTotal=0.0f;
    private float couponTotal=0.0f;
    private float giftCardTotal=0.0f;

    
    /**
	 * @return the cashTotal
	 */
	public float getCashTotal() {
		return cashTotal;
	}
	/**
	 * @param cashTotal the cashTotal to set
	 */
	public void setCashTotal(float cashTotal) {
		this.cashTotal = cashTotal;
	}
	/**
	 * @return the creditCardTotal
	 */
	public float getCreditCardTotal() {
		return creditCardTotal;
	}
	/**
	 * @param creditCardTotal the creditCardTotal to set
	 */
	public void setCreditCardTotal(float creditCardTotal) {
		this.creditCardTotal = creditCardTotal;
	}
	/**
	 * @return the couponTotal
	 */
	public float getCouponTotal() {
		return couponTotal;
	}
	/**
	 * @param couponTotal the couponTotal to set
	 */
	public void setCouponTotal(float couponTotal) {
		this.couponTotal = couponTotal;
	}
	/**
	 * @return the giftCardTotal
	 */
	public float getGiftCardTotal() {
		return giftCardTotal;
	}
	/**
	 * @param giftCardTotal the giftCardTotal to set
	 */
	public void setGiftCardTotal(float giftCardTotal) {
		this.giftCardTotal = giftCardTotal;
	}
	

}
