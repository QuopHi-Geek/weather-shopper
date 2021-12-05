package com.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Properties;

import com.qa.constants.Constants;
import com.qa.enums.ConfigProperties;

// This class is to read everything stored in properties file. As of now, we have only stored url there but many more things can be stored.
public final class PropertyUtils {

	private PropertyUtils() {}

	static Properties prop = new Properties();
	static {

		File src = new File(Constants.getConfigPath());
		FileInputStream fis;
		try {
			fis = new FileInputStream(src);
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public static String get(ConfigProperties key) throws NullPointerException {
		String value = prop.getProperty(key.toString().toLowerCase()) ;
		if (Objects.isNull(key) || Objects.isNull(value)) {
			throw new NullPointerException("Either key with name "+key+" or its value "+value+ " is null") ;
		}
		return value.trim() ;
	}
	
}
