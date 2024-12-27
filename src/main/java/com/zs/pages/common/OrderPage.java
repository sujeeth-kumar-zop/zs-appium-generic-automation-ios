package com.zs.pages.common;

import com.zs.utils.CommonUtils;
import com.zs.utils.LoggerUtil;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class which contains all the functions which perform operation in Cancellation Page
 */

public class OrderPage {
    private static IOSDriver driver;
    private static WebDriverWait wait = null;

    /**
     * Constructor that initialises IOSDriver and WebDriverWait
     * @param CurrentDriver Current IOSDriver on which test cases will run
     * @param wait WebDriverWait variable used to initialise wait variable of the class
     */

    public OrderPage(IOSDriver CurrentDriver, WebDriverWait wait) {
        driver = CurrentDriver;
        OrderPage.wait = wait;
    }

    /**
     * Function used to click Back Button
     * @param appName takes appName as the parameter and decides on which particular application clickBackButton function should be executed
     */

    public void clickBackButton(String appName){
        By BackButtonLoc = CommonUtils.getCartPageLocators(appName,"BackButton");
        WebElement BackBtn = driver.findElement(BackButtonLoc);
        BackBtn.click();
    }

    /**
     * Function used to click Profile Button
     * @param appName takes appName as the parameter and decides on which particular application clickProfileIcon function should be executed
     */

    public void clickProfileIcon(String appName){
        By ProfileIconLoc = CommonUtils.getLoginLocator(appName,"profileIcon");
        WebElement ProfileIcon = driver.findElement(ProfileIconLoc);
        ProfileIcon.click();
    }

    /**
     * Function used to click My Orders Button
     * @param appName takes appName as the parameter and decides on which particular application clickMyOrdersButton function should be executed
     */

    public void clickMyOrdersButton(String appName){
        By MyOrdersButton = CommonUtils.getOrderPageLocators(appName,"MyOrdersButton");
        WebElement MyOrderBtn = driver.findElement(MyOrdersButton);
        MyOrderBtn.click();
    }

    /**
     * Function used to click Options Button
     * @param appName takes appName as the parameter and decides on which particular application clickOptionsButton function should be executed
     */

    public void clickOptionsButton(String appName){
        By OptionsButton = CommonUtils.getOrderPageLocators(appName,"OptionsButton");
        WebElement OptionsBtn = driver.findElement(OptionsButton);
        OptionsBtn.click();
    }

    /**
     * Function used to click Cancel Button
     * @param appName takes appName as the parameter and decides on which particular application clickCancelButton function should be executed
     */

    public void clickCancelButton(String appName){
        By CancelButton = CommonUtils.getOrderPageLocators(appName,"CancelButton");
        WebElement OptionsBtn = driver.findElement(CancelButton);
        OptionsBtn.click();
    }

    /**
     * Function used to click Alert Yes
     * @param appName takes appName as the parameter and decides on which particular application clickAlertYes function should be executed
     */

    public void clickAlertYes(String appName){
        By YesButton = CommonUtils.getOrderPageLocators(appName,"ClickYes");
        WebElement YesBtn = driver.findElement(YesButton);
        YesBtn.click();
    }

    /**
     * Function which control the Cancel Order Test case Flow
     * @param appName takes appName as the parameter and decides on which particular application checkOutFlowCOD function should be executed
     */

    public void cancelOrderFlow(String appName) {
        LoggerUtil.logInfo("Cancel Order Test Case Started for " + appName);
        OrderPage orderPage = new OrderPage(driver, wait);
        orderPage.clickBackButton(appName);
        LoggerUtil.logInfo("Back Button Clicked");
        orderPage.clickProfileIcon(appName);
        LoggerUtil.logInfo("Profile Icon Clicked");
        orderPage.clickMyOrdersButton(appName);
        LoggerUtil.logInfo("My Orders Button Clicked");
        orderPage.clickOptionsButton(appName);
        LoggerUtil.logInfo("Options Button Clicked");
        orderPage.clickCancelButton(appName);
        LoggerUtil.logInfo("Cancel Button Clicked");
        orderPage.clickAlertYes(appName);
        LoggerUtil.logInfo("Yes Clicked");
    }

    public boolean verifyCancellation(String appName){
        By Amount = CommonUtils.getOrderPageLocators(appName,"Amount");
        WebElement amount = driver.findElement(Amount);
        String TotalCost = amount.getText();
        return TotalCost.contains("0.00 SAR");
    }

}

