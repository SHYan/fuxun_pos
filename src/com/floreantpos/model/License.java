package com.floreantpos.model;

import java.util.Date;

public class License {
	private String maddress;
	private String lkey;
	private Boolean key_type;
	private Date create_date;
	private int id;
	
	public License(){
	}
	
	public License(java.lang.String m_address, java.lang.String l_key){
		this.setMaddress(m_address);
		this.setLkey(l_key);
	}
	
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	
	
	public String getMaddress(){
		return maddress;
	}
	public void setMaddress(String maddress){
		this.maddress = maddress;
	}
	
	public String getLkey(){
		return lkey;
	}
	public void setLkey(String lkey){
		this.lkey = lkey;
	}
	
	public Boolean getKey_type(){
		return key_type;
	}
	public void setKey_type(Boolean key_type){
		this.key_type = key_type;
	}
	
	public Date getCreate_date(){
		return create_date;
	}
	public void setCreate_date(Date create_date){
		this.create_date = create_date;
	}
	
}
