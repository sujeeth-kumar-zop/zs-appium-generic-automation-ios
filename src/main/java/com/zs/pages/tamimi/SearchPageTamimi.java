package com.zs.pages.tamimi;

import com.zs.locators.TamimiLocators;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPageTamimi {
    private static IOSDriver driver;
    private final WebDriverWait wait;

    public SearchPageTamimi(IOSDriver Currentdriver, WebDriverWait wait){
        driver =Currentdriver;
        this.wait=wait;
    }

    public void clickSearchBar(){
        By SearchBarLoc = TamimiLocators.getHomePageLocator("searchBar");
        WebElement SearchBarBtn = driver.findElement(SearchBarLoc);
        SearchBarBtn.click();
    }

    public void clickCancelButton(){
        By CancelButtonLoc = TamimiLocators.getSearchPageLocator("cancel");
        WebElement CancelBtn = driver.findElement(CancelButtonLoc);
        CancelBtn.click();
    }

    public void enterProduct(String product){
        By SearchLoc = TamimiLocators.getSearchPageLocator("search");
        WebElement searchBox = driver.findElement(SearchLoc);
        wait.until(ExpectedConditions.visibilityOf(searchBox)).sendKeys(product);
    }
    public boolean verifyProduct(){
        By SpecificProductLoc = TamimiLocators.getProductPageLocators("SpecificProduct");
        WebElement specificProduct = driver.findElement(SpecificProductLoc);
        String specificProductName = specificProduct.getText();
        return specificProductName.contains("French Cheese Potato Chips");
    }
    public void productSearchFlow(){
        SearchPageTamimi searchPageTamimi =new SearchPageTamimi(driver, wait);
        searchPageTamimi.clickCancelButton();
        searchPageTamimi.clickSearchBar();
        searchPageTamimi.enterProduct("French Cheese Potato Chips");
    }
}
