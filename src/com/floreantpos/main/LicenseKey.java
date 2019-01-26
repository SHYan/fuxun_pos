package com.floreantpos.main;


import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.floreantpos.config.ui.DatabaseConfigurationDialog;
import com.floreantpos.model.License;
import com.floreantpos.mybatis.IBatisFactory;
import com.orocube.common.util.TerminalUtil;

public class LicenseKey {
	private String server_key = "5@rv@rEncryptK@y";
	private String client_key = "Cl!@ntEncryptK@y";
	private String initVector = "aesencryptIntVec";
	
	public LicenseKey(){
		
	}

	public boolean licenseValidation(){
		String addr = TerminalUtil.getSystemUID();
	    String mac_addr = getMacAddress();
	    if ((mac_addr != "") && 
	      (checkValid(mac_addr))) {
	      return true;
	    }
	    if ((addr != "") && 
	      (checkValid(addr))) {
	      return true;
	    }
		return false;
	}
	
	public  String getMacAddress(){
		try{
			InetAddress address = InetAddress.getLocalHost();
	
		    NetworkInterface ni = NetworkInterface.getByInetAddress(address);
		    byte[] mac = ni.getHardwareAddress();
		    String macAddress = "";
		    StringBuilder sb = new StringBuilder();
		    for (int i = 0; i < mac.length; i++) {
		    	macAddress = sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : "")).toString();
		    }
		    return macAddress;
		}catch(Exception e){
			 return "";
		}
	}
	
	public String getPre(String addr){
		String [] k = addr.split("-");
		String regKey = "";
		for(int i=0; i<k.length;i++){
			if(k[i].length() <= 4){
				if(regKey == "")
					regKey = k[i].substring(0, 2);
				else
					regKey = regKey +k[i].substring(0, 2);
			}
			else{
				if(regKey == "")
					regKey = k[i].substring(0, 3);
				else
					regKey = regKey +k[i].substring(0, 3);
			}
		}
		return regKey;
	}
	
	public  boolean checkValid(String addr){
		try{
			
			List<License> l_key;
			HashMap map = new HashMap();
			l_key = IBatisFactory.selectList("license.get_license", map);
			if(l_key.size() == 0){
				return false;
			}
			else{
				String regKey = getPre(addr);
				boolean is_client = false;
				for(License lic : l_key){
					if(lic.getLkey().equals(encrypt_key(regKey, server_key).substring(0,10)) && lic.getMaddress().equals(addr)){
						return true;
					}
					if(lic.getLkey().equals(encrypt_key(regKey, client_key).substring(0,10)) && lic.getMaddress().equals(addr)){
						is_client = true;
						break;
					}
				}
				if(is_client){
					for(License lic : l_key){
						if(lic.getKey_type()){
							String regKey1 = getPre(lic.getMaddress());
							if(lic.getLkey().equals(encrypt_key(regKey1, server_key).substring(0,10))) { // && lic.getMaddress().equals(lic.getMaddress())){
								return true;
							}
						}
					}
				}
				return false;
			}
		}
		catch(Exception ex)
		{	DatabaseConfigurationDialog dialog = new DatabaseConfigurationDialog();
			dialog.pack();
			dialog.open();
		}
		return false;
	}
	
	public  String encrypt_key(String value, String use_key) {
		try {
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(use_key.getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

			byte[] encrypted = cipher.doFinal(value.getBytes());
			//String encStr = Base64.encodeBase64String(encrypted);
			String encStr =  new String(Base64.encodeBase64(encrypted));
			return encStr.toUpperCase();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public boolean registerKey(String name, String key, Boolean key_type){
		Calendar currentTime = Calendar.getInstance();
		
		HashMap map = new HashMap();
		map.put("maddress", name);
		map.put("lkey", key); //enc key
		map.put("key_type", key_type); 
		map.put("create_date", currentTime.getTime()); 
		IBatisFactory.insertSQL("license.delete_license", map); //delete old one
		IBatisFactory.insertSQL("license.insert_license", map);
		return true;
	}
}
