package com.mindtree.kalinga.Appium.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotsUtil {

	public String addScreenShot(WebDriver driver, String fileName) throws IOException {
		
		fileName = fileName + ".png";
		//driver.manage().window().maximize();

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("/AppiumFramework/Screenshots" + fileName));
		String destination = "/AppiumFramework/Screenshots" + fileName;
		return destination;

	}

}
