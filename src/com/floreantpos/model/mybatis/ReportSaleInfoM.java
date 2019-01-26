/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.floreantpos.model.mybatis;

/**
 *
 * @author jeff
 */
public class ReportSaleInfoM {
    private int seq;
    private String productNo;
    private String productName;
    private double qty;
    private double amt;
    private double qtyRatio;
    private double amtRatio;

    /**
     * @return the seq
     */
    public int getSeq() {
        return seq;
    }

    /**
     * @param seq the seq to set
     */
    public void setSeq(int seq) {
        this.seq = seq;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
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

    /**
     * @return the amt
     */
    public double getAmt() {
        return amt;
    }

    /**
     * @param amt the amt to set
     */
    public void setAmt(double amt) {
        this.amt = amt;
    }

    /**
     * @return the qtyRatio
     */
    public double getQtyRatio() {
        return qtyRatio;
    }

    /**
     * @param qtyRatio the qtyRatio to set
     */
    public void setQtyRatio(double qtyRatio) {
        this.qtyRatio = qtyRatio;
    }

    /**
     * @return the amtRatio
     */
    public double getAmtRatio() {
        return amtRatio;
    }

    /**
     * @param amtRatio the amtRatio to set
     */
    public void setAmtRatio(double amtRatio) {
        this.amtRatio = amtRatio;
    }

    /**
     * @return the productNo
     */
    public String getProductNo() {
        return productNo;
    }

    /**
     * @param productNo the productNo to set
     */
    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    


}
