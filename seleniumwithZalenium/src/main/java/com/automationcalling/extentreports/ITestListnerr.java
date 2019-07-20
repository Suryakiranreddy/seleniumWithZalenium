package com.automationcalling.extentreports;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.automationcalling.seleniumcore.DriverFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class ITestListnerr extends DriverFactory implements ITestListener  {
	public void onStart(ITestContext context) {
	System.out.println("*** Test Suite " + context.getName() + " started ***");
}

public void onFinish(ITestContext context) {
	System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
	ExtentTestManager.endTest();
	ExtentManager.getInstance().flush();
}

public void onTestStart(ITestResult result) {
	System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
	ExtentTestManager.startParentTest(result.getMethod().getDescription());
	//ExtentTestManager.startTest(result.getMethod().getMethodName()+ " - " + result.getMethod().getDescription());
}

public void onTestSuccess(ITestResult result) {
	System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
	ExtentTestManager.getTest().log(Status.PASS, "Test passed");
}

public void onTestFailure(ITestResult result) {
	System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
	ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
	//log.info("*** Test execution " + result.getMethod().getMethodName() + " failed...");
	//log.info((result.getMethod().getMethodName() + " failed!"));
	 
	try {
		//String screenShot=ITestListnerr.destination(driver, result.getMethod().getMethodName() + " failed...");
		//ExtentTestManager.getTest().addScreencastFromPath(screenShot);
	 } catch (Exception e) {
		e.printStackTrace();
	}
		}

public void onTestSkipped(ITestResult result) {
	System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
	ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
}

public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
}
 public static String destination(WebDriver driver,String screenShotInfo) throws IOException
    {
	 
    String timeStamp=new SimpleDateFormat("dd MMMM yyyy HH-mm-ss").format(new Date());
    
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir")+"/screenShots/"+screenShotInfo+"-"+timeStamp+".png";
        File fianlDestination= new File(destination);
        FileHandler.copy(source,fianlDestination);
        return destination;
       // String source = ts.getScreenshotAs(OutputType.BASE64);
      // test.log(LogStatus.INFO, test.addBase64ScreenShot("data:image/png;base64,"+source)+screenShotInfo +" "+ timestamp() );
        
    }}
