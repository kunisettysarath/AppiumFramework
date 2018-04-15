package com.mindtree.kalinga.Appium.reports;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Assertions {

	WebDriver driver;

	public Assertions(WebDriver driver) {
		super();
		this.driver = driver;
	}

	// *****************************Assert SendKeys************************
	public boolean assertSendkeys(WebElement element, String data) {

		String data1 = element.getAttribute("value");
		if (data1.equals(data)) {
			return true;
		} else
			return false;
	}

	// *****************************Assert Select***************************

	public boolean assertSelect(WebElement element) {
		boolean result = false;
		try {
			result = element.isSelected();
			return result;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return result;
	}

	public String assertScreenShot(String fileName) throws IOException {
		fileName = fileName + ".png";

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("/EasyBucksAutomationFramework/Screenshots" + fileName));
		String destination = "/EasyBucksAutomationFramework/Screenshots" + fileName;
		return destination;

	}

}
