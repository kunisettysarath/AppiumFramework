package com.mindtree.kalinga.Appium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.mindtree.kalinga.Appium.base.HelperElements;
import com.mindtree.kalinga.Appium.inteface.SignUpInterface;
import com.mindtree.kalinga.Appium.locators.SignUp;
import com.mindtree.kalinga.Appium.reports.Loggers;
import com.mindtree.kalinga.Appium.reports.Reporters;
import com.mindtree.kalinga.Appium.utils.ExcelUtil;
import com.mindtree.kalinga.Appium.utils.WaitUtil;

public class SignUpImplementation implements SignUpInterface {

	WebDriver driver;

	Loggers log = new Loggers("SignUpImplementation");
	// BaseClass base= new BaseClass();
	Reporters repo;

	public SignUpImplementation(WebDriver driver, Reporters repo) {
		super();
		this.driver = driver;
		this.repo = repo;
	}

	public void signUp(String testCase) throws Exception {
		
		HelperElements help = new HelperElements(driver);
		WebElement body = driver.findElement(By.tagName("body"));
		SignUp sign = new SignUp(driver);

		ExcelUtil excel = new ExcelUtil();

		String fullName = excel.getCellData("Data", "FullName", testCase,"SignUp");
		System.out.println(fullName);

		sign.getHomeSignUp().click();
		Thread.sleep(2000);
		

		sign.getFullName().sendKeys(fullName);

		if (!(body.getText()).contains("Allowed characters(a-z,A-Z)")) {
			repo.addMsg("Full Name entered");

			sign.getEmail().sendKeys(excel.getCellData("Data", "Email", testCase,"SignUp"));
			repo.addMsg("Email entered");
			if (!(body.getText()).contains("Seems Invalid Email!!")) {
				sign.getPassword().sendKeys(excel.getCellData("Data", "Password", testCase,"SignUp"));

				log.mainLog("Password entered");
				if (!(body.getText()).contains("!!Should contains uppercase,lowercase,specialcharacter,minsize 6")) {

					sign.getconfirmPassword().sendKeys(excel.getCellData("Data", "ConfPassword", testCase,"SignUp"));
					repo.addMsg("Confirm Password entered");
					if (sign.getPassword().getAttribute("value")
							.equals(sign.getconfirmPassword().getAttribute("value"))) {

						help.selectBoxByVisibleText(sign.getRole(), excel.getCellData("Data", "Role", testCase,"SignUp"));
						repo.addMsg("Role Selected");
						help.enableElementAndClick("/html/body/app-root/app-signup/div/div/div/form/a[1]/button",
								sign.getRegisterButton());
						Thread.sleep(2000);
						help.clickOnAlertOK();
						Thread.sleep(3000);
							repo.addMsg("Successfully Registered");
							Assert.assertTrue(true);
						
					} else {
						repo.addMsg("Values in 'Password' field and 'Confirm Password' field are not same");
						System.out.println("Values in 'Password' field and 'Confirm Password' field are not same");
						Assert.assertTrue(true);

					}
				} else {
					repo.addMsg("Entered Password is Improper");
					System.out.println("Entered Password is Improper");
					Assert.assertTrue(true);

				}

			} else {
				repo.addMsg("Entered Email is Improper");
				System.out.println("Entered Email is Improper");
				Assert.assertTrue(true);

			}
		}

		else {
			repo.addMsg("Entered Name is Improper");
			System.out.println("Entered Name is Improper");
			Assert.assertTrue(true);

		}

	}

}
