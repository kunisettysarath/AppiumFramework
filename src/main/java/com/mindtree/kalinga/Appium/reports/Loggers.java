package com.mindtree.kalinga.Appium.reports;

import org.apache.log4j.Logger;

import org.apache.log4j.PropertyConfigurator;

public class Loggers {
	String className;

	public Loggers(String className) {

		this.className = className;
		PropertyConfigurator.configure("./src/main/resources/Log4J.properties");
	}

	public void mainLog(String message) {

		Logger logger = Logger.getLogger(className);

		logger.info(message);

	}
}
