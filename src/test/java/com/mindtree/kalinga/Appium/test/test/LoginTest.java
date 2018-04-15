package com.mindtree.kalinga.Appium.test.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.mindtree.kalinga.Appium.base.BaseClass;
import com.mindtree.kalinga.Appium.pages.CommonImplementation;

public class LoginTest extends BaseClass {

	int i = 0;

	@Test(invocationCount = 1, enabled = true)
	public void test1() throws Exception {

		caseList = read.getTestData("Login");
		this.repo = starts(caseList.get(i));
		CommonImplementation li = new CommonImplementation(driver, repo);
		li.implementationTestCases("Login", caseList.get(i));
		i++;
	}

	@Test(enabled = false)
	public void temp() throws IOException, InterruptedException {

		caseList = read.getTestData("JustClick");
		System.out.println(caseList);
		this.repo = starts(caseList.get(i));
		CommonImplementation li = new CommonImplementation(driver, repo);
		li.implementationTestCases("JustClick", caseList.get(i));
		i++;

	}

}
