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

/**
 * Class which contains all the functions which perform operation in Cart Page
 */

public class CartPage {
    private static IOSDriver driver;
    private static WebDriverWait wait = null;

    /**
     * Constructor that initialises IOSDriver and WebDriverWait
     * @param CurrentDriver Current IOSDriver on which test cases will run
     * @param wait WebDriverWait variable used to initialise wait variable of the class
     */

    public CartPage(IOSDriver CurrentDriver, WebDriverWait wait) {
        driver = CurrentDriver;
        CartPage.wait = wait;
    }

    /**
     * Function used to click Home Button
     * @param appName takes appName as the parameter and decides on which particular application clickHomeButton function should be executed
     */

    public void clickHomeButton(String appName){
        By HomeButtonLoc = CommonUtils.getSearchPageLocators(appName,"homeIcon");
        WebElement HomeBtn = driver.findElement(HomeButtonLoc);
        HomeBtn.click();
    }

    /**
     * Function used to click Okay Button
     * @param appName takes appName as the parameter and decides on which particular application clickOkay function should be executed
     */

    public void clickOkay(String appName){
        By OkayButtonLoc = CommonUtils.getProductPageLocators(appName,"OkayButton");
        WebElement OkayBtn = driver.findElement(OkayButtonLoc);
        OkayBtn.click();
    }

    /**
     * Function used to click Cart Button
     * @param appName takes appName as the parameter and decides on which particular application clickCartButton function should be executed
     */

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

    /**
     * Function used to click Increment Button
     * This Function increment the quantity of the product that is added in the cart
     * @param appName takes appName as the parameter and decides on which particular application clickIncrementButton function should be executed
     */

    public void clickIncrementButton(String appName){
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
                By PlaceOrderLoc = CommonUtils.getCartPageLocators(appName,"PlaceOrder");
                WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(PlaceOrderLoc));
                WebElement IncrementBtn = wait.until(ExpectedConditions.elementToBeClickable(IncrementButtonLoc));
                IncrementBtn.click();
                PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
                Sequence swipe = new Sequence(finger, 0);

                int startX = 200;
                int startY = 470;
                int endX = 200;
                int endY = 420;

                swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY)); // Move to start point
                swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));                        // Press down
                swipe.addAction(finger.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), endX, endY)); // Move to end point
                swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));                          // Release

                driver.perform(List.of(swipe));
                cartPage.clickOkay(appName);

        }
    }

    /**
     * Function which control the flow of Increment product quantity in the cart Test case
     * @param appName takes appName as the parameter and decides on which particular application incrementProductFlow function should be executed
     */

    public void incrementProductFlow(String appName){
        LoggerUtil.logInfo("Increment Product Count in Cart Test Case Started for " + appName);
        CartPage cartPage = new CartPage(driver, wait);
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

    /**
     * Function use to assert Increment product quantity in the cart Test case
     * It checks if the quantity of the product is increased in the Cart
     * @param appName takes appName as the parameter and decides on which particular application verifyIncrement function should be executed
     * @return returns boolean value "true" if the quantity of the product is increased in the Cart or else returns boolean value "false" if the quantity of the product in the Cart is not incremented
     */

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
