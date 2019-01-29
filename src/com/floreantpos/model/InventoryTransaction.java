/**
 * ************************************************************************
 * * The contents of this file are subject to the MRPL 1.2
 * * (the  "License"),  being   the  Mozilla   Public  License
 * * Version 1.1  with a permitted attribution clause; you may not  use this
 * * file except in compliance with the License. You  may  obtain  a copy of
 * * the License at http://www.floreantpos.org/license.html
 * * Software distributed under the License  is  distributed  on  an "AS IS"
 * * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * * License for the specific  language  governing  rights  and  limitations
 * * under the License.
 * * The Original Code is FLOREANT POS.
 * * The Initial Developer of the Original Code is OROCUBE LLC
 * * All portions are Copyright (C) 2015 OROCUBE LLC
 * * All Rights Reserved.
 * ************************************************************************
 */
package com.floreantpos.model;

import java.util.List;

import com.floreantpos.model.base.BaseInventoryTransaction;

public class InventoryTransaction extends BaseInventoryTransaction {
	private static final long serialVersionUID = 1L;
	
	//Diana
	private Integer item_id; 
	private String item_name;
	private String vendor_name;
	private String tran_type;
	private String remark;
	
/*[CONSTRUCTOR MARKER BEGIN]*/
	public InventoryTransaction () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public InventoryTransaction (java.lang.Integer id) {
		super(id);
	}

/*[CONSTRUCTOR MARKER END]*/

	public static String PROP_TYPE = "type"; //$NON-NLS-1$
	
	protected InventoryTransactionType type;
	
	public InventoryTransactionType getType() {
		return type;
	}
	
	public void setType(InventoryTransactionType type) {
		this.type = type;
	}

	public Object getStockAmount() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setStockAmount(double stockAmount) {
		// TODO Auto-generated method stub
		
	}

	public void setOrderTypeList(List<OrderType> orderTypes) {
		// TODO Auto-generated method stub
		
	}
	
    public String getItemName() {
        return item_name;
    }

    public void setItemName(String item_name) {
        this.item_name = item_name;
    }
    
    public String getVendorName() {
        return vendor_name;
    }

    public void setVendorName(String vendor_name) {
        this.vendor_name = vendor_name;
    }
    
    public String getTranType() {
        return tran_type;
    }

    public void setTranType(String tran_type) {
        this.tran_type = tran_type;
    }
    
    public Integer getItemId () {
		return item_id;
	}
	public void setItemId (Integer item_id ) {
		this.item_id = item_id;
	}
    
   /* public String getRemark() {
        return remark;
    }
    
    public void setRemark(String remark) {
    	this.remark = remark;
    }
*/
}