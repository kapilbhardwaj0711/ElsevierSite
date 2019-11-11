package Page.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class EditAddressPage 
{
   @FindBy(id="street_1")
   private @Getter WebElement street1;
   
   @FindBy(id="city")
   private @Getter WebElement city;
   
   @FindBy(id="region_id")
   private @Getter WebElement stateDrpDwn;
   
   @FindBy(id="zip")
   private @Getter WebElement zipcode;
   
   @FindBy(id="country")
   private @Getter WebElement country;
   
   @FindBy(xpath = "//button[@class='action submit primary']")
   private @Getter WebElement submit;
   
   public EditAddressPage(WebDriver driver)
   {
	 PageFactory.initElements(driver, this);  
   }
   
}
