package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.hrm.generic.BaseClass_Test.BaseClass_Test;

public class AdminDashBoardPage extends BaseClass_Test{
	
	@FindBy(xpath="//i[@class='ti-angle-down']") private WebElement adminDropdownIcon;
	@FindBy(xpath="//a[contains(text(),'Log Out')]") private WebElement logoutLink;
	@FindBy(xpath="//span[text()=' Doctors ']") private WebElement doctorLink;
	@FindBy(xpath="//span[text()=' Add Doctor']") private WebElement addDoctorLink;
	
	
	public AdminDashBoardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void logoutFromAdminPage(WebDriver driver)
	{
		wUtil.mouseClickAction(driver, adminDropdownIcon);
		wUtil.waitForElementToBeVisible(driver, 15, logoutLink);
		logoutLink.click();
	}
	public void clickOnAddDoc()
	{
		doctorLink.click();
		addDoctorLink.click();
	}

	public WebElement getAdminDropdownIcon() {
		return adminDropdownIcon;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}
	
}
