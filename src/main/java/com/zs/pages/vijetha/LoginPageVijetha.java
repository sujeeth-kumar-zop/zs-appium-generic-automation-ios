package com.zs.pages.vijetha;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.zs.locators.VijethaLocators.getLoginLocator;
public class LoginPageVijetha {
    private final WebDriverWait wait;

    public LoginPageVijetha(WebDriverWait wait){
        this.wait=wait;
    }
    public void clickLoginWithPassword(){
        By loginWithPasswordLoc = getLoginLocator("logInWithPassword");
        WebElement loginWithPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(loginWithPasswordLoc));
        loginWithPassword.click();
    }

}
