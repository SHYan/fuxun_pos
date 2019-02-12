package com.floreantpos.ui.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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
import com.floreantpos.ui.tableselection.DefaultTableSelectionView;
import com.floreantpos.ui.views.order.OrderController;

public class MobiServo {
	Log logger = LogFactory.getLog(MobiServo.class);
	
	public void writeTmp() {
		BufferedWriter bw = null;
		FileWriter fw = null;
		String fileName = System.getProperty("user.dir")+"/mobiTmp.txt";
		
		try {
			String content = "This is the content to write into file\n";
			fw = new FileWriter(fileName);
			bw = new BufferedWriter(fw);
			bw.write(content);
			System.out.println("Done");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
	}
	
	public void newTicket() {
		logger.debug("MobiServo : newTicket(");
		
		Application application = Application.getInstance();
		writeTmp();
		Ticket ticket = new Ticket();
		ticket.setPriceIncludesTax(application.isPriceIncludesTax());
		OrderTypeDAO od = new OrderTypeDAO();
		
		ticket.setOrderType(od.get(1));
		ticket.setTicketType("DINE IN");
		
		ticket.setNumberOfGuests(1);
		ticket.setTerminal(application.getTerminal());
		ticket.setOwner(Application.getCurrentUser());
		ticket.setShift(application.getCurrentShift());
		
		Calendar currentTime = Calendar.getInstance();
		ticket.setCreateDate(currentTime.getTime());
		ticket.setCreationHour(currentTime.get(Calendar.HOUR_OF_DAY));
		
		ShopTable selectedTables = ShopTableDAO.getInstance().getByNumber(1);
		selectedTables.setServing(true);
		
		ticket.addTable(selectedTables.getTableNumber());
		ticket.addTableName(selectedTables.getDescOrNum());
		
		//ShopTable sp = ShopTableDAO.getInstance().getByNumber(shopTable.getTableNumber());
		//System.out.println(shopTable.getDescOrNum()+"-- is desc :"+sp.getDescOrNum());
		
		
		MenuItem menuItem = MenuItemDAO.getInstance().get(4);
		MenuItemDAO dao = new MenuItemDAO();
		menuItem = dao.initialize(menuItem);
		
		TicketItem ticketItem = menuItem.convertToTicketItem(ticket.getOrderType(), 4, menuItem.getPrice(null));
		MenuModifier mf1 = MenuModifierDAO.getInstance().get(1);
		ticketItem.addTicketItemModifier(mf1, TicketItemModifier.NORMAL_MODIFIER, ticket.getOrderType(), null);
		ticketItem.setHasModifiers(true);
		ticketItem.setTicket(ticket);
		ticketItem.calculatePrice();
		
		MenuItem menuItem2 = MenuItemDAO.getInstance().get(3);
		MenuItemDAO dao2 = new MenuItemDAO();
		menuItem2 = dao2.initialize(menuItem2);
		
		TicketItem ticketItem2 = menuItem2.convertToTicketItem(ticket.getOrderType(), 3, menuItem2.getPrice(null));
		MenuModifier mf2 = MenuModifierDAO.getInstance().get(2);
		ticketItem2.addTicketItemModifier(mf2, TicketItemModifier.NORMAL_MODIFIER, ticket.getOrderType(), null);
		MenuModifier mf3 = MenuModifierDAO.getInstance().get(3);
		ticketItem2.addTicketItemModifier(mf3, TicketItemModifier.NORMAL_MODIFIER, ticket.getOrderType(), null);
		ticketItem2.setHasModifiers(true);
		ticketItem2.setTicket(ticket);
		ticketItem2.calculatePrice();
		
		List<TicketItem> tl = new ArrayList<TicketItem>();
		tl.add(ticketItem);
		tl.add(ticketItem2);
		ticket.setTicketItems(tl);
		
		ticket.calculatePrice();
		
		TicketDAO.getInstance().saveOrUpdate(ticket);
		
		ShopTableStatus shopTableStatus = selectedTables.getShopTableStatus();
		shopTableStatus.setTableTicket(ticket.getId(), ticket.getOwner().getId(), ticket.getOwnerName());
		//logger.debug("Table status is ------- "+shopTableStatus.getTicketId());
		selectedTables.setShopTableStatus(shopTableStatus);
		
		
		
		ActionHistoryDAO actionHistoryDAO = ActionHistoryDAO.getInstance();
		User user = Application.getCurrentUser();
		ShopTableDAO.getInstance().occupyTables(ticket);
		actionHistoryDAO.saveHistory(user, ActionHistory.NEW_CHECK, POSConstants.RECEIPT_REPORT_TICKET_NO_LABEL + ":" + ticket.getId()); //$NON-NLS-1$
		
		if (ticket.getOrderType().isShouldPrintToKitchen()) {
			if (ticket.needsKitchenPrint()) {
				ReceiptPrintService.printToKitchen(ticket);
				TicketDAO.getInstance().refresh(ticket);
			}
		}
		OrderController.saveOrder(ticket);
		
		if(DefaultTableSelectionView.getInstance()!=null) {
			DefaultTableSelectionView dtv= DefaultTableSelectionView.getInstance();
			dtv.updateView(false);
			dtv.setOrderType(ticket.getOrderType());
			dtv.redererTables();
		}
		else logger.debug("Table Selected view is null");
	}
	
}
