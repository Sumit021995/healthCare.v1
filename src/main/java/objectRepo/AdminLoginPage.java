package objectRepo;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
	@FindBy(name="username") private WebElement adminUNTextField;
	@FindBy(name="password") private WebElement adminPWDTextField;
	@FindBy(name="submit") private WebElement submitBtn;
	@FindBy(linkText="Bacto Home Page") private WebElement backToHomeLink;
	
	public WebElement getAdminUNTextField() {
		return adminUNTextField;
	}

	public WebElement getAdminPWDTextField() {
		return adminPWDTextField;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getBackToHomeLink() {
		return backToHomeLink;
	}

	public AdminLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void loginAsAdmin(String username,String password)
	{
		adminUNTextField.sendKeys(username,Keys.TAB,password,Keys.ENTER);
	}
	
}
