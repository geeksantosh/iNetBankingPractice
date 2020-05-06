package com.inetBanking.testCases;


import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_LoginTestDD_002 extends BaseClass{

	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) throws Exception {

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("Username entered");
		lp.setPassword(pwd);
		logger.info("Password entered");
		lp.clickSubmit();

		Thread.sleep(3000);

		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept(); //close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");

		}else {
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept(); //close logout alert
			driver.switchTo().defaultContent();
		}
	}

	public boolean isAlertPresent() {  //user defined method to check alert is present or not.

		try {
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@DataProvider(name="LoginData")
	String [][] getData() throws Exception{

		String path = System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/LoginData.xlsx";

		int rownum = XLUtils.getRowCount(path, "sheet1");
		int colcount = XLUtils.getCellCount(path, "sheet1", 1);

		String logindata[][] = new String[rownum][colcount];

		for(int i=1; i<=rownum; i++) {
			for(int j =0; j<colcount; j++) {

				logindata[i-1][j] = XLUtils.getCellData(path, "sheet1", i, j); //1 0

			}
		}
		return logindata;
	}
}
