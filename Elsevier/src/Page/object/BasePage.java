package Page.object;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class BasePage
{
	@FindBy(id="search")
	private @Getter WebElement searchBar;
	
	@FindBy(id="product-addtocart-button")
	private @Getter WebElement addToCartbtn;
	
	@FindBy(xpath = "//div[@class='minicart-wrapper']/a[@class='action showcart']")
	private @Getter WebElement MycartIcon;
	
	@FindBy(xpath ="//a/span[text()='View Cart']")
	private @Getter WebElement ViewCartBtn;
	
	@FindBy(xpath = "//button/span[text()='Proceed to Checkout']")
	private @Getter WebElement proceedTochckBtn;
	
	public BasePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
