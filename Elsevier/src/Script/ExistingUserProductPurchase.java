package Script;

import org.testng.annotations.Test;

import Generic.elsevier.com.baseLib;
import InternalData.Data;
import feature.taskfeature;

public class ExistingUserProductPurchase extends baseLib implements Data
{
	@Test
	public void purchaseProduct() throws Exception
	{
		taskfeature tf = new taskfeature(driver);
		tf.ExistingUserproductPurchase(username, password, product);
		
	}
}
