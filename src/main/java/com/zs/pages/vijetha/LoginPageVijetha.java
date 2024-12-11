package com.zs.pages.vijetha;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static com.zs.locators.VijethaLocators.getLoginLocator;

/**
 * Class which contains all the functions which perform operation in Login Page of Vijetha
 */

public class LoginPageVijetha {
    private final WebDriverWait wait;

    /**
     * Constructor that initialises IOSDriver and WebDriverWait
     * @param wait WebDriverWait variable used to initialise wait variable of the class
     */

    public LoginPageVijetha(WebDriverWait wait){
        this.wait=wait;
    }

    /**
     * Function used to click Login with Password Button
     */

    public void clickLoginWithPassword(){
        By loginWithPasswordLoc = getLoginLocator("logInWithPassword");
        WebElement loginWithPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(loginWithPasswordLoc));
        loginWithPassword.click();
    }
}