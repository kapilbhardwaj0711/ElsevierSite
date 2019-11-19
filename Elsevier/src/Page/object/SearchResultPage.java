package Page.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class SearchResultPage 
{
  @FindBy(xpath = "//div[@class='products wrapper grid products-grid']//a")
  private @Getter WebElement FirstProductOnSearch;
  
  
  public SearchResultPage(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
  }
}
