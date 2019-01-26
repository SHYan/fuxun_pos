package com.floreantpos.model.mybatis;

/**
 *
 * @author dieter
 */
public class BranchStatisticM {

    private String districtName;
    private String branchName;
    private double branchTotalQty;
    private double branchProductQty;
    private double branchProductsRatio;
    private double productRatio;
    private double allProductRatio;

    public String toString() {
        return super.toString() + "[ "
                + getDistrictName() + " "
                + getBranchName() + " "
                + getBranchTotalQty() + " "
                + getBranchProductQty() + " "
                + getBranchProductsRatio() + " "
                + getProductRatio() + " "
                + getAllProductRatio() + " ]";
    }

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public double getBranchTotalQty() {
		return branchTotalQty;
	}

	public void setBranchTotalQty(double branchTotalQty) {
		this.branchTotalQty = branchTotalQty;
	}

	public double getBranchProductQty() {
		return branchProductQty;
	}

	public void setBranchProductQty(double branchProductQty) {
		this.branchProductQty = branchProductQty;
	}

	public double getBranchProductsRatio() {
		return branchProductsRatio;
	}

	public void setBranchProductsRatio(double branchProductsRatio) {
		this.branchProductsRatio = branchProductsRatio;
	}

	public double getProductRatio() {
		return productRatio;
	}

	public void setProductRatio(double productRatio) {
		this.productRatio = productRatio;
	}

	public double getAllProductRatio() {
		return allProductRatio;
	}

	public void setAllProductRatio(double allProductRatio) {
		this.allProductRatio = allProductRatio;
	}

}
