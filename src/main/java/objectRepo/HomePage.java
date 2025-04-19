package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(linkText="Logins") private WebElement loginsLink;
	@FindBy(xpath="//h6[text()='Admin Login']/../a/button") private WebElement adminLoginLink;
	@FindBy(xpath="//h6[text()='Patient Login']/../a/button") private WebElement patientLoginLink;
	@FindBy(xpath="//h6[text()='Doctors login']/../a/button") private WebElement doctorLoginLink;
	
	public WebElement getLoginsLink() {
		return loginsLink;
	}

	public WebElement getPatientLoginLink() {
		return patientLoginLink;
	}

	public WebElement getDoctorLoginLink() {
		return doctorLoginLink;
	}

	public WebElement getAdminLoginLink() {
		return adminLoginLink;
	}

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
