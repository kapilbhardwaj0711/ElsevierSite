package Page.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class HomePage 
{
  @FindBy(linkText = "Medicine")
  private @Getter WebElement medicineBtn;
  
  @FindBy(linkText = "Infectious Disease")
  private @Getter WebElement infectionDiseaseBtn;
  
  public HomePage(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
  }
}
