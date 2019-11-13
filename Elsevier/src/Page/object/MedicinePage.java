package Page.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class MedicinePage 
{
	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[4]/div[1]/div[3]/ol/li/div/div[2]/strong")
	private @Getter WebElement plasticSugeryBook;
	
	public MedicinePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
