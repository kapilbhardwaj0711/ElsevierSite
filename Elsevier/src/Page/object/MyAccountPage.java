package Page.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class MyAccountPage 
{
  @FindBy(linkText = "Manage Addresses")
  private @Getter WebElement mangeAcBtn;
  

  
  public MyAccountPage(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
	  
  }
}
