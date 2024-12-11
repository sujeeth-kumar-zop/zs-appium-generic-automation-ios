package com.zs.pages.tamimi;


import com.zs.locators.TamimiLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class which contains all the functions which perform operation in Login Page of Tamimi
 */

public class LoginPageTamimi {
    private final WebDriverWait wait;

    /**
     * Constructor that initialises IOSDriver and WebDriverWait
     * @param wait WebDriverWait variable used to initialise wait variable of the class
     */

    public LoginPageTamimi(WebDriverWait wait){
        this.wait=wait;
    }

    /**
     * Function used to click Not Now Button
     */

    public void clickNotNow(){
        By notNowLoc = TamimiLocators.getHomePageLocator("notNow");
        WebElement notNow = wait.until(ExpectedConditions.visibilityOfElementLocated(notNowLoc));
        notNow.click();
    }
}