package com;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import com.automationcalling.extentreports.ITestListnerr;
import com.automationcalling.extentreports.RetryOnFailure;
import com.automationcalling.extentreports.XLSReader;





public class TestNgRunner {
	
	
	public static  void main(String args[]){
	
		
		XLSReader suite = new XLSReader("./AutomationControlSheet.xlsx");
		suite.getTests("select * from TestCase where Active='y'");
		
		TestNG test=new TestNG();
		TestListenerAdapter adapter = new TestListenerAdapter();
		RetryOnFailure t =new RetryOnFailure();
		ITestListnerr i =new ITestListnerr();
		List<String> suitefiles=new ArrayList<String>();
		suitefiles.add("./testng-suite.xml"); 
		test.setTestSuites(suitefiles);
		test.setAnnotationTransformer(t);
		test.addListener(i);
		//test.addListener(adapter);
		test.setParallel("parallel");
		//test.setSuiteThreadPoolSize(2);
		test.setThreadCount(2);
		test.run();
	}


}
