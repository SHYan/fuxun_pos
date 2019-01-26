package com.floreantpos.bo.ui.inventory;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.floreantpos.bo.ui.BOMessageDialog;
import com.floreantpos.model.InventoryWarehouse;
import com.floreantpos.model.dao.InventoryWarehouseDAO;
import com.floreantpos.swing.ListTableModel;
import com.floreantpos.swing.TransparentPanel;
import com.floreantpos.ui.PosTableRenderer;
import com.floreantpos.ui.dialog.ConfirmDeleteDialog;
import com.floreantpos.ui.model.WarehouseEntryDialog;

public class WarehouseInventory extends TransparentPanel {
	private JTable table;
	private InventoryWarehouseTableModel tableModel;
	
	public WarehouseInventory() {
		List<InventoryWarehouse> warehouse = new InventoryWarehouseDAO().findAll();
		
		tableModel = new InventoryWarehouseTableModel(warehouse);
		table = new JTable(tableModel);
		table.setDefaultRenderer(Object.class, new PosTableRenderer());
		
		setLayout(new BorderLayout(5,5));
		add(new JScrollPane(table));
		
		JButton addButton = new JButton(com.floreantpos.POSConstants.ADD);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					WarehouseEntryDialog dialog = new WarehouseEntryDialog();
					dialog.open();
					if (dialog.isCanceled())
						return;
					InventoryWarehouse wh = dialog.getInventoryWarehouse();
					tableModel.addItem(wh);
				} catch (Exception x) {
				BOMessageDialog.showError(com.floreantpos.POSConstants.ERROR_MESSAGE, x);
				}
			}
			
		});
		
		JButton editButton = new JButton(com.floreantpos.POSConstants.EDIT);
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int index = table.getSelectedRow();
					if (index < 0)
						return;

					InventoryWarehouse wh = (InventoryWarehouse) tableModel.getRowData(index);
					WarehouseEntryDialog dialog = new WarehouseEntryDialog();
					dialog.setInventoryWarehouse(wh);
					dialog.open();
					if (dialog.isCanceled())
						return;

					tableModel.updateItem(index);
				} catch (Throwable x) {
				BOMessageDialog.showError(com.floreantpos.POSConstants.ERROR_MESSAGE, x);
				}
			}
			
		});
		
		JButton deleteButton = new JButton(com.floreantpos.POSConstants.DELETE);
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int index = table.getSelectedRow();
					if (index < 0)
						return;

					if (ConfirmDeleteDialog.showMessage(WarehouseInventory.this, com.floreantpos.POSConstants.CONFIRM_DELETE, com.floreantpos.POSConstants.DELETE) == ConfirmDeleteDialog.YES) {
						InventoryWarehouse wh = (InventoryWarehouse) tableModel.getRowData(index);
						InventoryWarehouseDAO.getInstance().delete(wh);
						tableModel.deleteItem(index);
					}
				} catch (Exception x) {
				BOMessageDialog.showError(com.floreantpos.POSConstants.ERROR_MESSAGE, x);
				}
			}
			
		});

		TransparentPanel panel = new TransparentPanel();
		panel.add(addButton);
		panel.add(editButton);
		panel.add(deleteButton);
		add(panel, BorderLayout.SOUTH);
	}
	
	class InventoryWarehouseTableModel extends ListTableModel {
		
		InventoryWarehouseTableModel(List list){
			super(new String[] {com.floreantpos.POSConstants.ID, com.floreantpos.POSConstants.NAME}, list);
		}
		

		public Object getValueAt(int rowIndex, int columnIndex) {
			InventoryWarehouse warehouse = (InventoryWarehouse) rows.get(rowIndex);
			
			switch(columnIndex) {
				case 0:
					return String.valueOf(warehouse.getId());
					
				case 1:
					return warehouse.getName();
					
			}
			return null;
		}
	}
}
