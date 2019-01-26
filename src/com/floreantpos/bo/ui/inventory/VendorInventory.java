package com.floreantpos.bo.ui.inventory;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.floreantpos.POSConstants;
import com.floreantpos.bo.ui.BOMessageDialog;
import com.floreantpos.model.InventoryVendor;
import com.floreantpos.model.dao.InventoryVendorDAO;
import com.floreantpos.swing.BeanTableModel;
import com.floreantpos.swing.ListTableModel;
import com.floreantpos.swing.TransparentPanel;
import com.floreantpos.ui.PosTableRenderer;
import com.floreantpos.ui.dialog.BeanEditorDialog;
import com.floreantpos.ui.dialog.ConfirmDeleteDialog;
import com.floreantpos.ui.model.VendorEntryDialog;
import com.floreantpos.util.POSUtil;

public class VendorInventory extends TransparentPanel {
	private JTable table;
	private BeanTableModel<InventoryVendor> tableModel;
	
	public VendorInventory() {
		
		tableModel = new BeanTableModel<InventoryVendor>(InventoryVendor.class);
		
		//HashMap map = new HashMap();
		//List<InventoryVendor> dataSource = IBatisFactory.selectList("inventory_transaction.get_inventory_vendor", map);
		
		tableModel.addColumn(POSConstants.ID.toUpperCase(), "id"); //$NON-NLS-1$
		tableModel.addColumn(POSConstants.NAME.toUpperCase(), "name"); //$NON-NLS-1$
		tableModel.addColumn("ADDRESS", "address"); //$NON-NLS-1$
		tableModel.addColumn("CITY", "city"); //$NON-NLS-1$
		tableModel.addColumn("COUNTRY", "country");
		tableModel.addColumn(POSConstants.TELEPHONE.toUpperCase(), "phone"); //$NON-NLS-1$
		tableModel.addColumn("EMAIL", "email"); //$NON-NLS-1$
		//tableModel.addRows(dataSource);
		tableModel.addRows(InventoryVendorDAO.getInstance().findAll());
		table = new JTable(tableModel);
		table.setDefaultRenderer(Object.class, new PosTableRenderer());
		
		setLayout(new BorderLayout(5,5));
		add(new JScrollPane(table));
		addButtonPanel();
	}
	
	private void addButtonPanel() {
		JButton addButton = new JButton(com.floreantpos.POSConstants.ADD);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					VendorEntryDialog editor = new VendorEntryDialog();
					BeanEditorDialog dialog = new BeanEditorDialog(POSUtil.getBackOfficeWindow(), editor);
					dialog.open();
					if (dialog.isCanceled())
						return;

					InventoryVendor v = (InventoryVendor)editor.getBean();
					tableModel.addRow(v);
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

					index = table.convertRowIndexToModel(index);
					InventoryVendor v = tableModel.getRow(index);

					VendorEntryDialog editor = new VendorEntryDialog(v);
					BeanEditorDialog dialog = new BeanEditorDialog(POSUtil.getBackOfficeWindow(), editor);
					dialog.open();
					if (dialog.isCanceled())
						return;

					table.repaint();
				
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

					if (ConfirmDeleteDialog.showMessage(VendorInventory.this, com.floreantpos.POSConstants.CONFIRM_DELETE, com.floreantpos.POSConstants.DELETE) == ConfirmDeleteDialog.YES) {
						InventoryVendor wh = (InventoryVendor) tableModel.getRow(index);
						InventoryVendorDAO.getInstance().delete(wh);
						tableModel.removeRow(index);
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
	
	
	
	class InventoryVendorTableModel extends ListTableModel {
		
		InventoryVendorTableModel(List list){
			super(new String[] {com.floreantpos.POSConstants.ID, com.floreantpos.POSConstants.NAME, com.floreantpos.POSConstants.ADDRESS_LINE1, com.floreantpos.POSConstants.TELEPHONE, "Email"}, list);
		}
		

		public Object getValueAt(int rowIndex, int columnIndex) {
			InventoryVendor vendor = (InventoryVendor) rows.get(rowIndex);
			
			switch(columnIndex) {
				case 0:
					return String.valueOf(vendor.getId());
					
				case 1:
					return vendor.getName();
					
				case 2:
					return vendor.getAddress()+", "+vendor.getCity()+", "+vendor.getCountry();
					
				case 3:
					return vendor.getPhone();
					
				case 4:
					return vendor.getEmail();
					
			}
			return null;
		}
	}
}