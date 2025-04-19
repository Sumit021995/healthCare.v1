package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashBoardPage {
	
	@FindBy(xpath="//i[@class='ti-angle-down']") private WebElement adminDropdownIcon;
	@FindBy(xpath="//a[normalize-space(text())='Log Out']") private WebElement logoutLink;
	
	public AdminDashBoardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
}
