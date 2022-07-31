package com.iris22a.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropUtils {

	public String getValue(String filepath, String key) {
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			System.err.println("file not found");
		}
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			System.err.println("unable to load properties file");
		}
		return prop.getProperty(key);

	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public String[]getLocator(String key) {
		String baseDir = System.getProperty("user.dir");// CWD
		return getValue(baseDir+"/src/main/resources/OR.properties", key).split("##");

	}

}
