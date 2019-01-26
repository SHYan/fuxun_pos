package com.floreantpos.model.mybatis;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** 
 *        @hibernate.class
 *         table="orgdim"
 *     
*/
public class OrgDimM implements Serializable {

    /** identifier field */
    private Integer orgDimId;

    /** nullable persistent field */
    private String branchId;

    /** nullable persistent field */
    private String branchName;

    /** nullable persistent field */
    private String operateBy;

    /** nullable persistent field */
    private Timestamp operateAt;



    /** persistent field */
    private List groupings;

    /** full constructor */
    public OrgDimM(
            String branchId, String branchName, String operateBy,
            Timestamp operateAt,  List groupings) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.operateBy = operateBy;
        this.operateAt = operateAt;
        this.groupings = groupings;
    }

    /** default constructor */
    public OrgDimM() {
    }

    /** minimal constructor */
    public OrgDimM(List groupings) {
        this.groupings = groupings;
    }

    /** 
     *            @hibernate.id
     *             generator-class="native"
     *             type="java.lang.Integer"
     *             column="orgdimid"
     *         
     */
    public Integer getOrgDimId() {
        return this.orgDimId;
    }

    public void setOrgDimId(Integer orgDimId) {
        this.orgDimId = orgDimId;
    }

    /** 
     *            @hibernate.property
     *             column="branchid"
     *             length="2147483647"
     *         
     */
    public String getBranchId() {
        return this.branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    /** 
     *            @hibernate.property
     *             column="branchname"
     *             length="2147483647"
     *         
     */
    public String getBranchName() {
        return this.branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    /** 
     *            @hibernate.property
     *             column="operateby"
     *             length="15"
     *         
     */
    public String getOperateBy() {
        return this.operateBy;
    }

    public void setOperateBy(String operateBy) {
        this.operateBy = operateBy;
    }

    /** 
     *            @hibernate.property
     *             column="operateat"
     *             length="29"
     *         
     */
    public Timestamp getOperateAt() {
        return this.operateAt;
    }

    public void setOperateAt(Timestamp operateAt) {
        this.operateAt = operateAt;
    }

    /** 
     *            @hibernate.set
     *             lazy="true"
     *             inverse="true"
     *             cascade="none"
     *            @hibernate.collection-key
     *             column="orgdimid"
     *            @hibernate.collection-one-to-many
     *             class="net.vivicloud.vivitrend.ibatis.bean.Grouping"
     *         
     */
    public List getGroupings() {
        return this.groupings;
    }

    public void setGroupings(List groupings) {
        this.groupings = groupings;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("orgDimId", getOrgDimId())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof OrgDimM) ) return false;
        OrgDimM castOther = (OrgDimM) other;
        return new EqualsBuilder()
            .append(this.getOrgDimId(), castOther.getOrgDimId())
            .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder()
            .append(getOrgDimId())
            .toHashCode();
    }

}
