package com.zs.pages.common;

import com.zs.pages.tamimi.HomePageTamimi;;
import com.zs.pages.vijetha.SearchPageVijetha;
import com.zs.utils.CommonUtils;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class SearchPage {
    private static IOSDriver driver;
    private final WebDriverWait wait;

    public SearchPage(IOSDriver CurrentDriver, WebDriverWait wait){
        driver =CurrentDriver;
        this.wait=wait;
    }

    public void clickSearchBar(String appName){
        By SearchBarLoc = CommonUtils.getHomePageLocator(appName ,"searchIcon");
        WebElement SearchBarBtn = driver.findElement(SearchBarLoc);
        SearchBarBtn.click();
    }

    public void enterProduct(String appName, String product){
        By SearchLoc = CommonUtils.getSearchPageLocators(appName,"search");
        WebElement searchBox = driver.findElement(SearchLoc);
        wait.until(ExpectedConditions.visibilityOf(searchBox)).sendKeys(product);
    }

    public void generalSearchFlow(String appName){
        SearchPage searchPage =new SearchPage(driver, wait);
        String product = switch (appName) {
            case "Tamimi" -> "Tomato";
            case "Vijetha" -> "Orange";
            default -> "";
        };
        if(appName.equals("Tamimi")){
            HomePageTamimi homePageTamimi =new HomePageTamimi(driver, wait);
            homePageTamimi.clickHomeButton();
        }
        else{
            SearchPageVijetha searchPageVijetha =new SearchPageVijetha(driver, wait);
            for(int i=0; i<2; i++) {
                searchPageVijetha.clickBackButton();
            }
        }
        searchPage.clickSearchBar(appName);
        searchPage.enterProduct(appName, product);
    }

    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(4) + 2;
    }

    public boolean verifyGeneralProduct(String appName){
        int randomNumber=generateRandomNumber();
        String product = switch (appName) {
            case "Tamimi" -> "Tomato";
            case "Vijetha" -> "Orange";
            default -> "";
        };
        By Product1Loc = CommonUtils.getProductListsLocators(appName,"Product1");
        WebElement product1 = driver.findElement(Product1Loc);
        String Product1Name = product1.getText();
        boolean result1=Product1Name.contains(product);
        boolean result2=true;
        switch (randomNumber) {
            case 2:
                By Product2Loc = CommonUtils.getProductListsLocators(appName,"Product2");
                WebElement product2 = driver.findElement(Product2Loc);
                String Product2Name = product2.getText();
                result2=Product2Name.contains(product);
                break;
            case 3:
                By Product3Loc = CommonUtils.getProductListsLocators(appName,"Product3");
                WebElement product3 = driver.findElement(Product3Loc);
                String Product3Name = product3.getText();
                result2=Product3Name.contains(product);
                break;
            case 4:
                By Product4Loc = CommonUtils.getProductListsLocators(appName,"Product4");
                WebElement product4 = driver.findElement(Product4Loc);
                String Product4Name = product4.getText();
                result2=Product4Name.contains(product);
                break;
            case 5:
                By Product5Loc = CommonUtils.getProductListsLocators(appName,"Product5");
                WebElement product5 = driver.findElement(Product5Loc);
                String Product5Name = product5.getText();
                result2=Product5Name.contains(product);
                break;
        }
        return result1 && result2;
    }
}