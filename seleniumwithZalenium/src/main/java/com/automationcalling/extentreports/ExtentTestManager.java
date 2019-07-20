package com.automationcalling.extentreports;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;



public class ExtentTestManager {
	
	
	
	
	static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
	static ExtentReports extent = ExtentManager.getInstance();
	static ExtentTest patentTest;
	static ExtentTest childTest;

	public static synchronized ExtentTest getTest() {
		return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
	}

	public static synchronized void endTest() {
		extent.flush();
	}

	public static synchronized ExtentTest startParentTest(String testName) {
		 patentTest = extent.createTest(testName);
		extentTestMap.put((int) (long) (Thread.currentThread().getId()), patentTest);
		return patentTest;
	}
	public static synchronized ExtentTest startChildTest(String nodeName) {
		childTest=patentTest.createNode(nodeName);
		extentTestMap.put((int) (long) (Thread.currentThread().getId()), childTest);
		return childTest;
	}
	
	public static synchronized ExtentTest startNode(String nodeName) {

		 return extentTestMap.put((int) (long) (Thread.currentThread().getId()), ExtentTestManager.getTest().createNode(nodeName));
	
	}


}
