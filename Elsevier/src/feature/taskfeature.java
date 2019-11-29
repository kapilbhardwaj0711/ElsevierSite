package feature;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import Page.object.AddNewAddressPage;
import Page.object.AddressBookPage;
import Page.object.BasePage;
import Page.object.CreateNewCustomerAccountPage;
import Page.object.EditAddressPage;
import Page.object.GuestUserCheckOutPage;
import Page.object.HomePage;
import Page.object.LoginPage;
import Page.object.MedicinePage;
import Page.object.MyAccountPage;
import Page.object.SearchResultPage;
import okhttp3.Address;


public class taskfeature 
{
   WebDriver driver;
   LoginPage lp;
   CreateNewCustomerAccountPage cca;
   BasePage bp;
   MyAccountPage mac;
   EditAddressPage eap;
   AddressBookPage abp;
   AddNewAddressPage anap;
   GuestUserCheckOutPage gucp;
   HomePage hp;
   MedicinePage mp;
   Utility tm;
   SearchResultPage srp;
   public taskfeature(WebDriver driver)
   {
	   this.driver=driver;
	   lp= new LoginPage(driver);
	   cca= new CreateNewCustomerAccountPage(driver);
	   bp= new BasePage(driver);
	   mac= new MyAccountPage(driver);
	   eap= new EditAddressPage(driver);
	   anap = new AddNewAddressPage(driver);
	   gucp= new GuestUserCheckOutPage(driver);
	   hp= new HomePage(driver);
	   mp= new MedicinePage(driver);
	   tm = new Utility(driver);
	   srp=new SearchResultPage(driver);
   }
   
   public void ValidLogin(String username , String password) throws Exception
   {
	   
	   lp.getUsrico().click();
	   lp.getSignInbtn().click();
	   Thread.sleep(2000);
	   lp.getUntxtb().sendKeys(username);
	   lp.getPwdtxtbx().sendKeys(password);
	   lp.getLoginbtn().click();
	  Thread.sleep(2000);
	  String expected="My Account";
	  Assert.assertEquals(driver.getTitle(), expected);
	  Reporter.log(expected,true);
	  
   }
   public void invalidLogin(String username1,String password1) throws Exception
   {
	   lp.getUsrico().click();
	   lp.getSignInbtn().click();
	   Thread.sleep(2000);
	   lp.getUntxtb().sendKeys(username1);
	   lp.getPwdtxtbx().sendKeys(password1);
	   lp.getLoginbtn().click();
	   Thread.sleep(2000);
	   String errorMsgxpth="//div[text()='The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.']";
	   String expected="The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
	   Assert.assertEquals(driver.findElement(By.xpath(errorMsgxpth)).getText(), expected);
   }
   public void CreateCust(String firstname ,String lastname,String emailaddess,String passwrd,String cpasswrd,String dateNbirth,String telephone) throws InterruptedException
   {
	  lp.getUsrico().click();
	  lp.getCreateAc().click();
	  Thread.sleep(1000);
 	  
	  cca.getFname().sendKeys(firstname);
 	  cca.getLname().sendKeys(lastname);
 	  cca.getEmail().sendKeys(emailaddess);
 	  cca.getPwd().sendKeys(passwrd);
 	  cca.getCpwd().sendKeys(cpasswrd);
 	  
 	  cca.getDobIcon().click();
 	  Select sel0 = new Select(cca.getDobYear());
	  sel0.selectByValue("1990");
	  
	  Select sel01 = new Select(cca.getDobMonth());
	  sel01.selectByValue("11");
	  Thread.sleep(1000);
	  
	  cca.getDobDate().click();
	  cca.getTelephone().sendKeys(telephone);
 	  
 	  Select sel = new Select(cca.getProfsDrpDwn());
 	  sel.selectByIndex(3);
 	  
 	  Thread.sleep(1000);
 	  Select sel1 = new Select(cca.getProfsSubDrpDwn());
 	  sel1.selectByIndex(2);
 	  cca.getChckbx().click();

 /*	  cca.getRegistrBtn().click();
 	  Thread.sleep(5000);
 	  String expected ="Thank you for registering with Elsevier Asia Bookstore.";
 	  Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Thank you for registering with Elsevier Asia Bookstore.']")).getText(), expected);
*/	  
   }
   public void ExistingUserproductPurchase(String username,String password,String product) throws Exception
   {
	   ValidLogin(username, password);
	   tm.searchFuc(product);
	   srp.getFirstProductOnSearch().click();
	   Assert.assertEquals(bp.getProductTitle().getText(), product);
	   bp.getAddToCartbtn().click();
	   bp.getMycartIcon().click();
	   bp.getViewCartBtn().click();
	   
}
   public void EbookPurchaseVAlidUser(String username ,String password,String product) throws Exception 
   {
	   ValidLogin(username, password);
	   
	   	String val = bp.getCartvalue().getText();
//	    int value = Integer.parseInt(val);
	   	if (val.equalsIgnoreCase("")) 
	   {   
	   		System.out.println("Cart is empty");
	   }
	   	else 
	   	{
	   		System.out.println("i am in else ");
			   bp.getMycartIcon().click();
			   bp.getViewCartBtn().click();
			   Thread.sleep(3000);
			   tm.clearCart();
		}
	   
	   tm.searchFuc(product);
	   List<WebElement> numberofbooks = driver.findElements(By.xpath("//span[text()='Add to Cart']"));
		  
	   for (int i = 0; i < 5; i++) 
	   {
		   WebElement book = numberofbooks.get(i);
		   book.click();
	   }
	   Thread.sleep(10000);
	   JavascriptExecutor jre = (JavascriptExecutor)driver;
	   jre.executeScript("window.scrollBy(0,-300)");
	   WebDriverWait wait = new WebDriverWait(driver, 30);
	   wait.until(ExpectedConditions.visibilityOf(bp.getCartvalue5()));
	   
	   bp.getLogo().click();
	   hp.getEbooksbtn().click();
	   
	   List<WebElement> Ebooks = driver.findElements(By.xpath("//span[text()='Add to Cart']"));
		for (int i = 0; i < 5; i++) 
	   {
		   WebElement Ebook1 = Ebooks.get(i);
		   Ebook1.click();
		   
		}
	   jre.executeScript("window.scrollBy(0,-300)");
	   wait.until(ExpectedConditions.visibilityOf(bp.getCartvalue10()));
	   
	   bp.getMycartIcon().click();
	   bp.getViewCartBtn().click();
	   Thread.sleep(2000);
	  
//	   bp.getProceedTochckBtn().click();
//	   String title = "Checkout";
//	   Assert.assertEquals(driver.getTitle(),title);
	   
   }
   
   public void GuestUserProductPurchase(String username,String password,String product,
		   String Guestemail,String firstname,String lastname,String street,String company,String city,
		   	String state,String zip,String country,String telephone)throws Exception
   {
	   tm.searchFuc(product);
  /*   bp.getSearchBar().sendKeys(product,Keys.ENTER);
	   Thread.sleep(2000);
	   List<WebElement> links = driver.findElements(By.xpath("//a"));
	   
	   Iterator<WebElement> itr = links.iterator();
	   while(itr.hasNext())
	   {
		   WebElement txt = itr.next();
		   String value ="Robbins & Cotran Pathologic ...";
		   System.out.println("string value:- "+txt.getText());
		   if (txt.getText().contains(value)) 
		   {
			   txt.click();
			   break;
		   }
		}
	*/	
	   srp.getFirstProductOnSearch().click();
	   Assert.assertEquals(bp.getProductIsbn().getText(), product);
	   bp.getAddToCartbtn().click();
	   bp.getMycartIcon().click();
	   bp.getViewCartBtn().click();
	   Thread.sleep(2000);
//	   bp.getProceedTochckBtn().click();
	   Thread.sleep(2000);
/*	   gucp.getGemail().sendKeys(Guestemail);
	   Thread.sleep(1000);
	   gucp.getGFname().sendKeys(firstname);
	   gucp.getGLname().sendKeys(lastname);
	   gucp.getGStreet().sendKeys(street);
	   gucp.getGCompany().sendKeys(company);
	   gucp.getGCity().sendKeys(city);
	   gucp.getGZip().sendKeys(zip);
	   gucp.getGPhone().sendKeys(telephone);
	   
	   Thread.sleep(1000);
	   Select sel = new Select(gucp.getGCountry());
	   sel.selectByVisibleText(country);
			   
	   Thread.sleep(2000);
	   Select sel1 = new Select(gucp.getGState());
	   sel1.selectByVisibleText(state);
	   
	   Thread.sleep(1000);	  
	   gucp.getGNextBtn().click();
	   
	   String expected="Checkout";
	   Assert.assertEquals(driver.getTitle(), expected);
*/	   
   }
   
public void EditBillingAddress(String username, String password,String street,String city,String state,String zip,String country) throws Exception
   
{
	 ValidLogin(username, password); 
	 mac.getMangeAcBtn().click();
	 Thread.sleep(1000);
//	 abp.getChangeBillbtn().click();
	 driver.findElement(By.linkText("Change Billing Address")).click();
//	 driver.findElement(By.xpath("//a[@class='action edit']/span[text()='Change Billing Address']")).click();
//	 System.out.println(abp.getChnageBillbtn().getText());
	 
	 Thread.sleep(2000);
	 eap.getStreet1().sendKeys(Keys.CONTROL,"a");
	 eap.getStreet1().sendKeys(Keys.DELETE);
	 eap.getStreet1().sendKeys(street);
	 
	 eap.getCity().sendKeys(Keys.CONTROL,"a");
	 eap.getCity().sendKeys(Keys.DELETE);
	 eap.getCity().sendKeys(city);
	 
	 eap.getZipcode().sendKeys(Keys.CONTROL,"a");
	 eap.getZipcode().sendKeys(Keys.DELETE);
	 eap.getZipcode().sendKeys(zip);
	 
	 Thread.sleep(1000);
	 Select sel = new Select(eap.getCountry());
	 sel.selectByVisibleText(country);
	 

	 Select sel1= new Select(eap.getStateDrpDwn());
	 sel1.selectByVisibleText(state);
	 eap.getSubmit().click();
	 
	 Thread.sleep(3000);
	 Assert.assertEquals("You saved the address.", driver.findElement(By.xpath("//div[@data-bind='html: message.text']")).getText());
   
   }
   
   public void addnewAdress(String username, String password,String company,String telephone,String street,String city,String zip,String country,String state) throws Exception
   {
	   ValidLogin(username, password);
	   mac.getMangeAcBtn().click();
	   
	   Thread.sleep(3000);
	   String txt = driver.findElement(By.xpath("//div[@class='primary']/button/span[text()='Add New Address'][1]")).getText();
	   if ("Add New Address".equalsIgnoreCase(txt)) 
	   {
		   driver.findElement(By.xpath("//div[@class='primary']/button/span[text()='Add New Address'][1]")).click();
	   }
	   
/*	   try 
	   {
		   driver.findElement(By.xpath("//div[@class='primary']/button/span[text()='Add New Address'][1]"));
		
	   } 
	   catch (Exception e) 
	   {
		 //  abp.getAddnewAddressbtn().click();
		   driver.findElement(By.xpath("//div[@class='primary']/button/span[text()='Add New Address'][1]")).click();
	   }
*/
	   Thread.sleep(2000);
	   anap.getCompanyName().sendKeys(company);
	   anap.getTelephone().sendKeys(telephone);
	   eap.getStreet1().sendKeys(street);
	   eap.getCity().sendKeys(city);
	   eap.getZipcode().sendKeys(zip);
	   Thread.sleep(1000);
	   
	   Select sel = new Select(eap.getCountry());
	   sel.selectByVisibleText(country);
	   
	   Thread.sleep(1000);
	   Select sel1= new Select(eap.getStateDrpDwn());
	   sel1.selectByVisibleText(state);
	   eap.getSubmit().click();
	   Thread.sleep(3000);
	   Assert.assertEquals("You saved the address.", driver.findElement(By.xpath("//div[@data-bind='html: message.text']")).getText());
   }
   
   public void checkFilter() throws InterruptedException
   {
	   hp.getMedicineBtn().click();
	   
	   JavascriptExecutor jre = (JavascriptExecutor)driver;
	   jre.executeScript("window.scrollBy(0,1000)");
	   
	   bp.getPriceFilterBtn().click();
	   Thread.sleep(2000);
	   bp.getPriceFilterValue().click();
	   Thread.sleep(5000);
	   mp.getPlasticSugeryBook().click();
	   Thread.sleep(1000);
	   bp.getAddToCartbtn().click();
	   Thread.sleep(5000);
	   bp.getMycartIcon().click();
	   Thread.sleep(3000);
	   bp.getViewCartBtn().click();
	   Assert.assertEquals(driver.getTitle(), "Shopping Cart");
	   
	}
   public void DiscountCoupon(String username,String password,String product) throws Exception
   {
	   System.out.println(product);
	   ValidLogin(username, password);
//	   String val1=driver.findElement(By.xpath("//span[@class='counter qty empty']/span[@class='counter-number']")).getText();
	    
//	   System.out.println("cart value is :-"+val1);
	   String val = bp.getCartvalue().getText();
	   System.out.println("cart value "+val);
	  
//	   int value = Integer.parseInt(val);
	   if (val.equalsIgnoreCase("")) 
	   {
		   
		   System.out.println("Cart is empty ");
	   }
	   else 
	   {
		   System.out.println(" i am in else condition");
		   bp.getMycartIcon().click();
		   bp.getViewCartBtn().click();
		   Thread.sleep(3000);
		   tm.clearCart();
		}
	   Thread.sleep(3000);
	   tm.searchFuc(product);
	   Thread.sleep(3000);
	   
	   driver.findElement(By.xpath("//span[text()='Add to Cart']")).click();
	   bp.getMycartIcon().click();
	   bp.getViewCartBtn().click();
	   
	   System.out.println("Step 10");
	  
      String oldprice = driver.findElement(By.id("old-price")).getText();
     
      String basefare = oldprice.substring(1);
      double basefare1 = Double.parseDouble(basefare);
      System.out.println(basefare1);
      
      
      String value = driver.findElement(By.xpath("//div[@class='field qty']//input")).getAttribute("value");
	  System.out.println(value);
	  double qty = Double.parseDouble(value);
	  double finlprice = qty*basefare1;
	  
	  double val2 = finlprice/4;
      System.out.println("dicounted price "+val2);
	   
   }
   
}
   


