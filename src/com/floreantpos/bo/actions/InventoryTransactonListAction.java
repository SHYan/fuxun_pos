package com.floreantpos.bo.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.JTabbedPane;

import com.floreantpos.bo.ui.BackOfficeWindow;
import com.floreantpos.bo.ui.inventory.TransactionInventory;

public class InventoryTransactonListAction extends AbstractAction {

	public InventoryTransactonListAction() {
		super("Transaction History");
	}

	public InventoryTransactonListAction(String name) {
		super(name);
	}

	public InventoryTransactonListAction(String name, Icon icon) {
		super(name, icon);
	}

	public void actionPerformed(ActionEvent e) {
		String tab_name = "Transaction History";
		BackOfficeWindow backOfficeWindow = com.floreantpos.util.POSUtil.getBackOfficeWindow();
		
		TransactionInventory trans = null;
		JTabbedPane tabbedPane = backOfficeWindow.getTabbedPane();
		int index = tabbedPane.indexOfTab("Transaction History");
		if (index == -1) {
			trans = new TransactionInventory();
			tabbedPane.addTab(tab_name, trans);
		}
		else {
			trans = (TransactionInventory) tabbedPane.getComponentAt(index);
		}
		tabbedPane.setSelectedComponent(trans);
	}

}
