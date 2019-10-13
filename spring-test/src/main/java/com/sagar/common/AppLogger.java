package com.sagar.common;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SocketHandler;

public class AppLogger
 {
	private static Logger LOGGER = Logger.getLogger("com.sagar.test");
	
	static {
		Handler handler = null;
//		try {
//			fileHandler = new FileHandler("/home/shaggyy28/eclipse-workspace/Exercise/spring-test/logs/test.out", true);
//		} catch (SecurityException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		try {
//			handler = new SocketHandler("localhost", 9999);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
//		LOGGER.addHandler(handler);
	}
	
	public static void info(String msg) {
		LOGGER.info(msg);
	}
	
	public static void error(String msg, Throwable throwable) {
		StackTraceElement[] stackTrace = throwable.getStackTrace();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < stackTrace.length; i++) {
			sb.append(stackTrace[i] + "\n");
		}
		LOGGER.severe(msg + "\n Error --> " + sb);
		
	}
	
}
