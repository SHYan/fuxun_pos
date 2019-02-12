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
package com.floreantpos.mobi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.commons.io.IOUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import com.floreantpos.POSConstants;
import com.floreantpos.main.Application;
import com.floreantpos.model.ActionHistory;
import com.floreantpos.model.MenuItem;
import com.floreantpos.model.MenuModifier;
import com.floreantpos.model.ShopTable;
import com.floreantpos.model.ShopTableStatus;
import com.floreantpos.model.Ticket;
import com.floreantpos.model.TicketItem;
import com.floreantpos.model.TicketItemModifier;
import com.floreantpos.model.User;
import com.floreantpos.model.dao.ActionHistoryDAO;
import com.floreantpos.model.dao.MenuItemDAO;
import com.floreantpos.model.dao.MenuModifierDAO;
import com.floreantpos.model.dao.OrderTypeDAO;
import com.floreantpos.model.dao.ShopTableDAO;
import com.floreantpos.model.dao.TicketDAO;
import com.floreantpos.report.ReceiptPrintService;
import com.floreantpos.ui.views.order.OrderController;

public class MobiSchedule {
	static Log logger = LogFactory.getLog(MobiSchedule.class);
	
	/*============mobi=================*/
	public static int refreshDuration = 5000;
	public static String dirPath = "C:\\mobi_tmp\\";
	
	public static boolean runningFlag = false;
	public static Timer clockTimer = new Timer();
	
	public static void parseJson(File jsonFile) {
		if(jsonFile==null) return;
		
		try {
        	Application application = Application.getInstance();
        	String modifierStr;
            InputStream is = new FileInputStream(jsonFile);
            String jsonStr = IOUtils.toString(is, "UTF-8");
            JSONObject item, jsonObj = new JSONObject(jsonStr);//(JSONObject) parser.parse(new FileReader(jsonFile));
        	jsonObj = jsonObj.getJSONObject("value");

        	Ticket ticket;
        	Integer oldTicket = null;
        	if(jsonObj.has("ticketId") && jsonObj.get("ticketId")!=null)
        	oldTicket = Integer.valueOf(jsonObj.get("ticketId").toString());
        	
        	ShopTable selectedTables = null;
        	
        	if(oldTicket!=null && oldTicket!=0) {
        		ticket = TicketDAO.getInstance().get(oldTicket);
        		logger.debug(" old ticket "+ticket.getTicketItems().size());
        	} else {
        		ticket = new Ticket();
            	ticket.setPriceIncludesTax(application.isPriceIncludesTax());
        		OrderTypeDAO od = new OrderTypeDAO();
        		ticket.setOrderType(od.get(1));
        		ticket.setTicketType("DINE IN");
        		Calendar currentTime = Calendar.getInstance();
        		ticket.setCreateDate(currentTime.getTime());
        		ticket.setCreationHour(currentTime.get(Calendar.HOUR_OF_DAY));
        		ticket.setTerminal(application.getTerminal());
        		ticket.setShift(application.getCurrentShift());
        		ticket.setOwner(Application.getCurrentUser());
        		ticket.setOwnerName(Application.getCurrentUser().getFullName());
        		ticket.setNumberOfGuests((Integer)jsonObj.get("no_of_customers"));
        		
        		selectedTables = ShopTableDAO.getInstance().getByNumber(Integer.parseInt(jsonObj.get("table_no").toString()));
        		selectedTables.setServing(true);
        		ticket.addTable(selectedTables.getTableNumber());
        		ticket.addTableName(selectedTables.getDescOrNum());
        			
        	}
    		
            JSONArray itemArray = jsonObj.getJSONArray("Items");
            MenuItem menuItem;
            MenuModifier menuModifier;
            
            TicketItem ticketItem;
            List<TicketItem> ticketItemList = new ArrayList<TicketItem>();
            if(oldTicket != null && oldTicket>0) {
            	ticketItemList.addAll(ticket.getTicketItems());
            }
            
            if(itemArray==null) return;
            for(int i=0; i<itemArray.length(); i++) {
            	item = itemArray.getJSONObject(i);
            	
            	menuItem = MenuItemDAO.getInstance().get(Integer.parseInt(item.get("Product_No").toString()));
        		MenuItemDAO dao = new MenuItemDAO();
        		menuItem = dao.initialize(menuItem);
            	//logger.debug(item.get("Qty").toString()+" is Qty");
        		ticketItem = menuItem.convertToTicketItem(ticket.getOrderType(), Double.parseDouble(item.get("Qty").toString()), menuItem.getPrice(null));
        		//logger.debug("Ticket item qty is : "+ticketItem.getItemQuantity());
        		//ticketItem.setItemQuantity(Double.parseDouble(item.get("Qty").toString()));
        		modifierStr = item.getString("Condiment");
            	if(modifierStr!=null && !modifierStr.equals("")) {
            		String[] modifierObjList = modifierStr.split(",", -1);
            		for(int j=0; j<modifierObjList.length; j++) {
            			String[] modifierObj = modifierObjList[j].split("\\|", -1);
            			menuModifier = MenuModifierDAO.getInstance().get(Integer.parseInt(modifierObj[0]));
                		ticketItem.addTicketItemModifier(menuModifier, TicketItemModifier.NORMAL_MODIFIER, ticket.getOrderType(), null);
                		ticketItem.setHasModifiers(true);
                		//[0]id[1]name[2]Price[3]number
            		}
            	}
            	ticketItem.setTicket(ticket);
        		ticketItem.calculatePrice();
            	
        		ticketItemList.add(ticketItem);
        		
            }
            
            ticket.setTicketItems(ticketItemList);
            ticket.calculatePrice();
    		
    		TicketDAO.getInstance().saveOrUpdate(ticket);
    		
    		if(oldTicket == null || oldTicket==0) {
	    		ShopTableStatus shopTableStatus = selectedTables.getShopTableStatus();
	    		shopTableStatus.setTableTicket(ticket.getId(), ticket.getOwner().getId(), ticket.getOwnerName());
	    		selectedTables.setShopTableStatus(shopTableStatus);
	    		ShopTableDAO.getInstance().occupyTables(ticket);
    		}
    		
    		ActionHistoryDAO actionHistoryDAO = ActionHistoryDAO.getInstance();
    		User user = Application.getCurrentUser();
    		
    		actionHistoryDAO.saveHistory(user, ActionHistory.NEW_CHECK, POSConstants.RECEIPT_REPORT_TICKET_NO_LABEL + ":" + ticket.getId()); //$NON-NLS-1$
    		
    		if (ticket.getOrderType().isShouldPrintToKitchen()) {
    			if (ticket.needsKitchenPrint()) {
    				ReceiptPrintService.printToKitchen(ticket);
    				TicketDAO.getInstance().refresh(ticket);
    			}
    		}
    		OrderController.saveOrder(ticket);
    		
    		is.close();
    		if(!jsonFile.delete()) jsonFile.renameTo(new File(jsonFile.getAbsoluteFile()+".bp"));
    		if(jsonFile.exists()) jsonFile.renameTo(new File(jsonFile.getAbsoluteFile()+".bp"));
    		
            
        }catch(Exception e) {
        	e.printStackTrace();
        	//logger.debug(jsonFile.getAbsolutePath());
        	jsonFile.renameTo(new File(jsonFile.getAbsoluteFile()+".bp"));
        }
	}
	
	public static void checkMobiUpload() {
		try {
			File dir = new File(dirPath);
			File[] files = dir.listFiles(new FilenameFilter(){
			    public boolean accept(File dir, String name){
			        return name.toLowerCase().endsWith(".json");
			    }
			});
			if(files==null) return;
			for(File file : files){
			    if(file.isFile()){
			        parseJson(file);
			    }
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			runningFlag = false;
		}
	}

	public static void startMobiTimer() {
		clockTimer.scheduleAtFixedRate(new TimerTask() {
			  @Override
			  public void run() {
				  if(runningFlag) return;
				  runningFlag = true;
				  checkMobiUpload();
				  runningFlag = false;
			  }
			}, 60000, refreshDuration);
	}

}
