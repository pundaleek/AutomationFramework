package scripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;

public class TestInvalidLogin extends BaseTest{
	@Test
	public void testInvalidLogin(){
		LoginPage loginPage = new LoginPage(driver);
		
		int rowCount = Lib.getRowCount(EXCEL_PATH, "InValidLogin");
				
		for (int i = 1; i <= rowCount; i++) {
			String userName = Lib.getCellValue(EXCEL_PATH, "InValidLogin", i, 0);
			String passWord = Lib.getCellValue(EXCEL_PATH, "InValidLogin", i, 1);
			
			loginPage.setUsername(userName);
			loginPage.setPassword(passWord);
			loginPage.clickLogin();
		}
	}
}