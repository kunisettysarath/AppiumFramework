package com.mindtree.kalinga.Appium.base;

import java.io.IOException;
import java.util.ArrayList;

import com.mindtree.kalinga.Appium.utils.ExcelUtil;

public class TestDataReader {
	ExcelUtil excel = new ExcelUtil();

	public ArrayList getTestData(String Keyword) throws IOException {
		ArrayList<String> al = new ArrayList<String>();

		int startNum = excel.getStartRow("Data", Keyword);

		int endNum = excel.getEndRow("Data", startNum);


		int totalRow = endNum - startNum + 1;

		for (int i = startNum; i <= endNum; i++) {
			al.add(excel.getRowNumData("Data", i, "Testcase"));
		}
		return al;
	}

}
