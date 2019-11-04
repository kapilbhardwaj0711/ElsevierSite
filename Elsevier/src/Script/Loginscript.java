package Script;

import org.testng.annotations.Test;

import Generic.elsevier.com.baseLib;
import InternalData.Data;
import feature.taskfeature;

public class Loginscript extends baseLib implements Data
{
	@Test(priority=1)
	public void validLogin() throws Exception
	{
		taskfeature tf = new taskfeature(driver);
		tf.ValidLogin(username, password);
	}
	@Test(priority=2)
	public void invalidLogin() throws Exception
	{

		taskfeature tf= new taskfeature(driver);
		tf.invalidLogin(username1, password1);
	
	}
}
