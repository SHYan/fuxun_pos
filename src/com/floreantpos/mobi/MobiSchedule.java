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
package com.floreantpos.mobi;

import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.JsonParser;

public class MobiSchedule {
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy, hh:mm:ss aaa"); //$NON-NLS-1$

	public static boolean runningFlag = false;
	public static Timer clockTimer = new Timer();
	public static String dirPath = System.getProperty("user.dir")+"/mobi_tmp/";


	
	public static void parseJson(File jsonFile) {
		JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(jsonFile));
            JSONObject jsonObject = (JSONObject) obj;
        }catch(Exception e) {
        	
        }
	}
	
	public static void checkMobiUpload() {
		try {
			File dir = new File(dirPath);
			File[] files = dir.listFiles(new FilenameFilter(){
			    public boolean accept(File dir, String name){
			        return name.toLowerCase().endsWith(".json");
			    }
			});
	
			for(File file : files){
			    if(file.isFile()){
			        parseJson(file);
			    }
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			runningFlag = false;
		}
	}

	public static void startMobiTimer() {
		clockTimer.scheduleAtFixedRate(new TimerTask() {
			  @Override
			  public void run() {
				  runningFlag = true;
				  checkMobiUpload();
			  }
			}, 5*60*1000, 30*1000);
	}

}
