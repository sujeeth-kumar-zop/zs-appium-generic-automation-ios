package com.zs.pages.common;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private static IOSDriver driver;
    private final WebDriverWait wait;
    public HomePage(IOSDriver CurrentDriver, WebDriverWait wait){
        driver =CurrentDriver;
        this.wait=wait;
    }
}
