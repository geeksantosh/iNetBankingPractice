package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ReadConfig {
	
	Properties properties;
	
	public ReadConfig() {
		File src = new File("./Configuration/Config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			properties = new Properties();
			properties.load(fis);
		}catch (Exception e) {
			System.out.println("Exception is "+ e.getMessage());
		}
	}
	
	public String getApplicationURL() {
		String url = properties.getProperty("baseURL");
		return url;
	}
	
	public String getUsername() {
		String username = properties.getProperty("username");
		return username;
	}
	
	public String getPassword() {
		String password = properties.getProperty("password");
		return password;
	}
	
	public String getChromepath() {
		String chromepath = properties.getProperty("chromepath");
		return chromepath;
	}
	
	public String getIEpath() {
		String iepath = properties.getProperty("iepath");
		return iepath;
	}
	
	public String getFirefoxpath() {
		String firefoxpath = properties.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	
	

}
