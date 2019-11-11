package Page.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class AddNewAddressPage 
{
	@FindBy(id="company")
	private @Getter WebElement companyName;
	
	@FindBy(id="telephone")
	private @Getter WebElement telephone;
	
	public AddNewAddressPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
}
