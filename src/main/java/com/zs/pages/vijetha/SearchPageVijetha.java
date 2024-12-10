package com.zs.pages.vijetha;

import com.zs.locators.VijethaLocators;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class SearchPageVijetha {
    private static IOSDriver driver;
    public SearchPageVijetha(IOSDriver CurrentDriver){
        driver = CurrentDriver;
    }
    public void clickBackButton(){
        By BackButtonLoc = VijethaLocators.getSearchPageLocator("back");
        WebElement BackButtonBtn = driver.findElement(BackButtonLoc);
        BackButtonBtn.click();
    }

}
