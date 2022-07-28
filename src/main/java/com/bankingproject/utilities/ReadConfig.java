package com.bankingproject.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public ReadConfig() {
		File src = new File("C:\\Users\\CHETAN\\eclipse-workspace\\chetanbank\\configuration\\config.properties");
		FileInputStream file;
		
		try {
			 file = new FileInputStream(src);
			 pro = new Properties();
			 pro.load(file);
		}
			 catch(Exception e){
				 System.out.println(e.getMessage());
			 }
	}
		public String getApplicationURL() {
			String url = pro.getProperty("baseURL");
			return url;
		}
		
		public String getUserName() {
			String username = pro.getProperty("username");
			return username;
		}
		
		public String getUserPassword() {
			String password = pro.getProperty("password");
			return password;
		}
		
		}
	


