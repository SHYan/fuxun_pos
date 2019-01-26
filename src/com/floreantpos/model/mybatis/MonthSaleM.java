package com.floreantpos.model.mybatis;

import java.sql.Date;

/**
 * A record of month sale.
 * @author jeff
 */
public class MonthSaleM extends Sale {
    private Date firstDayOfMonth;

    /** 月銷售實績 season sale */
    private Double monthSale;

    /** 月銷售數量*/
    private Double qty;

    /** 月營業日數*/
    private Double saleDayCount;

    /** 銷售佔比 = 已銷售實績 / sum(銷售實績) */
    private Double ratioOf;

    /** 營業日額 = 銷售實績 / 營業日數 */
    private Double salePerDay;

    /** 前年同月比 minus 2 year Ratio: annual sale (m2 year) / annual sale (this year) */
    private Double m2YrRatio;

    /** 去年同月比 minus 1 year Ratio: annual sale (m1 year) / annual sale (this year */
    private Double m1YrRatio;

    /**上月比 minus 1 season Ratio: */
    private Double m1MonthRatio;

    @Override
    public String toString(){
        return "    " + firstDayOfMonth
                + " " + rankSeq
                + " " + periodString
                + " " + branchId
                + " " + branchName
                + " " + productGroupNo
                + " " + productGroupName
                + " " + productNo
                + " " + productName
                + " " + monthSale
                + " " + qty
                + " " + saleDayCount
                + " " + getRatioOf()
                + " " + getSalePerDay()
                + " [RATIO] " + m2YrRatio
                + " " + m1YrRatio
                + " " + m1MonthRatio ;
    }

    /**
     * @return the firstDayOfMonth
     */
    public Date getFirstDayOfMonth() {
        return firstDayOfMonth;
    }

    /**
     * @param firstDayOfMonth the firstDayOfMonth to set
     */
    public void setFirstDayOfMonth(Date firstDayOfMonth) {
        this.firstDayOfMonth = firstDayOfMonth;
    }

    /**
     * @return the monthSale
     */
    public Double getMonthSale() {
        return monthSale;
    }

    /**
     * @param monthSale the monthSale to set
     */
    public void setMonthSale(Double monthSale) {
        this.monthSale = monthSale;
    }

    /**
     * @return the qty
     */
    public Double getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(Double qty) {
        this.qty = qty;
    }

    /**
     * @return the saleDayCount
     */
    public Double getSaleDayCount() {
        return saleDayCount;
    }

    /**
     * @param saleDayCount the saleDayCount to set
     */
    public void setSaleDayCount(Double saleDayCount) {
        this.saleDayCount = saleDayCount;
    }

    /**
     * @return the ratioOf
     */
    public Double getRatioOf() {
        return ratioOf;
    }

    /**
     * @param ratioOf the ratioOf to set
     */
    public void setRatioOf(Double ratioOf) {
        this.ratioOf = ratioOf;
    }

    /**
     * @return the salePerDay
     */
    public Double getSalePerDay() {
        return salePerDay;
    }

    /**
     * @param salePerDay the salePerDay to set
     */
    public void setSalePerDay(Double salePerDay) {
        this.salePerDay = salePerDay;
    }

    /**
     * @return the m2YrRatio
     */
    public Double getM2YrRatio() {
        return m2YrRatio;
    }

    /**
     * @param m2YrRatio the m2YrRatio to set
     */
    public void setM2YrRatio(Double m2YrRatio) {
        this.m2YrRatio = m2YrRatio;
    }

    /**
     * @return the m1YrRatio
     */
    public Double getM1YrRatio() {
        return m1YrRatio;
    }

    /**
     * @param m1YrRatio the m1YrRatio to set
     */
    public void setM1YrRatio(Double m1YrRatio) {
        this.m1YrRatio = m1YrRatio;
    }

    /**
     * @return the m1MonthRatio
     */
    public Double getM1MonthRatio() {
        return m1MonthRatio;
    }

    /**
     * @param m1MonthRatio the m1MonthRatio to set
     */
    public void setM1MonthRatio(Double m1MonthRatio) {
        this.m1MonthRatio = m1MonthRatio;
    }

}
