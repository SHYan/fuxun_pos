package com.floreantpos.model.mybatis;

import java.sql.Date;

/**
 * DailySaleStatistic.zul
 *
 * @author dieter
 */
public class BranchDailySaleM extends Sale {

    private Date period;
    private Double sale;

    public String toString() {
        return "[" + getBranchId() + "; " + branchName + "; " + period +"; " + sale + "]";
    }

    public Date getPeriod() {
        return period;
    }

    public void setPeriod(Date period) {
        this.period = period;
    }

    public Double getSale() {
        return sale;
    }

    public void setSale(Double sale) {
        this.sale = sale;
    }

}
