package com.floreantpos.model.mybatis;

/**
 *  java bean for product listbox option
 * @author dieter
 */
public class ProductM {

    private String productNo;
    private String productName;

    @Override
    public String toString() {
        return "Product No.: " + productNo + "\tName: " + productName;
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

}
