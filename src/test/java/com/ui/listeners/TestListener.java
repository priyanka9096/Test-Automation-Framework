package com.ui.listeners;

import java.io.IOException;
import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.tests.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReporterUtility;
import com.utility.LoggerUtility;

public class TestListener implements ITestListener {
	Logger logger=LoggerUtility.getLogger(this.getClass());
	
	ExtentSparkReporter extentSparkReporter;
	ExtentReports extentReports;
	ExtentTest extentTest;

	
	public void onTestStart(ITestResult result) {
		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups()));

		ExtentReporterUtility.createExtentTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " " + "PASSED");
		ExtentReporterUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + " " + "PASSED");
	}
	
	
	public void onTestFailure(ITestResult result) {
	    // Log the failure with detailed information
	    logger.error(result.getMethod().getMethodName() + " FAILED");
	    logger.error(result.getThrowable().getMessage());
	    
	    // Log in Extent Reports
	    ExtentReporterUtility.getTest().log(Status.FAIL, 
	        result.getMethod().getMethodName() + " FAILED");
	    ExtentReporterUtility.getTest().log(Status.FAIL, 
	        result.getThrowable().getMessage());
	    
	    try {
	        // Get test class instance
	        Object testClass = result.getInstance();
	        if (testClass instanceof TestBase) {
	            BrowserUtility browserUtility = ((TestBase) testClass).getInstance();
	            
	            // Take screenshot
	            logger.info("Capturing screenshot for failed test: " + 
	                result.getMethod().getMethodName());
	            String screenshotPath = browserUtility.takeScreenShot(
	                result.getMethod().getMethodName());
	            
	            if (screenshotPath != null) {
	                logger.info("Screenshot captured successfully");
	                try {
	                    // Attach screenshot to report
	                    logger.info("Attaching screenshot to HTML report");
	                    ExtentReporterUtility.getTest().addScreenCaptureFromPath(
	                        screenshotPath);
	                    logger.info("Screenshot attached successfully");
	                } catch (IOException e) {
	                    logger.error("Error attaching screenshot to report: " + 
	                        e.getMessage());
	                }
	            } else {
	                logger.error("Failed to capture screenshot");
	            }
	        } else {
	            logger.error("Test class does not implement TestBase");
	        }
	    } catch (Exception e) {
	        logger.error("Error handling test failure: " + e.getMessage());
	    }
	}


//	public void onTestFailure(ITestResult result) {
//		logger.error(result.getMethod().getMethodName() + " " + "FAILED");
//		logger.error(result.getThrowable().getMessage());
//		ExtentReporterUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName() + " " + "FAILED");
//		ExtentReporterUtility.getTest().log(Status.FAIL,result.getThrowable().getMessage());
//
//	
//		Object testclass=result.getInstance();
//		
//		BrowserUtility browserUtility=	((TestBase)testclass).getInstance();
//		logger.info("Capturing ScreenShot for the failed tests");
//		
//		String screenshotPath=browserUtility.takeScreenShot(result.getMethod().getMethodName());
//		logger.info("Attaching the Screenshot to the HTML File");
//		
//		try {
//			ExtentReporterUtility.getTest().addScreenCaptureFromPath(screenshotPath);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public void onTestSkipped(ITestResult result) {
		logger.warn(result.getMethod().getMethodName() + " " + "SKIPPED");
		ExtentReporterUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " " + "SKIPPED");
	}
	
	public void onStart(ITestContext context) {
		logger.info("Test Suite Started");
		ExtentReporterUtility.setUpSparkReporter("report.html");
		
	}


	public void onFinish(ITestContext context) {
		logger.info("Test Suite Completed" );
		ExtentReporterUtility.flushReport();
	}

}
