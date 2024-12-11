package com.zs.pages.tamimi;

import com.zs.constants.Constants;
import com.zs.locators.TamimiLocators;
import com.zs.utils.LoggerUtil;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.HashMap;
import java.util.Map;

/**
 * Class which contains all the functions which perform operation in Home Page of Tamimi
 */

public class HomePageTamimi {
    private final static Map<String, String> product = new HashMap<>();
    private static  IOSDriver driver;
    private final WebDriverWait wait;

    /**
     * Constructor that initialises IOSDriver and WebDriverWait
     * @param currentDriver Current IOSDriver on which test cases will run
     * @param wait WebDriverWait variable used to initialise wait variable of the class
     */

    public HomePageTamimi(IOSDriver currentDriver, WebDriverWait wait){
        driver = currentDriver;
        this.wait=wait;
    }

    /**
     * Function used to click Department Button
     */

    public void clickDepartmentButton(){
        By FruitsAndVegetablesLoc = TamimiLocators.getHomePageLocator("department");
        WebElement FruitsAndVegetablesBtn = driver.findElement(FruitsAndVegetablesLoc);
        FruitsAndVegetablesBtn.click();
    }

    /**
     * Function used to click Add Button and also stores the name of the product added
     */

    public void clickAddButton(){
        By ProductBeforeAddLoc = TamimiLocators.getDepartmentLocator("ProductNameBeforeAdd");
        WebElement productBeforeAddText = wait.until(ExpectedConditions.visibilityOfElementLocated(ProductBeforeAddLoc));
        product.put("ProductBeforeAddName", productBeforeAddText.getText());
        By AddButtonLoc = TamimiLocators.getDepartmentLocator("addButton");
        WebElement AddBtn = driver.findElement(AddButtonLoc);
        AddBtn.click();
    }

    /**
     * Function used to click Cart Button and also stores the name of the product in the cart
     */

    public void clickCartButton(){
        By CartButtonLoc = TamimiLocators.getDepartmentLocator("CartButton");
        WebElement CartBtn = driver.findElement(CartButtonLoc);
        CartBtn.click();
        By ProductAfterAddLoc = TamimiLocators.getProductPageLocators("ProductNameAfterAdd");
        WebElement productAfterAdd = driver.findElement(ProductAfterAddLoc);
        product.put("ProductAfterAddName", productAfterAdd.getText());
    }

    /**
     * Function used to click Home Button
     */

    public void clickHomeButton(){
        By HomeButtonLoc = TamimiLocators.getHomePageLocator("homeIcon");
        WebElement HomeBtn = driver.findElement(HomeButtonLoc);
        HomeBtn.click();
    }

    /**
     * Function used to assert Add to Cart Test Cases
     * Verifies if Add to Cart is successfully. Checks if the product is added Successfully to the Cart
     * @return returns boolean value "true" if the product is added Successfully and boolean value "false" if product is not added to the cart
     */

    public boolean verifyProduct(){
        HomePageTamimi homePageTamimi =new HomePageTamimi(driver, wait);
        homePageTamimi.clickCartButton();
        String ProductBeforeAddNameText= product.get("ProductBeforeAddName");
        ProductBeforeAddNameText=ProductBeforeAddNameText.replace(" ", "");
        String ProductAfterAddName= product.get("ProductAfterAddName");
        ProductAfterAddName=ProductAfterAddName.replace(" ", "");
        LoggerUtil.logInfo("Add to Cart Test Case Successfully Completed for " + Constants.TAMIMI);
        return ProductBeforeAddNameText.equals(ProductAfterAddName);
    }

    /**
     * Function which control the add to cart flow
     */

    public void addToCartFlow(){
        LoggerUtil.logInfo("Add to Cart Test Case Started for " + Constants.TAMIMI);
        HomePageTamimi homePageTamimi =new HomePageTamimi(driver, wait);
        homePageTamimi.clickHomeButton();
        LoggerUtil.logInfo("Clicked Home Page Button");
        homePageTamimi.clickDepartmentButton();
        LoggerUtil.logInfo("Clicked Department Button");
        homePageTamimi.clickAddButton();
        LoggerUtil.logInfo("Clicked Add Button");
    }
}
