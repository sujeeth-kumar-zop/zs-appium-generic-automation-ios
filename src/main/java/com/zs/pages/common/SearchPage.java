package com.zs.pages.common;

import com.zs.constants.Constants;
import com.zs.locators.VijethaLocators;
import com.zs.pages.tamimi.HomePageTamimi;
import com.zs.utils.CommonUtils;
import com.zs.utils.LoggerUtil;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Random;

/**
 * Class which contains all the functions which perform operation in Search Page
 */

public class SearchPage {
    private static IOSDriver driver;
    private final WebDriverWait wait;

    /**
     * Constructor that initialises IOSDriver and WebDriverWait
     * @param CurrentDriver Current IOSDriver on which test cases will run
     * @param wait WebDriverWait variable used to initialise wait variable of the class
     */

    public SearchPage(IOSDriver CurrentDriver, WebDriverWait wait){
        driver =CurrentDriver;
        this.wait=wait;
    }

    /**
     * Function used to click Search Bar
     * @param appName takes appName as the parameter and decides on which particular application clickSearchBar function should be executed
     */

    public void clickSearchBar(String appName){
        By SearchBarLoc = CommonUtils.getHomePageLocator(appName ,"searchIcon");
        WebElement SearchBarBtn = driver.findElement(SearchBarLoc);
        SearchBarBtn.click();
    }

    /**
     * Function used to Enter Product name in the Search Bar
     * @param appName takes appName as the parameter and decides on which particular application enterProduct function should be executed
     * @param product takes String product as the parameter which contains product name to be entered in the Search Bar
     */

    public void enterProduct(String appName, String product){
        By SearchLoc = CommonUtils.getSearchPageLocators(appName,"search");
        WebElement searchBox = driver.findElement(SearchLoc);
        wait.until(ExpectedConditions.visibilityOf(searchBox)).sendKeys(product);
    }

    /**
     * Function used to click Cancel button
     * @param appName takes appName as the parameter and decides on which particular application clickCancelButton function should be executed
     */

    public void clickCancelButton(String appName){
        By CancelButtonLoc = CommonUtils.getSearchPageLocators(appName,"cancel");
        WebElement CancelBtn = driver.findElement(CancelButtonLoc);
        CancelBtn.click();
    }

    /**
     * Function used to click Back button for Vijetha
     */

    public void clickBackButton(){
        By BackButtonLoc = VijethaLocators.getSearchPageLocator("back");
        WebElement BackButtonBtn = driver.findElement(BackButtonLoc);
        BackButtonBtn.click();
    }

    /**
     * Function which control the search flow of a general product
     * @param appName takes appName as the parameter and decides on which particular application generalSearchFlow function should be executed
     */

    public void generalSearchFlow(String appName){
        LoggerUtil.logInfo("General Product Test Case Started for" + appName);
        SearchPage searchPage =new SearchPage(driver, wait);
        String product = switch (appName) {
            case Constants.TAMIMI -> Constants.GENERAL_SEARCH_PRODUCT_FOR_TAMIMI;
            case Constants.VIJETHA -> Constants.GENERAL_SEARCH_PRODUCT_FOR_VIJETHA;
            default -> "";
        };
        if(appName.equals(Constants.TAMIMI)){
            HomePageTamimi homePageTamimi =new HomePageTamimi(driver, wait);
            homePageTamimi.clickHomeButton();
            LoggerUtil.logInfo("Home Button clicked");
        }
        else{
            for(int i=0; i<2; i++) {
                searchPage.clickBackButton();
            }
        }
        searchPage.clickSearchBar(appName);
        LoggerUtil.logInfo("Search Bar Clicked");
        searchPage.enterProduct(appName, product);
        LoggerUtil.logInfo("Product Entered and Search Successfully Completed for" + appName);
    }

    /**
     * Function which control the search flow of a specific product
     * @param appName takes appName as the parameter and decides on which particular application productSearchFlow function should be executed
     */

    public void productSearchFlow(String appName){
        LoggerUtil.logInfo("Specific Product Test Case Started for " + appName);
        String product = switch (appName) {
            case Constants.TAMIMI -> Constants.SPECIFIC_SEARCH_PRODUCT_FOR_TAMIMI;
            case Constants.VIJETHA -> Constants.SPECIFIC_SEARCH_PRODUCT_FOR_VIJETHA;
            default -> "";
        };
        SearchPage searchPage =new SearchPage(driver, wait);
        searchPage.clickCancelButton(appName);
        if(appName.equals(Constants.TAMIMI)){
            searchPage.clickSearchBar(appName);
            LoggerUtil.logInfo("Search Bar Clicked");
        }
        searchPage.enterProduct(appName, product);
        LoggerUtil.logInfo("Product Entered and Search Successfully Completed for " + appName);
    }

    /**
     * Function which generates a random number
     * @return an integer which contains the random number generated
     */
    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(4) + 2;
    }

    /**
     * Function used to assert General Product Search Test Cases
     * Verifies if Search is successfully. Checks if the first product is related to the Searched product and randomly checks among the next 4 products if the product is related to Searched product
     * @param appName takes appName as the parameter and decides on which particular application verifyGeneralProduct function should be executed
     * @return returns boolean value "true" if the Search is Successful and boolean value "false" if the Search fails
     */

    public boolean verifyGeneralProduct(String appName){
        int randomNumber=generateRandomNumber();
        String product = switch (appName) {
            case Constants.TAMIMI -> Constants.GENERAL_SEARCH_PRODUCT_FOR_TAMIMI;
            case Constants.VIJETHA -> Constants.GENERAL_SEARCH_PRODUCT_FOR_VIJETHA;
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
        if(result1 && result2){
            LoggerUtil.logInfo("General Product Search Test Case Completed Successfully for " + appName);
            return true;
        }
        return false;
    }

    /**
     * Function used to assert Specific Product Search Test Cases
     * Verifies if the Search is successfully. Checks if the first product in the list is searched product
     * @param appName takes appName as the parameter and decides on which particular application verifyProduct function should be executed
     * @return returns boolean value "true" if the Search is Successful and boolean value "false" if the Search fails
     */

    public boolean verifyProduct(String appName){
        String product = switch (appName) {
            case Constants.TAMIMI -> Constants.SPECIFIC_SEARCH_PRODUCT_FOR_TAMIMI;
            case Constants.VIJETHA -> Constants.SPECIFIC_SEARCH_PRODUCT_FOR_VIJETHA;
            default -> "";
        };
        By SpecificProductLoc = CommonUtils.getProductPageLocators(appName,"SpecificProduct");
        WebElement specificProduct = driver.findElement(SpecificProductLoc);
        String specificProductName = specificProduct.getText();
        if(specificProductName.contains(product)){
            LoggerUtil.logInfo("Product Search Test Case Completed Successfully for " + appName);
            return true;
        }
        return false;
    }
}
