package com.zs.pages.vijetha;

import com.zs.locators.TamimiLocators;
import com.zs.locators.VijethaLocators;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class HomePageVijetha {
    public static Map<String, String> Product = new HashMap<>();
    private static  IOSDriver driver;
    private final WebDriverWait wait;
    static String productText;

    public HomePageVijetha(IOSDriver CurrentDriver, WebDriverWait wait){
        driver =CurrentDriver;
        this.wait=wait;
    }
    public void clickVegetablesButton(){
        By VegetablesLoc = VijethaLocators.getHomePageLocator("department");
        WebElement VegetablesBtn = driver.findElement(VegetablesLoc);
        VegetablesBtn.click();
        By ProductButtonLoc = VijethaLocators.getProductPageLocators("product");
        WebElement Product = driver.findElement(ProductButtonLoc);
        productText = Product.getText();
    }

    public void clickAddButton(){

        By AddLoc = VijethaLocators.getProductPageLocators("addButton");
        WebElement AddBtn = driver.findElement(AddLoc);
        AddBtn.click();
    }
    public void clickBackButton(){
        By BackLoc = VijethaLocators.getProductPageLocators("backButton");
        WebElement  BackBtn = driver.findElement(BackLoc);
        BackBtn.click();
    }
    public void clickViewCartButton() throws InterruptedException {
        By ViewCartLoc = VijethaLocators.getHomePageLocator("viewCart");
        WebElement ViewCartBtn = driver.findElement(ViewCartLoc);
        ViewCartBtn.click();
        By ProductNameAfterAddLoc = VijethaLocators.getCartPageLocator("ProductNameAfterAdd");
        WebElement productNameAfterAdd = driver.findElement(ProductNameAfterAddLoc);
        Product.put("ProductAfterAddName", productNameAfterAdd.getText());
        By ProductPriceAfterAddLoc = VijethaLocators.getCartPageLocator("ProductPriceAfterAdd");
        WebElement productPriceAfterAdd = driver.findElement(ProductPriceAfterAddLoc);
        Product.put("ProductAfterAddPrice", productPriceAfterAdd.getText());
    }
    public void clickHomeButton(){
        By HomeButtonLoc = VijethaLocators.getHomePageLocator("homeIcon");
        WebElement HomeBtn = driver.findElement(HomeButtonLoc);
        HomeBtn.click();
    }
    public void clickProduct() throws InterruptedException {
        By ProductButtonLoc = VijethaLocators.getProductPageLocators("product");
        WebElement ProductBtn = driver.findElement(ProductButtonLoc);
        ProductBtn.click();
        By ProductBeforeAddLoc = VijethaLocators.getProductPageLocators("ProductNameBeforeAdd");
        WebElement productBeforeAdd = driver.findElement(ProductBeforeAddLoc);
        Product.put("ProductBeforeAddName", productBeforeAdd.getText());
        By ProductPriceBeforeAddLoc = VijethaLocators.getProductPageLocators("ProductPriceBeforeAdd");
        WebElement productPriceBeforeAdd = driver.findElement(ProductPriceBeforeAddLoc);
        Product.put("ProductBeforeAddPrice", productPriceBeforeAdd.getText());
    }
    public void clickOptionButton(){
        By OptionButtonLoc = VijethaLocators.getProductPageLocators("optionButton");
        WebElement OptionBtn = driver.findElement(OptionButtonLoc);
        OptionBtn.click();
    }
    public void clickCancelButton(){
        By CancelButtonLoc = VijethaLocators.getProductPageLocators("cancelButton");
        WebElement CancelBtn = driver.findElement(CancelButtonLoc);
        CancelBtn.click();
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
    public void addToCartFlow() throws InterruptedException {
        HomePageVijetha homePageVijetha =new HomePageVijetha(driver, wait);
        homePageVijetha.clickHomeButton();
        homePageVijetha.clickVegetablesButton();
        homePageVijetha.clickProduct();
        homePageVijetha.clickOptionButton();
        homePageVijetha.clickAddButton();
        homePageVijetha.clickCancelButton();
        homePageVijetha.clickViewCartButton();
    }
}
