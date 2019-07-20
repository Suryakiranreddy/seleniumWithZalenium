package com.automationcalling.extentreports;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;;



public class RetryOnFailure implements IAnnotationTransformer {

	public void transform(ITestAnnotation testannotation, Class testClass, Constructor testConstructor, Method testMethod) {
		//IRetryAnalyzer retry = testannotation.getRetryAnalyzer();

		
		testannotation.setRetryAnalyzer(RetryListenerr.class);
		/*if (retry == null)	{
			testannotation.setRetryAnalyzer(RetryListenerr.class);
		}*/
		
	}

}
