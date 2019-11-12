package Page.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class AddressBookPage 
{
	@FindBy(xpath = "//div[@data-bind='html: message.text']")
	private @Getter WebElement successmsg;
	 
	//@FindBy(linkText =  "Change Billing Address")
	@FindBy(xpath = "//*[@id='maincontent']/div[2]/div[1]/div[4]/div[2]/div[1]/div[2]/a/span")
	private @Getter WebElement changeBillbtn;
	
	@FindBy(className = "action primary add")
	private @Getter WebElement AddnewAddressbtn;
	
	public AddressBookPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
