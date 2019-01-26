package com.floreantpos.bo.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.JTabbedPane;

import com.floreantpos.bo.ui.BOMessageDialog;
import com.floreantpos.bo.ui.BackOfficeWindow;
import com.floreantpos.bo.ui.inventory.TransactionInventory;
import com.floreantpos.ui.model.StockControlDialog;

public class InventoryTransactonAction extends AbstractAction {

	public InventoryTransactonAction() {
		super("Transaction");
	}

	public InventoryTransactonAction(String name) {
		super(name);
	}

	public InventoryTransactonAction(String name, Icon icon) {
		super(name, icon);
	}

	public void actionPerformed(ActionEvent e) {
		/*String tab_name = "Transaction";
		BackOfficeWindow backOfficeWindow = com.floreantpos.util.POSUtil.getBackOfficeWindow();
		
		TransactionInventory trans = null;
		JTabbedPane tabbedPane = backOfficeWindow.getTabbedPane();
		int index = tabbedPane.indexOfTab("Transaction");
		if (index == -1) {
			trans = new TransactionInventory();
			tabbedPane.addTab(tab_name, trans);
		}
		else {
			trans = (TransactionInventory) tabbedPane.getComponentAt(index);
		}
		tabbedPane.setSelectedComponent(trans);*/
		try {
			StockControlDialog dialog = new StockControlDialog();
			dialog.setSize(1024, 700);
			dialog.open();
		} catch (Exception x) {
			BOMessageDialog.showError(com.floreantpos.POSConstants.ERROR_MESSAGE, x);
		}
		
	}

}
