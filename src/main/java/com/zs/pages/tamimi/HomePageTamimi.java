package com.zs.pages.tamimi;

import com.zs.locators.TamimiLocators;
import com.zs.utils.LoggerUtil;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class HomePageTamimi {
    private final Map<String, String> product = new HashMap<>();
    private static  IOSDriver driver;
    private final WebDriverWait wait;

//    private static final Logger logger= LoggerUtil.getLogger();

    public HomePageTamimi(IOSDriver currentDriver, WebDriverWait wait){
        driver = currentDriver;
        this.wait=wait;
    }

    public void clickDepartmentButton(){
        By FruitsAndVegetablesLoc = TamimiLocators.getHomePageLocator("department");
        WebElement FruitsAndVegetablesBtn = driver.findElement(FruitsAndVegetablesLoc);
        FruitsAndVegetablesBtn.click();
    }
    public void clickAddButton(){
        By ProductBeforeAddLoc = TamimiLocators.getDepartmentLocator("ProductNameBeforeAdd");
        WebElement productBeforeAdd = driver.findElement(ProductBeforeAddLoc);
        product.put("ProductBeforeAddName", productBeforeAdd.getText());
        By ProductPriceBeforeAddLoc = TamimiLocators.getDepartmentLocator("ProductPriceBeforeAdd");
        WebElement productPriceBeforeAdd = driver.findElement(ProductPriceBeforeAddLoc);
        product.put("ProductBeforeAddPrice", productPriceBeforeAdd.getText());
        By AddButtonLoc = TamimiLocators.getDepartmentLocator("addButton");
        WebElement AddBtn = driver.findElement(AddButtonLoc);
        AddBtn.click();
    }
    public void clickCartButton(){
        By CartButtonLoc = TamimiLocators.getDepartmentLocator("CartButton");
        WebElement CartBtn = driver.findElement(CartButtonLoc);
        CartBtn.click();
        By ProductAfterAddLoc = TamimiLocators.getProductPageLocators("ProductNameAfterAdd");
        WebElement productAfterAdd = driver.findElement(ProductAfterAddLoc);
        product.put("ProductAfterAddName", productAfterAdd.getText());
        By ProductPriceAfterAddLoc = TamimiLocators.getProductPageLocators("ProductPriceAfterAdd");
        WebElement productPriceAfterAdd = driver.findElement(ProductPriceAfterAddLoc);
        product.put("ProductAfterAddPrice", productPriceAfterAdd.getText());
    }

    public void clickHomeButton(){
        By HomeButtonLoc = TamimiLocators.getHomePageLocator("homeIcon");
        WebElement HomeBtn = driver.findElement(HomeButtonLoc);
        HomeBtn.click();
    }
    public boolean verifyProduct(){
        HomePageTamimi homePageTamimi =new HomePageTamimi(driver, wait);
        homePageTamimi.clickCartButton();
        String ProductBeforeAddName= product.get("ProductBeforeAddName");
        ProductBeforeAddName=ProductBeforeAddName.replace(" ", "");
        String ProductAfterAddName= product.get("ProductAfterAddName");
        ProductAfterAddName=ProductAfterAddName.replace(" ", "");
        String ProductBeforeAddPrice= product.get("ProductBeforeAddPrice");
        ProductBeforeAddPrice=ProductBeforeAddPrice.replace(" ", "");
        String ProductAfterAddPrice= product.get("ProductAfterAddPrice");
        ProductAfterAddPrice=ProductAfterAddPrice.replace(" ", "");
        LoggerUtil.logInfo("Add to Cart Test Case Successfully Completed for Tamimi");
        return ProductBeforeAddName.equals(ProductAfterAddName) && ProductBeforeAddPrice.equals(ProductAfterAddPrice);
    }

    public void addToCartFlow(){
        LoggerUtil.logInfo("Add to Cart Test Case Started for Tamimi");
        HomePageTamimi homePageTamimi =new HomePageTamimi(driver, wait);
        homePageTamimi.clickHomeButton();
        LoggerUtil.logInfo("Clicked Home Page Button");
        homePageTamimi.clickDepartmentButton();
        LoggerUtil.logInfo("Clicked Department Button");
        homePageTamimi.clickAddButton();
        LoggerUtil.logInfo("Clicked Add Button");
    }
}
