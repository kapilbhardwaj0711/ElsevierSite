package Page.object;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;

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
	
	@FindBy(xpath = "//dt[text()='Price']")
	private @Getter WebElement priceFilterBtn;
	
	@FindBy(xpath = "//*[@id=\"narrow-by-list\"]/dd[2]/ol/li[2]/a")
	private @Getter WebElement priceFilterValue;
	
	@FindBy(xpath = "//a[@class='logo']")
	private @Getter WebElement logo;
	
	@FindBy(xpath = "//span[@class='counter-number']")
	private @Getter WebElement Cartvalue;
	
	@FindBy(xpath = "//span[text()='10']")
	private @Getter WebElement Cartvalue10;
	
	@FindBy(xpath = "//span[text()='5']")
	private @Getter WebElement Cartvalue5;
	
	@FindBy(xpath = "//div//span[text()='Clear Shopping Cart']")
	private @Getter WebElement clearcartBtn;
	
	@FindBy(xpath = "//div/p[text()='You have no items in your shopping cart.']")
	private @Getter WebElement empyCartSuccessmsg;
	
	@FindBy(xpath = "//div[@itemprop='sku']")
	private @Getter WebElement productIsbn;
	
	@FindBy(xpath = "//div[@class='page-title-wrapper']//span[@class='base']")
	private @Getter WebElement productTitle;	
	public BasePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
}
