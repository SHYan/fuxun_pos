package com.floreantpos.bo.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;

import com.floreantpos.bo.ui.BackOfficeWindow;
import com.floreantpos.report.PayoutReportView;

public class PayoutReportAction extends AbstractAction {

	public PayoutReportAction() {
		super(com.floreantpos.POSConstants.REPORT_PAYOUT_REPORT);
	}

	public PayoutReportAction(String name) {
		super(name);
	}

	public PayoutReportAction(String name, Icon icon) {
		super(name, icon);
	}

	public void actionPerformed(ActionEvent e) {
		BackOfficeWindow window = com.floreantpos.util.POSUtil.getBackOfficeWindow();
		JTabbedPane tabbedPane = window.getTabbedPane();
		
		PayoutReportView viewer = null;
		int index = tabbedPane.indexOfTab(com.floreantpos.POSConstants.REPORT_PAYOUT_REPORT);
		if (index == -1) {
			viewer = new PayoutReportView();
			tabbedPane.addTab(com.floreantpos.POSConstants.REPORT_PAYOUT_REPORT, viewer);
		}
		else {
			viewer = (PayoutReportView) tabbedPane.getComponentAt(index);
		}
		tabbedPane.setSelectedComponent(viewer);
	}
}
