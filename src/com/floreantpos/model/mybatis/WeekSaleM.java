package com.floreantpos.model.mybatis;

import java.sql.Date;

/**
 * A record of week sale.
 * @author jeff
 */
public class WeekSaleM extends Sale {

    /** 銷售周的第一日 */
    private Date[] firstDayOfWeek = new Date[9];
    // -1d means null data, no data //
    // the sequence is
    // m4WK, m3WK, m2WK, m1WK, assigned WK, p1WK, p2WK, p3WK, p4WK

    /* 周銷售實績 week sale */
    private double[] total = {-1d, -1d, -1d, -1d, -1d, -1d, -1d, -1d, -1d};

    /*  周銷售數量 */
    private double[] qty = {-1d, -1d, -1d, -1d, -1d, -1d, -1d, -1d, -1d};

    /* 週營業日數 */
    private double[] saleDayCount = {-1d, -1d, -1d, -1d, -1d, -1d, -1d, -1d, -1d};

    /*  銷售佔比  =  以銷售實績 / sum(銷售實績) */
    private double[] ratioOf = {-1d, -1d, -1d, -1d, -1d, -1d, -1d, -1d, -1d};

    /* 營業日額 = 銷售實績 / 營業日數 */
    private double[] salePerDay = {-1d, -1d, -1d, -1d, -1d, -1d, -1d, -1d, -1d};
    
    // 周營業日額比, assigned week is 1d=100%
    private double[] wkRatio = {-1d, -1d, -1d, -1d, 1d, -1d, -1d, -1d, -1d};

    /*
    private double m4WkRatio;
    private double m3WkRatio;
    private double m2WkRatio;
    private double m1WkRatio;
    private double p1WkRatio;
    private double p2WkRatio;
    private double p3WkRatio;
    private double p4WkRatio;
     */
    // 營業日額
    //營業總額
    //營業日數
    @Override
    public String toString() {
        return "    " + getFirstDayOfWeek()
                + " " + getRankSeq()
                + " " + getPeriodString()
                + " " + getProductGroupNo()
                + " " + getProductGroupName()
                + " " + getTotal()
                + " " + getQty()
                + " " + getSaleDayCount()
                + " " + getRatioOf()
                + " " + getSalePerDay()
                + " [RATIO] " + getM4WkRatio()
                + " " + getM3WkRatio()
                + " " + getM2WkRatio()
                + " " + getM1WkRatio()
                + " " + getP1WkRatio()
                + " " + getP2WkRatio()
                + " " + getP3WkRatio()
                + " " + getP4WkRatio();
    }

    /**
     * @return the firstDayOfWeek
     */
    public Date getFirstDayOfWeek() {
        return firstDayOfWeek[4];
    }

    /**
     * @param firstDayOfWeek the firstDayOfWeek to set
     */
    public void setFirstDayOfWeek(Date firstDayOfWeek) {
        this.firstDayOfWeek[4] = firstDayOfWeek;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total[4];
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total[4] = total;
    }

    /**
     * @return the qty
     */
    public double getQty() {
        return qty[4];
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(double qty) {
        this.qty[4] = qty;
    }

    /**
     * @return the saleDayCount
     */
    public double getSaleDayCount() {
        return saleDayCount[4];
    }

    /**
     * @param saleDayCount the saleDayCount to set
     */
    public void setSaleDayCount(double saleDayCount) {
        this.saleDayCount[4] = saleDayCount;
    }

    public double getWKRatio(int wk) {
        return this.wkRatio[wk - 1];
    }

    public void setWKRatio(int wk, double ratio) {
        this.wkRatio[wk - 1] = ratio;
    }

    /**
     * @return the m4WkRatio
     */
    public double getM4WkRatio() {
        return getWKRatio(1);
    }

    /**
     * @param m4WkRatio the m4WkRatio to set
     */
    public void setM4WkRatio(double m4WkRatio) {
        setWKRatio(1, m4WkRatio);
    }

    /**
     * @return the m3WkRatio
     */
    public double getM3WkRatio() {
        return getWKRatio(2);
    }

    /**
     * @param m3WkRatio the m3WkRatio to set
     */
    public void setM3WkRatio(double m3WkRatio) {
        setWKRatio(2, m3WkRatio);
    }

    /**
     * @return the m2WkRatio
     */
    public double getM2WkRatio() {
        return getWKRatio(3);
    }

    /**
     * @param m2WkRatio the m2WkRatio to set
     */
    public void setM2WkRatio(double m2WkRatio) {
        setWKRatio(3, m2WkRatio);
    }

    /**
     * @return the m1WkRatio
     */
    public double getM1WkRatio() {
        return getWKRatio(4);
    }

    /**
     * @param m1WkRatio the m1WkRatio to set
     */
    public void setM1WkRatio(double m1WkRatio) {
        setWKRatio(4, m1WkRatio);
    }

    /**
     * @return the p1WkRatio
     */
    public double getP1WkRatio() {
        return getWKRatio(6);
    }

    /**
     * @param p1WkRatio the p1WkRatio to set
     */
    public void setP1WkRatio(double p1WkRatio) {
        setWKRatio(6, p1WkRatio);
    }

    /**
     * @return the p2WkRatio
     */
    public double getP2WkRatio() {
        return getWKRatio(7);
    }

    /**
     * @param p2WkRatio the p2WkRatio to set
     */
    public void setP2WkRatio(double p2WkRatio) {
        setWKRatio(7, p2WkRatio);
    }

    /**
     * @return the p3WkRatio
     */
    public double getP3WkRatio() {
        return getWKRatio(8);
    }

    /**
     * @param p3WkRatio the p3WkRatio to set
     */
    public void setP3WkRatio(double p3WkRatio) {
        setWKRatio(8, p3WkRatio);
    }

    /**
     * @return the p4WkRatio
     */
    public double getP4WkRatio() {
        return getWKRatio(9);
    }

    /**
     * @param p4WkRatio the p4WkRatio to set
     */
    public void setP4WkRatio(double p4WkRatio) {
        setWKRatio(9, p4WkRatio);
    }

    /**
     * @return the ratioOf
     */
    public double getRatioOf() {
        return ratioOf[4];
    }

    /**
     * @param ratioOf the ratioOf to set
     */
    public void setRatioOf(double ratioOf) {
        this.ratioOf[4] = ratioOf;
    }

    /**
     * @return the salePerDay
     */
    public double getSalePerDay() {
        return salePerDay[4];
    }

    /**
     * @param salePerDay the salePerDay to set
     */
    public void setSalePerDay(double salePerDay) {
        this.salePerDay[4] = salePerDay;
    }
}
