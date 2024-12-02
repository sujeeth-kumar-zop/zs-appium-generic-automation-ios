package com.zs.pages.vijetha;

import com.zs.locators.TamimiLocators;
import com.zs.locators.VijethaLocators;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class SearchPageVijetha {
    private static IOSDriver driver;
    private final WebDriverWait wait;
//    private static final Logger logger= LoggerUtil.getLogger();

    public SearchPageVijetha(IOSDriver CurrentDriver, WebDriverWait wait){
        driver = CurrentDriver;
        this.wait=wait;
    }

    public void clickSearchBar(){
        By SearchBarLoc = VijethaLocators.getHomePageLocator("searchBar");
        WebElement SearchBarBtn = driver.findElement(SearchBarLoc);
        SearchBarBtn.click();
    }

    public void enterProduct(String Product){
        By SearchLoc = VijethaLocators.getSearchPageLocator("searchBar");
        WebElement searchBox = driver.findElement(SearchLoc);
        wait.until(ExpectedConditions.visibilityOf(searchBox)).sendKeys(Product);
    }

    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(7) + 2;
    }
    public void clickCancelButton(){
        By CancelButtonLoc = VijethaLocators.getSearchPageLocator("cancel");
        WebElement CancelBtn = driver.findElement(CancelButtonLoc);
        CancelBtn.click();
    }
    public void clickSearchIconButton(){
        By SearchIconLoc = VijethaLocators.getHomePageLocator("searchIcon");
        WebElement SearchIconBtn = driver.findElement(SearchIconLoc);
        SearchIconBtn.click();
    }

    public void clickBackButton(){
        By BackButtonLoc = VijethaLocators.getSearchPageLocator("back");
        WebElement BackButtonBtn = driver.findElement(BackButtonLoc);
        BackButtonBtn.click();
    }

    public boolean verifyGeneralProduct(){
        int randomNumber=generateRandomNumber();
        By Product1Loc = VijethaLocators.getProductListsLocator("Product1");
        WebElement product1 = driver.findElement(Product1Loc);
        String Product1Name = product1.getText();
        boolean result1=Product1Name.contains("Orange");
        boolean result2=true;
        switch (randomNumber) {
            case 2:
                By Product2Loc = VijethaLocators.getProductListsLocator("Product2");
                WebElement product2 = driver.findElement(Product2Loc);
                String Product2Name = product2.getText();
                result2=Product2Name.contains("Orange");
                break;
            case 3:
                By Product3Loc = VijethaLocators.getProductListsLocator("Product3");
                WebElement product3 = driver.findElement(Product3Loc);
                String Product3Name = product3.getText();
                result2=Product3Name.contains("Orange");
                break;
            case 4:
                By Product4Loc = VijethaLocators.getProductListsLocator("Product4");
                WebElement product4 = driver.findElement(Product4Loc);
                String Product4Name = product4.getText();
                result2=Product4Name.contains("Orange");
                break;
            case 5:
                By Product5Loc = VijethaLocators.getProductListsLocator("Product5");
                WebElement product5 = driver.findElement(Product5Loc);
                String Product5Name = product5.getText();
                result2=Product5Name.contains("Orange");
                break;
            case 6:
                By Product6Loc = VijethaLocators.getProductListsLocator("Product6");
                WebElement product6 = driver.findElement(Product6Loc);
                String Product6Name = product6.getText();
                result2= Product6Name.contains("Orange");
                break;
            case 7:
                By Product7Loc = VijethaLocators.getProductListsLocator("Product7");
                WebElement product7 = driver.findElement(Product7Loc);
                String Product7Name = product7.getText();
                result2= Product7Name.contains("Orange");
                break;
            case 8:
                By Product8Loc = VijethaLocators.getProductListsLocator("Product8");
                WebElement product8 = driver.findElement(Product8Loc);
                String Product8Name = product8.getText();
                result2= Product8Name.contains("Orange");
                break;
        }
        return result1 && result2;
    }
    public boolean verifyProduct(){
        By SpecificProductLoc = VijethaLocators.getProductPageLocators("SpecificProduct");
        WebElement specificProduct = driver.findElement(SpecificProductLoc);
        String specificProductName = specificProduct.getText();
        return specificProductName.contains("Bingo Hashtags Spicy Masala");
    }
    public void generalSearchFlow(){
        SearchPageVijetha searchPageVijetha =new SearchPageVijetha(driver, wait);
        for(int i=0; i<2; i++) {
            searchPageVijetha.clickBackButton();
        }
        searchPageVijetha.clickSearchIconButton();
        searchPageVijetha.enterProduct("Orange");
    }
    public void productSearchFlow(){
        SearchPageVijetha searchPageVijetha =new SearchPageVijetha(driver, wait);
        searchPageVijetha.clickCancelButton();
        searchPageVijetha.enterProduct("Bingo Hashtags Spicy Masala");
    }
}
