/*
 * IBatisFactory.java
 *
 * Created on 2008�~5��22��, �W�� 10:11
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.floreantpos.mybatis;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.floreantpos.config.AppConfig;

/**
 * Using ibatis 3.0
 * 
 * @author angle
 * 
 */
public class IBatisFactory {
//	private static Log logger = LogFactory.getLog(IBatisFactory.class);
	public static String DEFAULT_SCHEMA = "public";
	private static SqlSessionFactory sqlMapper;
	private static IBatisFactory instance = new IBatisFactory();

	/** Creates a new instance of IBatisFactory */
	private IBatisFactory() {
		// use this for mybatis 3.0.3 and before, see official issue 14
		// incorrect parsing non-ascii(e.g. comments in chinese) mapping file on Windows
		// Resources.setCharset(java.nio.charset.Charset.forName("UTF-8"));
		try {
			Properties properties = new Properties();
			properties.setProperty("username", AppConfig.getDatabaseUser());
			properties.setProperty("password", AppConfig.getDatabasePassword());
			properties.setProperty("url", "jdbc:postgresql://"+AppConfig.getDatabaseHost()+"/"+AppConfig.getDatabaseName());
			
		//	Reader reader = Resources.getResourceAsReader("myBatisConfig.xml", properties);

			InputStream inputStream = Resources.getResourceAsStream("myBatisConfig.xml");
			//JOptionPane.showMessageDialog(null, "sqlmapper start");
			sqlMapper = new SqlSessionFactoryBuilder().build(inputStream, properties);
			
			//sqlMapper = new SqlSessionFactoryBuilder().build(inputStream);
			inputStream.close();
		} catch (IOException ioe) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ioe.printStackTrace(pw);
        } catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(
					"Something bad happened while building the SqlMapClient instance." + e, e);
		}
	}

	public static void setSChema(String schema){
		DEFAULT_SCHEMA = schema;
	}
	public static IBatisFactory getInstance() {
		return instance;
	}
	
	public SqlSession getSqlSession() {
		SqlSession s = sqlMapper.openSession();
		try {
			s.getConnection().createStatement().execute("SET search_path = "+DEFAULT_SCHEMA);
			//s.getConnection().createStatement().execute("SET TIMEZONE TO '" +customerTimezone+"'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

    public static List selectList(String mybatisQueryId, Map parameters) {
        SqlSession session = getInstance().getSqlSession();
        List list = session.selectList(mybatisQueryId, parameters);
        session.close(); 
        return list;
    }
    

    /**
     * John Edit for SelectOneItem, Insert, Update and Delete ing ViViManager
     * =====================START===========================
     */
    
    /**
     * 執行某個檔案裡面的所有sql query
     * @param filePath 檔案完整路徑
     * @param ibatisId ibatisId，預設 utils.executeSql
     * @return
     */
    public static boolean executeFile(String filePath, String ibatisId) {

        SqlSession session = getInstance().getSqlSession();
        boolean ret = true;
        try{
        	if(ibatisId==null || ibatisId.equals("")) ibatisId = "utils.executeSql";
			FileInputStream in = new FileInputStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			while((strLine = br.readLine())!= null){
				if(strLine.indexOf(";") > -1) {
					strLine = strLine.replace(';', ' ');
				}
				if(strLine==null || strLine.equals("")) continue;
				String value = strLine;
				session.update(ibatisId, value);
			}
			in.close();
		}catch(Exception e){
			session.rollback();
			ret = false;
		}
        session.commit();
        session.close(); 
        return ret;
    }
    
    public static Object selectOneSQL(String mybatisQueryId, Map parameters) {
        SqlSession session = getInstance().getSqlSession();
        Object list = (Object) session.selectOne(mybatisQueryId, parameters);
        session.close(); 
        return list;
    }
    
    public static int insertSQL(String mybatisQueryId, Map parameters) {

    	SqlSession session = getInstance().getSqlSession();
        int ret = session.insert(mybatisQueryId, parameters);
        session.commit();
        session.close(); 
        return ret;
    }
    
    public static int updateSQL(String mybatisQueryId, Map parameters) {

    	SqlSession session = getInstance().getSqlSession();
        int ret = session.update(mybatisQueryId, parameters);
        session.commit();
        session.close(); 
        return ret;
    }
    
    public static int deleteSQL(String mybatisQueryId, Map parameters) {

    	SqlSession session = getInstance().getSqlSession();
        int ret = session.delete(mybatisQueryId, parameters);
        session.commit();
        session.close(); 
        return ret;
    }
    /*================John Edit End=========================*/

}
