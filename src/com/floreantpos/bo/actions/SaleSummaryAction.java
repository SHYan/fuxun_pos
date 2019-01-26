package com.floreantpos.bo.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Icon;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;

import com.floreantpos.bo.ui.BackOfficeWindow;
import com.floreantpos.report.SaleSummaryReportView;

public class SaleSummaryAction extends AbstractAction {
	public SaleSummaryAction() {
		super(com.floreantpos.POSConstants.REPORT_SALES_SUMMARY_REPORT);
	}

	public SaleSummaryAction(String name) {
		super(name);
	}

	public SaleSummaryAction(String name, Icon icon) {
		super(name, icon);
	}

	public void actionPerformed(ActionEvent e) {
		BackOfficeWindow window = com.floreantpos.util.POSUtil.getBackOfficeWindow();
		JTabbedPane tabbedPane = window.getTabbedPane();
		
		SaleSummaryReportView viewer = null;
		int index = tabbedPane.indexOfTab(com.floreantpos.POSConstants.REPORT_SALES_SUMMARY_REPORT);
		if (index == -1) {
			viewer = new SaleSummaryReportView();
			tabbedPane.addTab(com.floreantpos.POSConstants.REPORT_SALES_SUMMARY_REPORT, viewer);
		}
		else {
			viewer = (SaleSummaryReportView) tabbedPane.getComponentAt(index);
		}
		tabbedPane.setSelectedComponent(viewer);
	}

}
