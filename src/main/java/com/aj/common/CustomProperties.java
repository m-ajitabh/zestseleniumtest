package com.aj.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CustomProperties {

	private static String value;

	public CustomProperties() {
	}

	private static String ReadFile(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("./application.properties");
		// System.getProperty("user.dir")).getAbsolutePath()
		prop.load(fis);
		return prop.getProperty(key);

	}

	public static String getConfigProperty(String key) {

		try {
			value = ReadFile(key);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;

	}

}
