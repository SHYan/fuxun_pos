package com.floreantpos.bo.ui.inventory;

import com.floreantpos.swing.TransparentPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableColumnModel;

import net.miginfocom.swing.MigLayout;

import org.jdesktop.swingx.JXTable;

import com.floreantpos.Messages;
import com.floreantpos.POSConstants;
import com.floreantpos.bo.ui.BOMessageDialog;
import com.floreantpos.bo.ui.explorer.ExplorerButtonPanel;
import com.floreantpos.model.MenuGroup;
import com.floreantpos.model.dao.MenuGroupDAO;
import com.floreantpos.model.InventoryTransaction;
import com.floreantpos.mybatis.IBatisFactory;
import com.floreantpos.swing.BeanTableModel;
import com.floreantpos.ui.dialog.BeanEditorDialog;
import com.floreantpos.ui.dialog.ComboItemSelectionDialog;
import com.floreantpos.ui.model.MenuGroupForm;
import com.floreantpos.ui.model.StockControlDialog;
import com.floreantpos.util.POSUtil;

public class TransactionInventory extends TransparentPanel {

	private JXTable table;
	private BeanTableModel<InventoryTransaction> tableModel;
	
	private JTextField tfName;
	private JComboBox cbType;
	
	public TransactionInventory(){
		
		HashMap map = new HashMap();
		List<InventoryTransaction> dataSource = IBatisFactory.selectList("inventory_transaction.get_inventory_transaction", map);
		
		tableModel = new BeanTableModel<InventoryTransaction>(InventoryTransaction.class);
		tableModel.addColumn("Transaction Date", "transactionDate"); 
		tableModel.addColumn("Item Name", "ItemName"); 
		tableModel.addColumn("Old Qty", "oldQuantity"); 
		tableModel.addColumn("Trans: Qty", "Quantity"); 
		tableModel.addColumn("Price", "unitPrice"); 
		tableModel.addColumn("Type", "tranType"); 
		tableModel.addColumn("Remark", "remark"); 
		tableModel.addColumn("Vendor Name", "VendorName"); 
		tableModel.addRows(dataSource);
		
		table = new JXTable(tableModel);
		table.setRowHeight(30);
		
		setLayout(new BorderLayout(5, 5));
		add(new JScrollPane(table));

		add(createButtonPanel(), BorderLayout.SOUTH);
		add(buildSearchForm(), BorderLayout.NORTH);
		
		resizeColumnWidth(table);

	}

	private JPanel buildSearchForm() {
		JPanel panel = new JPanel();
		panel.setLayout(new MigLayout("", "[][]15[][]15[][]15[]", "[]5[]")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

		JLabel lblType = new JLabel("Type"); //$NON-NLS-1$
		cbType = new javax.swing.JComboBox();
		cbType.addItem("ALL"); 
		cbType.addItem("Procurement"); 
		cbType.addItem("Demage"); 
		cbType.addItem("Inventory");
		cbType.addItem("Others"); 
		cbType.setPreferredSize(new Dimension(198, 0));

		JLabel lblName = new JLabel(Messages.getString("MenuItemExplorer.0")); //$NON-NLS-1$
		tfName = new JTextField(15);

		try {
			JButton searchBttn = new JButton(Messages.getString("MenuItemExplorer.3")); //$NON-NLS-1$
			JButton addBttn = new JButton("Inventory Control"); //$NON-NLS-1$
			panel.add(lblName, "align label"); //$NON-NLS-1$
			panel.add(tfName);
			panel.add(lblType); 
			panel.add(cbType); 
			panel.add(searchBttn);
			panel.add(addBttn);

			Border loweredetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
			TitledBorder title = BorderFactory.createTitledBorder(loweredetched, "Search"); //$NON-NLS-1$
			title.setTitleJustification(TitledBorder.LEFT);
			panel.setBorder(title);

			searchBttn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					searchItem();
				}
			});
			
			addBttn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						StockControlDialog dialog = new StockControlDialog();
						dialog.setSize(1024, 700);
						dialog.open();
					} catch (Exception x) {
						BOMessageDialog.showError(com.floreantpos.POSConstants.ERROR_MESSAGE, x);
					}
				}
			});

		} catch (Throwable x) {
			BOMessageDialog.showError(POSConstants.ERROR_MESSAGE, x);
		}

		return panel;
	}

	private void searchItem() {
		Object selectedType = cbType.getSelectedItem();
		HashMap map = new HashMap();
		if(selectedType == "ALL" )  
			map.put("selectedType", null);
		else
			map.put("selectedType", selectedType.toString());
		map.put("keyword", tfName.getText().toString());
		List<InventoryTransaction> dataSource = IBatisFactory.selectList("inventory_transaction.get_inventory_transaction", map);
		tableModel.removeAll();
		tableModel.addRows(dataSource);
	}

	private TransparentPanel createButtonPanel() {
		ExplorerButtonPanel explorerButton = new ExplorerButtonPanel();
		JButton addButton = explorerButton.getAddButton();

		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					StockControlDialog dialog = new StockControlDialog();
					dialog.setSize(1024, 700);
					dialog.open();
					if (dialog.isCanceled())
						return;
				} catch (Exception x) {
					BOMessageDialog.showError(com.floreantpos.POSConstants.ERROR_MESSAGE, x);
				}
			}

		});

		TransparentPanel panel = new TransparentPanel();
		return panel;
	}

	protected MenuGroup getSelectedMenuGroup(MenuGroup defaultValue) {
		List<MenuGroup> menuGroups = MenuGroupDAO.getInstance().findAll();
		ComboItemSelectionDialog dialog = new ComboItemSelectionDialog("SELECT GROUP", "Menu Group", menuGroups, false);
		dialog.setSelectedItem(defaultValue);
		dialog.setVisibleNewButton(true);
		dialog.pack();
		dialog.open();

		if (dialog.isCanceled())
			return null;

		if (dialog.isNewItem()) {
			MenuGroup foodGroup = new MenuGroup();
			MenuGroupForm editor = new MenuGroupForm(foodGroup);
			BeanEditorDialog editorDialog = new BeanEditorDialog(POSUtil.getBackOfficeWindow(), editor);
			editorDialog.open();
			if (editorDialog.isCanceled())
				return null;
			return getSelectedMenuGroup(foodGroup);
		}
		return (MenuGroup) dialog.getSelectedItem();
	}

	public void resizeColumnWidth(JTable table) {
		final TableColumnModel columnModel = table.getColumnModel();
		for (int column = 0; column < table.getColumnCount(); column++) {
			columnModel.getColumn(column).setPreferredWidth((Integer) getColumnWidth().get(column));
		}
	}

	private List getColumnWidth() {
		List<Integer> columnWidth = new ArrayList();
		//columnWidth.add(20);
		columnWidth.add(100);
		columnWidth.add(200);
		columnWidth.add(50);
		columnWidth.add(50);
		columnWidth.add(50);
		columnWidth.add(50);
		columnWidth.add(100);
		columnWidth.add(100);

		return columnWidth;
	}
}