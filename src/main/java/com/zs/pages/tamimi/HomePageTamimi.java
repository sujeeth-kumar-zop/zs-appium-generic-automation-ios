package com.zs.pages.tamimi;

import com.zs.locators.TamimiLocators;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class HomePageTamimi {
    public static Map<String, String> Product = new HashMap<>();
    private static  IOSDriver driver;
    private final WebDriverWait wait;

//    private static final Logger logger= LoggerUtil.getLogger();

    public HomePageTamimi(IOSDriver Currentdriver, WebDriverWait wait){
        driver =Currentdriver;
        this.wait=wait;
    }

    public void clickFruitsAndVegetables(){
        By FruitsAndVegetablesLoc = TamimiLocators.getHomePageLocator("department");
        WebElement FruitsAndVegetablesBtn = driver.findElement(FruitsAndVegetablesLoc);
        FruitsAndVegetablesBtn.click();
    }
    public void clickAddButton(){
        By ProductBeforeAddLoc = TamimiLocators.getDepartmentLocator("ProductNameBeforeAdd");
        WebElement productBeforeAdd = driver.findElement(ProductBeforeAddLoc);
        Product.put("ProductBeforeAddName", productBeforeAdd.getText());
        By ProductPriceBeforeAddLoc = TamimiLocators.getDepartmentLocator("ProductPriceBeforeAdd");
        WebElement productPriceBeforeAdd = driver.findElement(ProductPriceBeforeAddLoc);
        Product.put("ProductBeforeAddPrice", productPriceBeforeAdd.getText());
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
        Product.put("ProductAfterAddName", productAfterAdd.getText());
        By ProductPriceAfterAddLoc = TamimiLocators.getProductPageLocators("ProductPriceAfterAdd");
        WebElement productPriceAfterAdd = driver.findElement(ProductPriceAfterAddLoc);
        Product.put("ProductAfterAddPrice", productPriceAfterAdd.getText());
    }

    public void clickHomeButton(){
        By HomeButtonLoc = TamimiLocators.getHomePageLocator("homeIcon");
        WebElement HomeBtn = driver.findElement(HomeButtonLoc);
        HomeBtn.click();
    }
    public boolean verifyProduct(){
        String ProductBeforeAddName=Product.get("ProductBeforeAddName");
        ProductBeforeAddName=ProductBeforeAddName.replace(" ", "");
        String ProductAfterAddName=Product.get("ProductAfterAddName");
        ProductAfterAddName=ProductAfterAddName.replace(" ", "");
        String ProductBeforeAddPrice=Product.get("ProductBeforeAddPrice");
        ProductBeforeAddPrice=ProductBeforeAddPrice.replace(" ", "");
        String ProductAfterAddPrice=Product.get("ProductAfterAddPrice");
        ProductAfterAddPrice=ProductAfterAddPrice.replace(" ", "");
        return ProductBeforeAddName.equals(ProductAfterAddName) && ProductBeforeAddPrice.equals(ProductAfterAddPrice);
    }

    public void addToCartFlow(){
        HomePageTamimi homePageTamimi =new HomePageTamimi(driver, wait);
        homePageTamimi.clickHomeButton();
        homePageTamimi.clickFruitsAndVegetables();
        homePageTamimi.clickAddButton();
        homePageTamimi.clickCartButton();

    }
}
