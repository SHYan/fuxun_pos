package com.floreantpos.model.mybatis;

/**
 * A record of season sale.
 * @author jeff
 */
public class SeasonSaleM extends Sale {
    
    /** PK */
    private Long seasonId;

    /** 季度銷售實績 season sale */
    private Double seasonSale;

    /** 季營業日數 */
    private Double saleDayCount;

    /** 銷售佔比 = 已銷售實績 / sum(銷售實績) */
    private Double ratioOf;

    /** 營業日額 = 銷售實績 / 營業日數 */
    private Double salePerDay;
    
    /** 前年同季比 minus 2 year Ratio: annual sale (m2 year) / annual sale (this year) */
    private Double m2YrRatio;

    /** 去年同季比 minus 1 year Ratio: annual sale (m1 year) / annual sale (this year */
    private Double m1YrRatio;

    /** 上季比 minus 1 season Ratio: */
    private Double m1SzRatio;

    @Override
    public String toString() {
        return getSeasonId()
                + " " + getRankSeq()
                + " " + getPeriodString()
                + " " + getBranchId()
                + " " + getBranchName()
                + " " + getProductGroupNo()
                + " " + getProductGroupName()
                + " " + getProductNo()
                + " " + getProductName()
                + " " + getSeasonSale()
                + " " + getSaleDayCount()
                + " " + getRatioOf()
                + " " + getSalePerDay()
                + "  [RATIO]" + getM2YrRatio()
                + " " + getM1YrRatio()
                + " " + getM1SzRatio();
    }

    /**
     * @return the seasonId
     */
    public Long getSeasonId() {
        return seasonId;
    }

    /**
     * @param seasonId the seasonId to set
     */
    public void setSeasonId(Long seasonId) {
        this.seasonId = seasonId;
    }

    /**
     * @return the seasonSale
     */
    public Double getSeasonSale() {
        return seasonSale;
    }

    /**
     * @param seasonSale the seasonSale to set
     */
    public void setSeasonSale(Double seasonSale) {
        this.seasonSale = seasonSale;
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
     * @return the m1SzRatio
     */
    public Double getM1SzRatio() {
        return m1SzRatio;
    }

    /**
     * @param m1SzRatio the m1SzRatio to set
     */
    public void setM1SzRatio(Double m1SzRatio) {
        this.m1SzRatio = m1SzRatio;
    }


}
