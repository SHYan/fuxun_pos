package com.floreantpos.report;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsAbstractExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.FileResolver;
import net.sf.jasperreports.engine.util.JRProperties;
import net.sf.jasperreports.view.JRViewer;


/**
 * a
 * @since 2011-02-09
 * @author dieter
 */
public class JasperHelper {
    
	static final String MIME_TYPE_PDF = "application/pdf";
    //static final String MIME_TYPE_XLS = "application/vnd.ms-excel";
    static final String MIME_TYPE_XLS = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static final String MIME_TYPE_HTML = "text/html;charset=UTF-8";

    public static byte[] getExportBytes(String reportName, String exportType, List<?> dataSource) {
        return getExportBytes(reportName, exportType, dataSource, new HashMap<String, Object>());
    }
    
	public static byte[] getExportBytes(String reportName, String exportType, List<?> dataSource, Map<String, Object> params) {
        
		JasperReport jasperReport = ReportUtil.getReport(reportName);
        byte[] buf = null;
        
        params.put("IS_WRAP_BREAK_WORD", true);
		/*
		//params.put("TEMPLATE_FILE", "reportStyle_"+Locales.getThreadLocal()+".jrtx");
		if(Locales.getThreadLocal().toString().equals("zh_TW"))
			params.put("TEMPLATE_FILE", "reportStyle_zh_TW.jrtx");
		else if(Locales.getThreadLocal().toString().equals("zh_CN"))
			params.put("TEMPLATE_FILE", "reportStyle_zh_CN.jrtx");
		else params.put("TEMPLATE_FILE", "reportStyle.jrtx");
		
		String customerTimezone = (String) Sessions.getCurrent().getAttribute("timezone");
		if(Strings.isEmpty(customerTimezone)) customerTimezone = "PRC";
		//params.put(JRParameter.REPORT_LOCALE, )
		params.put(JRParameter.REPORT_TIME_ZONE, TimeZone.getTimeZone(customerTimezone));
		*/
		try {
            JasperPrint jasperPrint;
            JRProperties.setProperty(JRXlsAbstractExporter.PROPERTY_WRAP_TEXT, false);
            JRProperties.setProperty(JRHtmlExporterParameter.PROPERTY_WRAP_BREAK_WORD, false);
            JRProperties.setProperty("net.sf.jasperreports.awt.ignore.missing.font", "true");
            
            
            
            if (dataSource == null) {
                Connection connection = (Connection) params.get("REPORT_CONNECTION");
                if (connection == null)
                    throw new UnsupportedOperationException("no datasource nor dbconnectio is exists");
                jasperPrint = JasperFillManager.fillReport(jasperReport, params, connection );
            } else {
                jasperPrint = JasperFillManager.fillReport(jasperReport,
                    params, new JRBeanCollectionDataSource(dataSource));
            }

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            if ("pdf".equals(exportType)) {
                buf = JasperExportManager.exportReportToPdf(jasperPrint);
            } else if ("xls".equals(exportType)) {
            	 
                JRXlsxExporter exporter = new JRXlsxExporter();
                exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
                exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
                

                exporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, baos);
                exporter.exportReport();

                buf = baos.toByteArray();
            } else {
            	throw new UnsupportedOperationException("unsupport export type" + exportType);
            }

        } catch (JRException ex) {
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            System.out.println(sw.getBuffer().toString());
        }

        return buf;
    }

    /**
     * export report to pdf and excel with dataSource
     * @param reportName JasperReports jrxml template filename
     * @param exportType "pdf" or "xls"
     * @param dataSource
     * @param parameters
     */
    public static final void exportTo(String reportName, String exportType, List<?> dataSource, Map<String, Object> parameters) {
    
        final String fileName;
        final String mimeType;

        if ("pdf".equals(exportType)) {
            fileName = reportName + ".pdf";
            mimeType = MIME_TYPE_PDF;
        } else if ("xls".equals(exportType)) {
            fileName = reportName + ".xlsx";
            mimeType = MIME_TYPE_XLS;
        } else {
            throw new UnsupportedOperationException("unsupport export type: " + exportType);
        }
        final byte[] buf = getExportBytes(reportName, exportType, dataSource, parameters);
       // Filedownload.save(buf, mimeType, fileName);
    }
    
    /**
     * export report to pdf and excel with connection
     * @param reportName JasperReports jrxml template filename
     * @param exportType "pdf" or "xls"
     * @param connection
     * @param params
     */
    public static final void exportTo(String reportName, String exportType, Connection connection, Map<String, Object> params) {
        
        final String fileName;
        final String mimeType;

        if ("pdf".equals(exportType)) {
            fileName = reportName + ".pdf";
            mimeType = MIME_TYPE_PDF;
        } else if ("xls".equals(exportType)) {
            fileName = reportName + ".xls";
            mimeType = MIME_TYPE_XLS;
        } else {
            throw new UnsupportedOperationException("unsupport export type: " + exportType);
        }
        params.put("REPORT_CONNECTION", connection);
        final byte[] buf = getExportBytes(reportName, exportType, null, params);
        //Filedownload.save(buf, mimeType, fileName);
    }

    /**
     * export report to html with dataSource
     * @param reportName JasperReports jrxml template filename
     * @param dataSource
     * @param parameters
     * @return
     */
    /*
    public static final Media exportToHtml(String reportName, List<?> dataSource, Map<String, Object> parameters) {
    	
            return new AMedia(null,"html",MIME_TYPE_HTML,
                    getExportBytes(reportName, "html", dataSource, parameters));
                   
    }
    */
    /**
     * export report to html with sql connection
     * @param reportName JasperReports jrxml template filename
     * @param connection
     * @param params
     * @return
     */
    /*
	public static final Media exportToHtml(String reportName, Connection connection, Map<String, Object> params) {
		params.put("REPORT_CONNECTION", connection);
        return new AMedia(null,"html",MIME_TYPE_HTML,
                getExportBytes(reportName, "html", null, params));
	}
*/
}
