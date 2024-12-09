package com.zs.pages.common;

import com.zs.locators.TamimiLocators;
import com.zs.locators.VijethaLocators;
import com.zs.utils.CommonUtils;
import com.zs.utils.LoggerUtil;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


import java.time.Duration;

public class CartPage {
    private static IOSDriver driver;
    private static WebDriverWait wait = null;

    public CartPage(IOSDriver CurrentDriver, WebDriverWait wait) {
        driver = CurrentDriver;
        CartPage.wait = wait;
    }

    public void clickHomeButton(String appName){
        By HomeButtonLoc = CommonUtils.getSearchPageLocators(appName,"homeIcon");
        WebElement HomeBtn = driver.findElement(HomeButtonLoc);
        HomeBtn.click();
    }
    public void clickOkay(String appName){
        By OkayButtonLoc = CommonUtils.getProductPageLocators(appName,"OkayButton");
        WebElement OkayBtn = driver.findElement(OkayButtonLoc);
        OkayBtn.click();
    }
    public void clickCartButton(String appName){
        switch (appName){
            case "Tamimi":
                By CartButtonLoc = TamimiLocators.getDepartmentLocator("CartButton");
                WebElement CartBtn = driver.findElement(CartButtonLoc);
                CartBtn.click();
                break;
            case "Vijetha":
                By ViewCartLoc = VijethaLocators.getHomePageLocator("viewCart");
                WebElement ViewCartBtn = driver.findElement(ViewCartLoc);
                ViewCartBtn.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid app name: " + appName);
        }
    }
    public void clickIncrementButton(String appName) throws InterruptedException {
        switch (appName) {
            case "Tamimi":
                for (int i = 0; i < 19; i++) {
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
                    By incrementLoc = CommonUtils.getProductPageLocators(appName, "ProductIncrement");
                    WebElement IncrementBtn = wait.until(ExpectedConditions.elementToBeClickable(incrementLoc));
                    IncrementBtn.click();
                }
                break;
            case "Vijetha":
                CartPage cartPage = new CartPage(driver, wait);
                By IncrementButtonLoc = CommonUtils.getProductPageLocators(appName,"IncrementProduct");
                //Thread.sleep(5000);
                By PlaceOrderLoc = CommonUtils.getCartPageLocators(appName,"PlaceOrder");
                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(PlaceOrderLoc));
                WebElement IncrementBtn = wait.until(ExpectedConditions.elementToBeClickable(IncrementButtonLoc));
                IncrementBtn.click();
                PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
                Sequence swipe = new Sequence(finger, 0);

// Define start and end points
                int startX = 200;
                int startY = 470;
                int endX = 200;
                int endY = 420;

// Add actions to the sequence
                swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY)); // Move to start point
                swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));                        // Press down
                swipe.addAction(finger.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), endX, endY)); // Move to end point
                swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));                          // Release

// Perform the action
                driver.perform(List.of(swipe));
                cartPage.clickOkay(appName);

        }
    }

    public void incrementProductFlow(String appName) throws InterruptedException {
        LoggerUtil.logInfo("Increment Product Count in Cart Test Case Started for " + appName);
        CartPage cartPage = new CartPage(driver, wait);
        SearchPage searchPage =new SearchPage(driver, wait);
        searchPage.clickCancelButton(appName);
        if(appName.equals("Vijetha")){
            Dimension screenSize = driver.manage().window().getSize();
            int centerX = screenSize.width / 2;
            int centerY = screenSize.height / 2;

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence tap = new Sequence(finger, 0)
                    .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, centerY))
                    .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                    .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(List.of(tap));
            cartPage.clickHomeButton(appName);
        }
        cartPage.clickCartButton(appName);
        LoggerUtil.logInfo("Cart Button Clicked");
        cartPage.clickIncrementButton(appName);
        LoggerUtil.logInfo("Product Incremented");
    }
    public boolean verifyIncrement(String appName){
        By ProductQuantityLoc = CommonUtils.getProductPageLocators(appName,"ProductQuantity");
        WebElement productQuantity = driver.findElement(ProductQuantityLoc);
        String ProductQuantity = productQuantity.getText();
        int quantity=Integer.parseInt(ProductQuantity);
        if(quantity > 1){
            LoggerUtil.logInfo("Increment Product Count in Cart Test Case Completed Successfully for " + appName);
            return true;
        }
        return false;
    }
}
