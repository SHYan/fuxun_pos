package com.floreantpos.main;

import java.util.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import com.floreantpos.model.SalesSummary;
import com.floreantpos.mybatis.IBatisFactory;

public class SalesSummaryAction {
	
	public SalesSummaryAction(){
		
	}

	public boolean save_sales_summary(){
		try{
			Calendar currentTime = Calendar.getInstance();
			currentTime.add(Calendar.DATE, -1); // number represents number of days
			Date yesterday = currentTime.getTime();
			
			HashMap map = new HashMap();
			List<SalesSummary> max_sales_summary = IBatisFactory.selectList("sales_summary.get_sales_summary_exist", map); //get maximum date
			if(max_sales_summary.size() > 0){  
				for(SalesSummary summary : max_sales_summary){
					if(summary.getId() != 0){ //get MAX Date
						if(!summary.getTransactionDate().toString().equals(yesterday)){ //max_date is not equal to yesterday
							long days = (yesterday.getTime() -  summary.getTransactionDate().getTime()) /(1000 * 60 * 60 *24);
							for(int i=1; i<=days; i++){
								Date max_date = summary.getTransactionDate();
								Calendar c = Calendar.getInstance();
								c.setTime(summary.getTransactionDate());
								c.add(Calendar.DATE, i);
								max_date = c.getTime();
								HashMap map1 = new HashMap();
								map1.put("transaction_date", max_date);
								List<SalesSummary> sales_summary = IBatisFactory.selectList("sales_summary.get_sales_summary_from_ticket", map1); //get maximum date
								saveToDb(sales_summary);
							}
						}
					}
					else{ 
						List<SalesSummary>  all_sales_summary = IBatisFactory.selectList("sales_summary.get_all_sales_summary_from_ticket", null); //get maximum date
						saveToDb(all_sales_summary);
					}
				}
			}
			
		}catch(Exception ex){
			System.out.print(ex.toString());
		}
		return true;
	}
	
	public void saveToDb(List<SalesSummary>  sales_summary){
		/*HashMap map1 = new HashMap();
		map1.put("transaction_date", trans_date);
		List<SalesSummary>  sales_summary = IBatisFactory.selectList("sales_summary.get_sales_summary_from_ticket", map1); //get maximum date
		*/
		for(SalesSummary summary : sales_summary){
			HashMap map = new HashMap();
			map.put("transaction_date", summary.getTransactionDate());
			map.put("qty", summary.getItemQty());
			map.put("sub_total", summary.getSubtotalAmount());
			map.put("delivery", summary.getDeliveryCharge());
			map.put("discount", summary.getDiscountAmount());
			map.put("tax", summary.getTaxAmount());
			map.put("service_charge", summary.getServiceCharge());
			map.put("total", summary.getTotalAmount());
			map.put("guest", summary.getNumberOfGuests());
			IBatisFactory.insertSQL("sales_summary.insert_sales_summary", map);
		}
	}
}
