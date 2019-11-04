package Generic.elsevier.com;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.google.common.io.Files;

public class MyTestNGListner implements ITestListener
{  
	public static int executionCount,passCount,failCount,skipCount=0;
	public static int startMinute,endminute=0;

	@Override
	public void onTestStart(ITestResult result) 
	{
		executionCount++;
		Reporter.log(result.getName()+" script execustion starts"+ new Date(),true);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		passCount++;
		Reporter.log(result.getName()+" script is passed",true);
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		failCount++;
		Reporter.log(result.getName()+" script is failed",true);
	 TakesScreenshot ts =  (TakesScreenshot) baseLib.driver;
	 File srcfile=ts.getScreenshotAs(OutputType.FILE);
	 File desfile = new File("./Screenshot/"+result.getName()+".png");
	 try 
	 {
		Files.copy(srcfile, desfile);
	 }
	 catch (IOException e) 
	 {
		
		e.printStackTrace();
	 }	
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{

		skipCount++;
		Reporter.log(result.getName()+" script is skipped",true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{

		
	}

	@Override
	public void onStart(ITestContext context) 
	{
        Reporter.log("suite is executed "+ new Date(),true);
        startMinute=LocalTime.now().getMinute();
		
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		Reporter.log("suite execution end :"+ new Date(),true);
        endminute=LocalTime.now().getMinute();
        int totalminute= startMinute-endminute;
        Reporter.log("total suite execution time "+totalminute+"mins",true);
        
        Reporter.log("total scrpt executed "+executionCount,true);
        Reporter.log("total script passed "+passCount,true);
        Reporter.log("total scrpt failed "+failCount,true);
        Reporter.log("total scrpt skipped "+skipCount,true);
	}
   
}
