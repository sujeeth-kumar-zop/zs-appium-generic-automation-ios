package com.zs.pages.common;

import com.zs.utils.CommonUtils;
import com.zs.utils.LoggerUtil;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class which contains all the functions which perform operation in Profile Page
 */

public class ProfilePage {
    private final IOSDriver driver;
    private final WebDriverWait wait;

    /**
     * Constructor that initialises IOSDriver and WebDriverWait
     * @param CurrentDriver Current IOSDriver on which test cases will run
     * @param wait WebDriverWait variable used to initialise wait variable of the class
     */

    public ProfilePage(IOSDriver CurrentDriver, WebDriverWait wait){
        this.driver = CurrentDriver;
        this.wait=wait;
    }

    /**
     * Function used to assert Login Test Cases
     * Verifies if Login is successfully
     * @param appName takes appName as the parameter and decides on which particular application isUsernameVisible function should be executed
     * @return returns boolean value "true" if the Login is Successful and boolean value "false" if the Login fails
     */

    public boolean isUsernameVisible(String appName){
        By usernameLoc = CommonUtils.getProfileLocator(appName, "username");
        WebElement username = driver.findElement(usernameLoc);
        if(username.isDisplayed()){
            LoggerUtil.logInfo("Login Test Case Completed Successfully for " + appName);
            return true;
        }
        return false;
    }
}
