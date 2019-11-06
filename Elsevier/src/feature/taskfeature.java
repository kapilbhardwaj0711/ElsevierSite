package feature;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import Page.object.BasePage;
import Page.object.CreateNewCustomerAccountPage;
import Page.object.LoginPage;


public class taskfeature 
{
   WebDriver driver;
   LoginPage lp;
   CreateNewCustomerAccountPage cca;
   BasePage bp;
   
   public taskfeature(WebDriver driver)
   {
	   this.driver=driver;
	   lp= new LoginPage(driver);
	   cca= new CreateNewCustomerAccountPage(driver);
	   bp= new BasePage(driver);
   }
   
   public void ValidLogin(String username , String password) throws Exception
   {
	   
	   lp.getUsricon().click();
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
	   lp.getUsricon().click();
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
	  lp.getUsricon().click();
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

 	  cca.getRegistrBtn().click();
 	  Thread.sleep(5000);
 	  String expected ="Thank you for registering with Elsevier Asia Bookstore.";
 	  Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Thank you for registering with Elsevier Asia Bookstore.']")).getText(), expected);
	  
   }
   public void ExistingUserproductPurchase(String username,String password,String product) throws Exception
   {
	   ValidLogin(username, password);
	   System.out.println(product);
	   bp.getSearchBar().sendKeys(product,Keys.ENTER);
	   Thread.sleep(2000);
	   List<WebElement> links = driver.findElements(By.xpath("//a"));
	   
	   Iterator<WebElement> itr = links.iterator();
	   while(itr.hasNext())
	   {
		   WebElement txt = itr.next();
		   if (product.equalsIgnoreCase(txt.getText())) 
		   {
			   txt.click();
			   break;
			   
		   }
	   }
	   
	   bp.getAddToCartbtn().click();
	   bp.getMycartIcon().click();
	   bp.getViewCartBtn().click();
	   bp.getProceedTochckBtn().click();

	 }
}
   


