package com.zs.pages.vijetha;

import com.zs.locators.VijethaLocators;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Class which contains all the functions which perform operation in Search Page of Vijetha
 */

public class SearchPageVijetha {
    private static IOSDriver driver;

    /**
     * Constructor that initialises IOSDriver and WebDriverWait
     * @param CurrentDriver Current IOSDriver on which test cases will run
     */

    public SearchPageVijetha(IOSDriver CurrentDriver){
        driver = CurrentDriver;
    }

    /**
     * Function used to click Back button
     */

    public void clickBackButton(){
        By BackButtonLoc = VijethaLocators.getSearchPageLocator("back");
        WebElement BackButtonBtn = driver.findElement(BackButtonLoc);
        BackButtonBtn.click();
    }
}
