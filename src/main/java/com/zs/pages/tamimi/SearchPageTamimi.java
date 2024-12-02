package com.zs.pages.tamimi;

import com.zs.locators.TamimiLocators;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class SearchPageTamimi {
    private static IOSDriver driver;
    private final WebDriverWait wait;
//    private static final Logger logger= LoggerUtil.getLogger();

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

    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(4) + 2;
    }

    public boolean verifyGeneralProduct(){
        int randomNumber=generateRandomNumber();
        By Product1Loc = TamimiLocators.getProductListsLocator("Product1");
        WebElement product1 = driver.findElement(Product1Loc);
        String Product1Name = product1.getText();
        boolean result1=Product1Name.contains("Tomato");
        boolean result2=true;
        switch (randomNumber) {
            case 2:
                By Product2Loc = TamimiLocators.getProductListsLocator("Product2");
                WebElement product2 = driver.findElement(Product2Loc);
                String Product2Name = product2.getText();
                result2=Product2Name.contains("Tomato");
                break;
            case 3:
                By Product3Loc = TamimiLocators.getProductListsLocator("Product3");
                WebElement product3 = driver.findElement(Product3Loc);
                String Product3Name = product3.getText();
                result2=Product3Name.contains("Tomato");
                break;
            case 4:
                By Product4Loc = TamimiLocators.getProductListsLocator("Product4");
                WebElement product4 = driver.findElement(Product4Loc);
                String Product4Name = product4.getText();
                result2=Product4Name.contains("Tomato");
                break;
            case 5:
                By Product5Loc = TamimiLocators.getProductListsLocator("Product5");
                WebElement product5 = driver.findElement(Product5Loc);
                String Product5Name = product5.getText();
                result2=Product5Name.contains("Tomato");
                break;
        }
        return result1 && result2;
    }
    public boolean verifyProduct(){
        By SpecificProductLoc = TamimiLocators.getProductPageLocators("SpecificProduct");
        WebElement specificProduct = driver.findElement(SpecificProductLoc);
        String specificProductName = specificProduct.getText();
        return specificProductName.contains("French Cheese Potato Chips");
    }
    public void generalSearchFlow(){
        SearchPageTamimi searchPageTamimi =new SearchPageTamimi(driver, wait);
        HomePageTamimi homePageTamimi =new HomePageTamimi(driver, wait);
        homePageTamimi.clickHomeButton();
        searchPageTamimi.clickSearchBar();
        searchPageTamimi.enterProduct("Tomato");
    }
    public void productSearchFlow(){
        SearchPageTamimi searchPageTamimi =new SearchPageTamimi(driver, wait);
        searchPageTamimi.clickCancelButton();
        searchPageTamimi.clickSearchBar();
        searchPageTamimi.enterProduct("French Cheese Potato Chips");
    }
}
