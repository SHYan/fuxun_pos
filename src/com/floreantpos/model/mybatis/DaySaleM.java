/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.floreantpos.model.mybatis;

import java.sql.Date;

/**
 *
 * @author jeff
 */
public class DaySaleM extends Sale{
    private Date factDate;
    private double amount;
    private double qty;

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
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
     * @return the factDate
     */
    public Date getFactDate() {
        return factDate;
    }

    /**
     * @param factDate the factDate to set
     */
    public void setFactDate(Date factDate) {
        this.factDate = factDate;
    }


}
