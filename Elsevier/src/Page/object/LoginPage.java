package Page.object;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class LoginPage 
{
		@FindBy(className="user_icon")
		private @Getter WebElement usrico;
		@FindBy(linkText="Sign In")
		private @Getter WebElement signInbtn;
		@FindBy(id="email")
	    private @Getter WebElement untxtb;
	    @FindBy(id="pass")
	    private @Getter WebElement pwdtxtbx;
	    @FindBy(id="send2")
	    private @Getter WebElement loginbtn;
	    @FindBy(linkText="Create an Account")
	    private @Getter WebElement CreateAc;
	    
	    @FindBy(xpath = "//a/span[text()='Forgot Your Password?'][1]")
	    private @Getter WebElement ForgetPassbtn;
	   
	   public LoginPage(WebDriver driver)
	   {
		   PageFactory.initElements(driver, this);
	   }
	   
	
}
	   
	   
	   

