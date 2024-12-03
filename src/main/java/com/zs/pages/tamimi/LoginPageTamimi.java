package com.zs.pages.tamimi;


import com.zs.locators.TamimiLocators;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPageTamimi {

    private final WebDriverWait wait;

    public LoginPageTamimi(WebDriverWait wait){
        this.wait=wait;
    }

    public void clickNotNow(){
        By notNowLoc = TamimiLocators.getHomePageLocator("notNow");
        WebElement notNow = wait.until(ExpectedConditions.visibilityOfElementLocated(notNowLoc));
        notNow.click();
    }
}