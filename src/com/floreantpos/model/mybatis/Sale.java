package com.floreantpos.model.mybatis;

/**
 * Base class containing rank sequence, period,
 * group id/name, branch id/name, product group no./name, product no./name
 * and common constants.
 *
 * @author dieter
 */
public abstract class Sale {

    public static final double NO_SALE = -1d;

    int rankSeq;
    String periodString;
    String groupId;
    String groupName;
    String branchId;
    String branchName;
    String productGroupNo;
    String productGroupName;
    String productNo;
    String productName;

    public int getRankSeq() {
        return rankSeq;
    }

    public void setRankSeq(int rankSeq) {
        this.rankSeq = rankSeq;
    }

    public String getPeriodString() {
        return periodString;
    }

    public void setPeriodString(String periodString) {
        this.periodString = periodString;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getProductGroupNo() {
        return productGroupNo;
    }

    public void setProductGroupNo(String productGroupNo) {
        this.productGroupNo = productGroupNo;
    }

    public String getProductGroupName() {
        return productGroupName;
    }

    public void setProductGroupName(String productGroupName) {
        this.productGroupName = productGroupName;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
