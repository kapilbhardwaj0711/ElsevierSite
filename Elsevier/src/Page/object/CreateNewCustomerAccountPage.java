package Page.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;

public class CreateNewCustomerAccountPage 
{
  @FindBy(id="firstname")
  private @Getter WebElement fname;
  
  @FindBy(id="lastname")
  private @Getter WebElement lname;
  
  @FindBy(id="email_address")
  private @Getter WebElement email;
  
  @FindBy(id="password")
  private @Getter WebElement pwd;
  
  @FindBy(id="password-confirmation")
  private @Getter WebElement cpwd;
  
  @FindBy(xpath="//div[@class='field date field-dob']")
  private @Getter WebElement dobIcon;
  
  @FindBy(className="ui-datepicker-year")
  private @Getter WebElement dobYear;
  
  @FindBy(className="ui-datepicker-month")
  private @Getter WebElement dobMonth;
  
  @FindBy(xpath="//tr//td//a[text()='17']")
  private @Getter WebElement dobDate;
  
  @FindBy(id="phonenumber")
  private @Getter WebElement telephone;
  
  @FindBy(id="profession")
  private @Getter WebElement ProfsDrpDwn;
  
  @FindBy (id="specialty")
  private @Getter WebElement ProfsSubDrpDwn;
  
  @FindBy(xpath="//div[@class='field choice terms']/input[@type='checkbox']")
  private @Getter WebElement chckbx;
  
  @FindBy(xpath="//button[@title='Register Now']")
  private @Getter WebElement registrBtn;
  
  public CreateNewCustomerAccountPage(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
  }

}
