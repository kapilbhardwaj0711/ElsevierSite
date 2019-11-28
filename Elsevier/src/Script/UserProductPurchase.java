package Script;

import org.testng.annotations.Test;

import Generic.elsevier.com.baseLib;
import InternalData.Data;
import feature.taskfeature;

public class UserProductPurchase extends baseLib implements Data
{
	@Test(priority = 1)
	public void validUserProductPurchase() throws Exception
	{
		taskfeature tf = new taskfeature(driver);
		tf.ExistingUserproductPurchase(username, password, product);
		
	}
	@Test(priority = 2)
	public void GuestUserProductPurchase() throws Exception
	{
		taskfeature tf = new taskfeature(driver);
		tf.GuestUserProductPurchase(username, password, isbn, Guestemail, firstname, lastname, street, company, city, state, zip, country, telephone);
	}
	@Test(priority = 3)
	public void EBookPurchaseUser() throws Exception
	{
		taskfeature tf = new taskfeature(driver);
		tf.EbookPurchaseVAlidUser(username, password, product);
	}
	@Test(priority=4)
	public void AddtoCart() throws Exception
	{
		taskfeature tf = new taskfeature(driver);
		
	}
	@Test(priority = 5)
	public void addDiscount()
	{
		
	}
}
