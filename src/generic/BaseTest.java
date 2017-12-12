package generic;

import java.io.File;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConstant{
	public static WebDriver driver;

	static{
		System.setProperty(GECKO_KEY, GECKO_VALUE);
		System.setProperty(CHROME_KEY, CHROME_VALUE);
	}

	@BeforeMethod
	public void openApplication(){

//		driver = new FirefoxDriver();
		driver = new ChromeDriver();
		String url = Lib.getProperty(CONFIG_PATH, "URL");
		driver.get(url);

		String implicitTimeOut = Lib.getProperty(CONFIG_PATH, "ImplicitTimeOut");
		int timeOutPeriod = Integer.parseInt(implicitTimeOut);

		driver.manage().timeouts().implicitlyWait(timeOutPeriod, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void closeApplication(){
		driver.close();
	}
	
	public void takeScreenshot(String testName){
		Date date = new Date();
		String currentDate = date.toString().replaceAll(":", "_");
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(".\\screenshots\\"+currentDate+"\\"+testName+"_screenshot.png");
		try {
			FileUtils.copyFile(sourceFile, destinationFile);
		} catch (Exception e) {
			
		}
	}
}