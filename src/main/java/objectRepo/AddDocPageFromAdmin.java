package objectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddDocPageFromAdmin {
	@FindBy(name="docname") private WebElement doctorUNTextField;
	@FindBy(name="Doctorspecialization") private WebElement doctorSpecializationDD;
	@FindBy(xpath="//textarea") private WebElement doctorClinicAddressTextArea;
	@FindBy(name="docfees']") private WebElement doctorFeeTextField;
	@FindBy(name="doccontact']") private WebElement doctorContactTextField;
	@FindBy(id="docemail") private WebElement doctorEmailTextField;
	@FindBy(name="npass") private WebElement doctorPasswordTextField;
	@FindBy(name="cfpass") private WebElement doctorConfirmPasswordTextField;
	@FindBy(id="submit") private WebElement submitBtn;
	
	public AddDocPageFromAdmin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getDoctorUNTextField() {
		return doctorUNTextField;
	}
	public WebElement getDoctorSpecializationDD() {
		return doctorSpecializationDD;
	}
	public WebElement getDoctorClinicAddressTextArea() {
		return doctorClinicAddressTextArea;
	}
	public WebElement getDoctorFeeTextField() {
		return doctorFeeTextField;
	}
	public WebElement getDoctorContactTextField() {
		return doctorContactTextField;
	}
	public WebElement getDoctorEmailTextField() {
		return doctorEmailTextField;
	}
	public WebElement getDoctorPasswordTextField() {
		return doctorPasswordTextField;
	}
	public WebElement getDoctorConfirmPasswordTextField() {
		return doctorConfirmPasswordTextField;
	}
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public void createDocFromAdmin()
	{
		
	}
}
