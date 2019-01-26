package com.floreantpos.bo.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.JTabbedPane;

import com.floreantpos.bo.ui.BackOfficeWindow;
import com.floreantpos.bo.ui.inventory.VendorInventory;

public class InventoryVendorAction extends AbstractAction {
	
	public InventoryVendorAction() {
		super("Vendor");
	}

	public InventoryVendorAction(String name) {
		super(name);
	}

	public InventoryVendorAction(String name, Icon icon) {
		super(name, icon);
	}

	public void actionPerformed(ActionEvent e) {
		String tab_name = "Vendor";
		BackOfficeWindow backOfficeWindow = com.floreantpos.util.POSUtil.getBackOfficeWindow();
		
		VendorInventory explorer = null;
		JTabbedPane tabbedPane = backOfficeWindow.getTabbedPane();
		int index = tabbedPane.indexOfTab(tab_name);
		if (index == -1) {
			explorer = new VendorInventory();
			tabbedPane.addTab(tab_name, explorer);
		}
		else {
			explorer = (VendorInventory) tabbedPane.getComponentAt(index);
		}
		tabbedPane.setSelectedComponent(explorer);
		
	}

}
