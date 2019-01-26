package com.floreantpos.bo.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.JTabbedPane;

import com.floreantpos.bo.ui.BackOfficeWindow;
import com.floreantpos.bo.ui.inventory.WarehouseInventory;

public class InventoryWarehouseAction extends AbstractAction {
	
	public InventoryWarehouseAction() {
		super("Warehouse");
	}

	public InventoryWarehouseAction(String name) {
		super(name);
	}

	public InventoryWarehouseAction(String name, Icon icon) {
		super(name, icon);
	}

	public void actionPerformed(ActionEvent e) {
		String tab_name = "Warehouse";
		BackOfficeWindow backOfficeWindow = com.floreantpos.util.POSUtil.getBackOfficeWindow();
		
		WarehouseInventory explorer = null;
		JTabbedPane tabbedPane = backOfficeWindow.getTabbedPane();
		int index = tabbedPane.indexOfTab(tab_name);
		if (index == -1) {
			explorer = new WarehouseInventory();
			tabbedPane.addTab(tab_name, explorer);
		}
		else {
			explorer = (WarehouseInventory) tabbedPane.getComponentAt(index);
		}
		tabbedPane.setSelectedComponent(explorer);
		
	}

}
