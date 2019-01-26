package com.floreantpos.model.mybatis;

/**
 *
 * @author jeff
 */
public class CateM {
    private String cateNo;
    private String cateName;

    @Override
    public String toString() {
        return "Category No.: " + cateNo + "\tName: " + cateName;
    }

    /**
     * @return the cateNo
     */
    public String getCateNo() {
        return cateNo;
    }

    /**
     * @param cateNo the cateNo to set
     */
    public void setCateNo(String cateNo) {
        this.cateNo = cateNo;
    }

    /**
     * @return the cateName
     */
    public String getCateName() {
        return cateName;
    }

    /**
     * @param cateName the cateName to set
     */
    public void setCateName(String cateName) {
        this.cateName = cateName;
    }


}
