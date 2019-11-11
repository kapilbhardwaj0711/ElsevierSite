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
	 
	@FindBy(xpath = "//div[@class='box box-address-billing']//span[text()='Change Billing Address']")
	private @Getter WebElement changeBillAddbt;
	
	@FindBy(className = "action primary add")
	private @Getter WebElement AddnewAddressbtn;
	
	public AddressBookPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
