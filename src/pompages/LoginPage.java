package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	// Declaration
	@FindBy(id="login-username")
	private WebElement usernameTextBox;

	@FindBy(id="login-password")
	private WebElement passwordTextBox;

	@FindBy(id="btn-login")
	private WebElement loginButton;

	//initialization
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	//Utilization

	public void setUsername(String username){
		usernameTextBox.sendKeys(username);
	}

	public void setPassword(String password){
		passwordTextBox.sendKeys(password);
	}

	public void clickLogin(){
		loginButton.click();
	}
}