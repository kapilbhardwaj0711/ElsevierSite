package Script;

import org.testng.annotations.Test;

import Generic.elsevier.com.baseLib;
import InternalData.Data;
import feature.taskfeature;

public class CheckFilter extends baseLib implements Data 
{
	@Test
	public void FilterCheck() throws InterruptedException
	{
		taskfeature tf = new taskfeature(driver);
		tf.checkFilter();
	}
}
