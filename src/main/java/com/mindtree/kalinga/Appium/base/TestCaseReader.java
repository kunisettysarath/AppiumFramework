package com.mindtree.kalinga.Appium.base;

import java.io.IOException;
import java.util.ArrayList;

import com.mindtree.kalinga.Appium.utils.ExcelUtil;

public class TestCaseReader {
	ExcelUtil excel = new ExcelUtil();

	public ArrayList getTestCases(String Keyword) throws IOException {
		ArrayList<String> al = new ArrayList<String>();

		int startNum = excel.getStartRow("Data", Keyword);
		int endNum = excel.getEndRow("Data", startNum);

		//System.out.println(startNum + "  " + endNum);
		int totalRow = endNum - startNum+1;

		
		for (int i = 0; i < totalRow; i++) {
			al.add(excel.getRowNumData("Data", startNum + i, "Testcase"));
		}
		return al;
	}

}
