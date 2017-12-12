package scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;

public class TestLogin extends BaseTest{

	@Test()
	public void testLogin() throws InterruptedException{
		LoginPage loginPage = new LoginPage(driver);
		String userName = Lib.getCellValue(EXCEL_PATH, "ValidLogin", 1, 0);
		String passWord = Lib.getCellValue(EXCEL_PATH, "ValidLogin", 1, 1);

		loginPage.setUsername(userName);
		Thread.sleep(3000);
		loginPage.setPassword(passWord);
		Thread.sleep(3000);
		loginPage.clickLogin();
		
		Thread.sleep(3000);
		
		String expectedTitle = Lib.getCellValue(EXCEL_PATH, "ValidLogin", 1, 2);
				
		String actualTitle = driver.getTitle();
		
		Reporter.log(actualTitle, true);
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualTitle, expectedTitle);
		softAssert.assertAll();
	}
}