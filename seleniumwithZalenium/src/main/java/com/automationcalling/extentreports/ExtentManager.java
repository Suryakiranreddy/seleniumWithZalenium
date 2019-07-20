package com.automationcalling.extentreports;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {
	private static ExtentReports extent;
	private static String reportFileName = "./Reports/Automaton Report - ";

	public static ExtentReports getInstance() {
		if (extent == null)
			createInstance();
		return extent;
	}

	// Create an extent report instance
	public static ExtentReports createInstance() {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportFileName + timeStamp + ".html");

		//htmlReporter.loadXMLConfig("./src/main/resources/extent-config.xml");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		return extent;
	}

}
