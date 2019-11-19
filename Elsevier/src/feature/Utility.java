package feature;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Page.object.BasePage;

public class Utility 
{
	WebDriver driver;
	BasePage bp;
    public Utility(WebDriver driver)
    {
    	this.driver=driver;
    	bp = new BasePage(driver);
    }
    public void serachFuc(String product)
    {
    	bp.getSearchBar().sendKeys(product,Keys.ENTER);
    	List<WebElement> links = driver.findElements(By.xpath("//a"));
    	Iterator<WebElement> itr = links.iterator();
    	
    	while (itr.hasNext()) 
    	{
    		WebElement value = itr.next();
    		if (value.getText().contains(product)) 
			{
				value.click();
				break;
			}
			
		}
    	
    }
    public void clearCart()
    {
       bp.getClearcartBtn().click();
  	   Assert.assertEquals(bp.getEmpyCartSuccessmsg().getText(), "You have no items in your shopping cart.");
    }
    
    
}
