package com.floreantpos.model.mybatis;

import java.sql.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 *
 * @author jeff
 */
public class PeriodM {
    private String periodString;

    private Date minday;

    public String toString() {
        return new ToStringBuilder(this)
            .append("periodString", getPeriodString())
            .toString();
    }

    /**
     * @return the periodString
     */
    public String getPeriodString() {
        return periodString;
    }

    /**
     * @param periodString the periodString to set
     */
    public void setPeriodString(String periodString) {
        this.periodString = periodString;
    }

    /**
     * @return the minday
     */
    public Date getMinday() {
        return minday;
    }

    /**
     * @param minday the minday to set
     */
    public void setMinday(Date minday) {
        this.minday = minday;
    }


}
