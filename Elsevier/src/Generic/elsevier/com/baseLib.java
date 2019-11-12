package Generic.elsevier.com;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class baseLib 
{
    public static WebDriver driver;
    @BeforeMethod
    @Parameters({"browser","baseurl"})
    
    public void precondition(String browserName,String url)
    {
    	driver=BrowserFactory.launch(browserName);
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    	driver.navigate().to(url);
    	Reporter.log(url+" url is navigated",true);
    }
 
/*    @AfterMethod
    public void postcondition()
    {
    	driver.close();
    	if (driver!=null) 
    	{
		  driver.quit();	
		}
    	Reporter.log("browser closed",true);
  }
  */
}
