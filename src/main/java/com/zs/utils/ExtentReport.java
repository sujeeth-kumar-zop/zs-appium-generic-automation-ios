package com.zs.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReport implements ITestListener {
    private static ExtentReports extent;
    private static ExtentSparkReporter sparkReporter;

    private static ThreadLocal<ExtentTest> threadLocalTest = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        if (extent == null) {
            sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/ExtentReport.html");
            sparkReporter.config().setDocumentTitle("iOS Automation Report");
            sparkReporter.config().setReportName("Functionality Report");

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            extent.setSystemInfo("Tester Name", "SDET");
            extent.setSystemInfo("OS", "MacOS");
            extent.setSystemInfo("Device", "iOS");
            extent.setSystemInfo("Device Name", "iPhone 16 Pro");
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        threadLocalTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        threadLocalTest.get().log(Status.PASS, "Test Case Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = threadLocalTest.get();
        test.log(Status.FAIL, "Test Case Failed: " + result.getName());
        test.log(Status.FAIL, "Failure Reason: " + result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        threadLocalTest.get().log(Status.SKIP, "Test Case Skipped: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        if (extent != null) {
            extent.flush();
        }
    }

    public static ExtentTest getTest() {
        return threadLocalTest.get();
    }
}
