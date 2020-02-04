package Script;

import org.testng.annotations.Test;

import Generic.elsevier.com.baseLib;
import InternalData.Data;
import feature.taskfeature;

public class CreateUser extends baseLib implements Data
{
/*	@Test
	public void CreateUser() throws InterruptedException
	{
		taskfeature tf = new taskfeature(driver);
		tf.CreateCust(firstname, lastname, emailaddess, passwrd, cpasswrd, dateNbirth,telephone);
	}
*/	
	@Test(priority=2)
	public void ForgetPassword() throws InterruptedException
	{
		taskfeature tf = new taskfeature(driver);
		tf.Forgetpassword();
	}
	
}
