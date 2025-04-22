package com.utility;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import com.constants.Env;

public class PropertiesUtil {
	public static String readProperties(Env env,String propertyName) {
		System.out.println(System.getProperty("user.dir"));
		File propFile = new File(System.getProperty("user.dir") + "//config//" + env + ".properties");
		FileReader fileReader = null;
		Properties properties=new Properties();
		try {
			fileReader=new FileReader(propFile);
			properties.load(fileReader);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		String value = properties.getProperty(propertyName.toUpperCase());
		return value;

	}

}
