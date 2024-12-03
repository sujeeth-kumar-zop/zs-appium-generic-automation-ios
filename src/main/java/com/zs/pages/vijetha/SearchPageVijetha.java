package com.zs.pages.vijetha;

import com.zs.locators.VijethaLocators;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPageVijetha {
    private static IOSDriver driver;
    private final WebDriverWait wait;

    public SearchPageVijetha(IOSDriver CurrentDriver, WebDriverWait wait){
        driver = CurrentDriver;
        this.wait=wait;
    }
    public void enterProduct(String Product){
        By SearchLoc = VijethaLocators.getSearchPageLocator("searchBar");
        WebElement searchBox = driver.findElement(SearchLoc);
        wait.until(ExpectedConditions.visibilityOf(searchBox)).sendKeys(Product);
    }
    public void clickCancelButton(){
        By CancelButtonLoc = VijethaLocators.getSearchPageLocator("cancel");
        WebElement CancelBtn = driver.findElement(CancelButtonLoc);
        CancelBtn.click();
    }
    public void clickBackButton(){
        By BackButtonLoc = VijethaLocators.getSearchPageLocator("back");
        WebElement BackButtonBtn = driver.findElement(BackButtonLoc);
        BackButtonBtn.click();
    }

    public boolean verifyProduct(){
        By SpecificProductLoc = VijethaLocators.getProductPageLocators("SpecificProduct");
        WebElement specificProduct = driver.findElement(SpecificProductLoc);
        String specificProductName = specificProduct.getText();
        return specificProductName.contains("Bingo Hashtags Spicy Masala");
    }
    public void productSearchFlow(){
        SearchPageVijetha searchPageVijetha =new SearchPageVijetha(driver, wait);
        searchPageVijetha.clickCancelButton();
        searchPageVijetha.enterProduct("Bingo Hashtags Spicy Masala");
    }
}
