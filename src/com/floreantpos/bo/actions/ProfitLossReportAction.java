package com.floreantpos.bo.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;

import com.floreantpos.bo.ui.BackOfficeWindow;
import com.floreantpos.report.ProfitLossReportView;

public class ProfitLossReportAction extends AbstractAction {
	public ProfitLossReportAction() {
		super(com.floreantpos.POSConstants.REPORT_PROFIT_LOSS_REPORT);
	}

	public ProfitLossReportAction(String name) {
		super(name);
	}

	public ProfitLossReportAction(String name, Icon icon) {
		super(name, icon);
	}

	public void actionPerformed(ActionEvent e) {
		BackOfficeWindow window = com.floreantpos.util.POSUtil.getBackOfficeWindow();
		JTabbedPane tabbedPane = window.getTabbedPane();
		
		ProfitLossReportView viewer = null;
		int index = tabbedPane.indexOfTab(com.floreantpos.POSConstants.REPORT_PROFIT_LOSS_REPORT);
		if (index == -1) {
			viewer = new ProfitLossReportView();
			tabbedPane.addTab(com.floreantpos.POSConstants.REPORT_PROFIT_LOSS_REPORT, viewer);
		}
		else {
			viewer = (ProfitLossReportView) tabbedPane.getComponentAt(index);
		}
		tabbedPane.setSelectedComponent(viewer);
	}
}
