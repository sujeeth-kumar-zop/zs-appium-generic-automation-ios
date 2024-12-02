package com.zs.pages.common;

import com.zs.utils.CommonUtils;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    private final IOSDriver driver;
    private final WebDriverWait wait;

    public ProfilePage(IOSDriver driver, WebDriverWait wait){
        this.driver =driver;
        this.wait=wait;
    }

    public boolean isUsernameVisible(String appName){
        By usernameLoc = CommonUtils.getProfileLocator(appName, "username");
        WebElement username = driver.findElement(usernameLoc);
        return username.isDisplayed();
    }
}
