package Page.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class ForgetPasswordPage 
{
	@FindBy(id = "email_address")
	private @Getter WebElement Emailid;
	
	@FindBy(xpath = "//button/span[text()='Submit']")
	private @Getter WebElement submit;
	
	
   public ForgetPasswordPage(WebDriver driver)
   {
	   PageFactory.initElements(driver, this);
   }
   
}
