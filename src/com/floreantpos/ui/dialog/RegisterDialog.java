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
package com.floreantpos.ui.dialog;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import com.floreantpos.IconFactory;
import com.floreantpos.Messages;
import com.floreantpos.main.Application;
import com.floreantpos.main.LicenseKey;
import com.floreantpos.main.Main;
import com.floreantpos.util.POSUtil;
import com.orocube.common.util.TerminalUtil;

public class RegisterDialog extends POSDialog{
	private JTextField tfTerminalRegKey;
	private JTextField tfTerminalKey;
	private JCheckBox chckbxDefault;
	private JPanel contentPanel;
	
	public RegisterDialog() {
		super(POSUtil.getBackOfficeWindow(), "Register"); 
		setIconImage(Application.getApplicationIcon().getImage());
	}

	@Override
	protected void initUI() {
		contentPanel = new JPanel(new BorderLayout(20, 20));
		contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		//JLabel logoLabel = new JLabel(IconFactory.getIcon("/icons/", "fp_logo128x128.png")); 
		//contentPanel.add(logoLabel, BorderLayout.WEST);

		JLabel l = new JLabel("<html><center><h1>"+Application.getTitle()+"</h1></center></html>"); //$NON-NLS-1$ //$NON-NLS-2$
		contentPanel.add(l);

		JPanel buttonPanel = new JPanel(new MigLayout("fill"));
		JButton btnOk = new JButton(Messages.getString("AboutDialog.5")); //$NON-NLS-1$
		
		chckbxDefault = new JCheckBox("Set Server Key"); //$NON-NLS-1$
		chckbxDefault.setSelected(true);
		buttonPanel.add(chckbxDefault, "newline,growx"); //$NON-NLS-1$

		tfTerminalKey = new JTextField();
		tfTerminalKey.setHorizontalAlignment(JTextField.CENTER);
		tfTerminalKey.setEditable(false);
		LicenseKey lkey = new LicenseKey();
	    tfTerminalKey.setText(lkey.getMacAddress());
	    
		//tfTerminalKey.setText(TerminalUtil.getSystemUID());
		tfTerminalKey.setBorder(null);
		tfTerminalKey.setFont(tfTerminalKey.getFont().deriveFont(Font.BOLD, 18));
		buttonPanel.add(new JSeparator(), "growx");
		buttonPanel.add(tfTerminalKey, "newline,growx");
		
		JLabel key = new JLabel("Type Key Here");
		key.setFont(tfTerminalKey.getFont().deriveFont(Font.BOLD, 12));
		buttonPanel.add(key,"newline");
		
		tfTerminalRegKey = new JTextField();
		tfTerminalRegKey.setFocusable(true);
		buttonPanel.add(tfTerminalRegKey,"newline, growx");
		
		buttonPanel.add(new JSeparator(), "newline, growx");
		
		buttonPanel.add(btnOk, "newline,center");
		contentPanel.add(buttonPanel, BorderLayout.SOUTH);

		add(contentPanel);
		
		setUndecorated(true);
		//save key to table
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tfTerminalRegKey.getText().isEmpty())
					System.exit(0);
				else
				{
					LicenseKey lic = new LicenseKey();
					if(tfTerminalRegKey.getText().equals("ShowServerKey")) {
						JOptionPane.showMessageDialog(POSUtil.getBackOfficeWindow(), lic.encrypt_key(lic.getPre(tfTerminalKey.getText()), "5@rv@rEncryptK@y"));
					}
					
					if(lic.registerKey(tfTerminalKey.getText(), tfTerminalRegKey.getText().toUpperCase(),chckbxDefault.isSelected()))
						JOptionPane.showMessageDialog(POSUtil.getBackOfficeWindow(), Messages.getString("RegisterKey")); //$NON-NLS-1$
					
					try {
						Main.restart();
					} catch (IOException e1) {
						e1.printStackTrace();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					} catch (URISyntaxException e1) {
						e1.printStackTrace();
					}
				}
			}
		});	
		
	}

}
