package com.qa.constants;

public final class Constants {

	private Constants() {}
	
	private static final  String CONFIGPATH="./src/main/resources/config/config.properties";
	private static final  int EXPLICITWAIT= 10 ;
	
	public static int getExplicitWait() {
		return EXPLICITWAIT;
	}


	public static String getConfigPath() {
		return CONFIGPATH;
	}
}
