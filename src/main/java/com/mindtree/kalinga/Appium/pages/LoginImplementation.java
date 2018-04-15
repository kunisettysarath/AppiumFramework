package com.mindtree.kalinga.Appium.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.mindtree.kalinga.Appium.base.HelperElements;
import com.mindtree.kalinga.Appium.inteface.LoginInterface;
import com.mindtree.kalinga.Appium.locators.Login;
import com.mindtree.kalinga.Appium.reports.Assertions;
import com.mindtree.kalinga.Appium.reports.Loggers;
import com.mindtree.kalinga.Appium.reports.Reporters;
import com.mindtree.kalinga.Appium.utils.ExcelUtil;

public class LoginImplementation implements LoginInterface {
	WebDriver driver;

	String className = this.getClass().getName();
	Loggers log = new Loggers("LoginImplementation");
	Reporters repo;
	public LoginImplementation(WebDriver driver,Reporters repo ) {
		super();
		this.driver = driver;
		this.repo=repo;
	}

	public void login(String testCase) throws Exception {

		HelperElements help = new HelperElements(driver);

		Assertions objAssert = new Assertions(driver);

		Login login = new Login(driver);

		ExcelUtil excel = new ExcelUtil();
		
		login.getHomeLoginButton().click();
		Thread.sleep(3000);
		String userName = excel.getCellData("Data", "Email", testCase,"Login");
		System.out.println(userName);

		login.getUname().sendKeys(userName);

		if (objAssert.assertSendkeys(login.getUname(), userName)) {
			log.mainLog("Username entered");
			repo.addMsg("Username entered");
			
			login.getPassword().sendKeys(excel.getCellData("Data", "Password", testCase,"Login"));
			log.mainLog("password entered");
			repo.addMsg("password entered");
			help.mouseLeftClick(login.getLoginButton());
			log.mainLog("Login button clicked");
			repo.addMsg("Login button clicked");
		}

		else {
			Assert.assertTrue(false);
		}

	}

}
