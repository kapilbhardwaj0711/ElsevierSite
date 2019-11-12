package Page.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class GuestUserCheckOutPage
{
	@FindBy(id="customer-email")
	private @Getter WebElement Gemail;
	
	@FindBy(name = "firstname")
	private @Getter WebElement GFname;
	
	@FindBy(name="lastname")
	private @Getter WebElement GLname;
	
	@FindBy(name="street[0]")
	private @Getter WebElement GStreet;
	
	@FindBy(name="company")
	private @Getter WebElement GCompany;
	
	@FindBy(name="city")
	private @Getter WebElement GCity;
	
	@FindBy(name="region_id")
	private @Getter WebElement GState;
	
	@FindBy(name="postcode")
	private @Getter WebElement GZip;
	
	@FindBy(name="country_id")
	private @Getter WebElement GCountry;
	
	@FindBy(name="telephone")
	private @Getter WebElement GPhone;
	
	@FindBy(xpath = "//button[@class='button action continue primary']")
	private @Getter WebElement GNextBtn;
	
	public GuestUserCheckOutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
