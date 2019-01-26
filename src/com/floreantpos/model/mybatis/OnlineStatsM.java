package com.floreantpos.model.mybatis;

/**
 *
 * @author John
 */
public class OnlineStatsM {
	
    private String schema;
    private String name;
    private Long number;
    private String branch;
    private String branchId;
    private String lastping;
    
	/**
	 * @return the schema
	 */
	public String getSchema() {
		return schema;
	}
	/**
	 * @param schema the schema to set
	 */
	public void setSchema(String schema) {
		this.schema = schema;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the branch
	 */
	public String getBranch() {
		return branch;
	}
	/**
	 * @param branch the branch to set
	 */
	public void setBranch(String branch) {
		this.branch = branch;
	}
	/**
	 * @return the lastping
	 */
	public String getLastping() {
		return lastping;
	}
	/**
	 * @param lastping the lastping to set
	 */
	public void setLastping(String lastping) {
		this.lastping = lastping;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public Long getNumber() {
		return number;
	}
	public void setNumber(Long number) {
		this.number = number;
	}


}
