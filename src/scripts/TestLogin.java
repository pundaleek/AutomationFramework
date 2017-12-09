package scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;

public class TestLogin extends BaseTest{

	@Test()
	public void testLogin(){
		LoginPage loginPage = new LoginPage(driver);
		String userName = Lib.getCellValue(EXCEL_PATH, "ValidLogin", 1, 0);
		String passWord = Lib.getCellValue(EXCEL_PATH, "ValidLogin", 1, 1);

		loginPage.setUsername(userName);
		loginPage.setPassword(passWord);
		loginPage.clickLogin();
		
		String expectedTitle = Lib.getCellValue(EXCEL_PATH, "ValidLogin", 1, 2);
				
		String actualTitle = driver.getTitle();
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualTitle, expectedTitle);
		softAssert.assertAll();
	}
}