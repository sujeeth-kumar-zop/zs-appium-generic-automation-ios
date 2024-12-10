package com.zs.utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class LoggerUtil {
    // Logger instance, specific to the LoggerUtil class
    private static final Logger logger = LogManager.getLogger(LoggerUtil.class);
    private static ExtentTest extentTest;
    public static void setExtentTest(ExtentTest test) {
        extentTest = test;
    }
    public static void logInfo(String message) {
        // Log to Log4j console
        logger.info(message);

        // Log to ExtentReports (if ExtentTest is initialized)
        if (extentTest != null) {
            extentTest.log(Status.INFO, message);
        }
    }
    public static void logPass(String message) {
        // Log to Log4j console
        logger.info(message);

        // Log to ExtentReports
        if (extentTest != null) {
            extentTest.log(Status.PASS, message);
        }
    }
    public static void logFail(String message) {
        // Log to Log4j console
        logger.error(message);

        // Log to ExtentReports
        if (extentTest != null) {
            extentTest.log(Status.FAIL, message);
        }
    }
    public static void logError(String message, Throwable throwable) {
        // Log to Log4j console
        logger.error(message, throwable);

        // Log to ExtentReports
        if (extentTest != null) {
            extentTest.log(Status.FAIL, message+ " - Exception: "+ throwable.getMessage());
        }
    }
    public static Logger getLogger() {
        return logger;
    }
}