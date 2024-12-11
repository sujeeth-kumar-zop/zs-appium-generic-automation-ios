package com.zs.pages.vijetha;

import com.zs.constants.Constants;
import com.zs.locators.VijethaLocators;
import com.zs.utils.LoggerUtil;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.HashMap;
import java.util.Map;

/**
 * Class which contains all the functions which perform operation in Home Page of Vijetha
 */

public class HomePageVijetha {
    public static Map<String, String> Product = new HashMap<>();
    private static  IOSDriver driver;
    private final WebDriverWait wait;
    static String productText;

    /**
     * Constructor that initialises IOSDriver and WebDriverWait
     * @param CurrentDriver Current IOSDriver on which test cases will run
     * @param wait WebDriverWait variable used to initialise wait variable of the class
     */

    public HomePageVijetha(IOSDriver CurrentDriver, WebDriverWait wait){
        driver =CurrentDriver;
        this.wait=wait;
    }

    /**
     * Function used to click Department Button
     */

    public void clickDepartmentButton(){
        By VegetablesLoc = VijethaLocators.getHomePageLocator("department");
        WebElement VegetablesBtn = driver.findElement(VegetablesLoc);
        VegetablesBtn.click();
        By ProductButtonLoc = VijethaLocators.getProductPageLocators("product");
        WebElement Product = driver.findElement(ProductButtonLoc);
        productText = Product.getText();
    }

    /**
     * Function used to click Add Button
     */

    public void clickAddButton(){

        By AddLoc = VijethaLocators.getProductPageLocators("addButton");
        WebElement AddBtn = driver.findElement(AddLoc);
        AddBtn.click();
    }

    /**
     * Function used to click View Cart Button and also stores the name of the product in the cart
     */

    public void clickViewCartButton(){
        By ViewCartLoc = VijethaLocators.getHomePageLocator("viewCart");
        WebElement ViewCartBtn = driver.findElement(ViewCartLoc);
        ViewCartBtn.click();
        By ProductNameAfterAddLoc = VijethaLocators.getCartPageLocator("ProductNameAfterAdd");
        WebElement productNameAfterAdd = driver.findElement(ProductNameAfterAddLoc);
        Product.put("ProductAfterAddName", productNameAfterAdd.getText());
    }

    /**
     * Function used to click Home Button
     */

    public void clickHomeButton(){
        By HomeButtonLoc = VijethaLocators.getHomePageLocator("homeIcon");
        WebElement HomeBtn = driver.findElement(HomeButtonLoc);
        HomeBtn.click();
    }

    /**
     * Function used to click Product and store the name of the product
     */

    public void clickProduct(){
        By ProductButtonLoc = VijethaLocators.getProductPageLocators("product");
        WebElement ProductBtn = driver.findElement(ProductButtonLoc);
        ProductBtn.click();
        By ProductBeforeAddLoc = VijethaLocators.getProductPageLocators("ProductNameBeforeAdd");
        WebElement productBeforeAdd = driver.findElement(ProductBeforeAddLoc);
        Product.put("ProductBeforeAddName", productBeforeAdd.getText());
    }

    /**
     * Function used to click Option Button
     */

    public void clickOptionButton(){
        By OptionButtonLoc = VijethaLocators.getProductPageLocators("optionButton");
        WebElement OptionBtn = driver.findElement(OptionButtonLoc);
        OptionBtn.click();
    }

    /**
     * Function used to click Cancel Button
     */

    public void clickCancelButton(){
        By CancelButtonLoc = VijethaLocators.getProductPageLocators("cancelButton");
        WebElement CancelBtn = driver.findElement(CancelButtonLoc);
        CancelBtn.click();
    }

    /**
     * Function used to assert Add to Cart Test Cases
     * Verifies if Add to Cart is successfully. Checks if the product is added Successfully to the Cart
     * @return returns boolean value "true" if the product is added Successfully and boolean value "false" if product is not added to the cart
     */

    public boolean verifyProduct(){
        HomePageVijetha homePageVijetha =new HomePageVijetha(driver, wait);
        homePageVijetha.clickCancelButton();
        homePageVijetha.clickViewCartButton();
        String ProductBeforeAddName=Product.get("ProductBeforeAddName");
        ProductBeforeAddName=ProductBeforeAddName.replace(" ", "");
        String ProductAfterAddName=Product.get("ProductAfterAddName");
        ProductAfterAddName=ProductAfterAddName.replace(" ", "");
        LoggerUtil.logInfo("Add to Cart Test Case Successfully Completed for " + Constants.VIJETHA);
        return ProductAfterAddName.contains(ProductBeforeAddName);
    }

    /**
     * Function which control the add to cart flow
     */

    public void addToCartFlow()  {
        LoggerUtil.logInfo("Add to Cart Test Case Started for " + Constants.VIJETHA);
        HomePageVijetha homePageVijetha =new HomePageVijetha(driver, wait);
        homePageVijetha.clickHomeButton();
        LoggerUtil.logInfo("Clicked Home Page Button");
        homePageVijetha.clickDepartmentButton();
        LoggerUtil.logInfo("Clicked Department Button");
        homePageVijetha.clickProduct();
        LoggerUtil.logInfo("Clicked on Product");
        homePageVijetha.clickOptionButton();
        LoggerUtil.logInfo("Clicked Options");
        homePageVijetha.clickAddButton();
        LoggerUtil.logInfo("Clicked Add Button");
    }
}