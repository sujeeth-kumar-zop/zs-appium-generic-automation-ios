package com.zs.pages.common;

import com.zs.locators.TamimiLocators;
import com.zs.utils.CommonUtils;
import com.zs.utils.LoggerUtil;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

/**
 * Class which contains all the functions which perform operation related to checkout
 */

public class CheckOut {
    private static IOSDriver driver;
    private final WebDriverWait wait;

    /**
     * Constructor that initialises IOSDriver and WebDriverWait
     * @param CurrentDriver Current IOSDriver on which test cases will run
     * @param wait WebDriverWait variable used to initialise wait variable of the class
     */

    public CheckOut(IOSDriver CurrentDriver, WebDriverWait wait) {
        driver = CurrentDriver;
        this.wait = wait;
    }

    /**
     * Function used to click Select Substitution Button and Select "Call for Substitution" option
     * @param appName takes appName as the parameter and decides on which particular application clickSelectSubstitutionBtn function should be executed
     */

    public void clickSelectSubstitutionBtn(String appName){
        By selectSubstitutionBtnLoc = CommonUtils.getProductPageLocators(appName, "SelectSubstitution");
        WebElement selectSubstitutionBtn = driver.findElement(selectSubstitutionBtnLoc);
        selectSubstitutionBtn.click();
        By callForSubstitutionBtnLoc = CommonUtils.getProductPageLocators(appName, "CallForSubstitution");
        WebElement callForSubstitutionBtn = driver.findElement(callForSubstitutionBtnLoc);
        callForSubstitutionBtn.click();
    }

    /**
     * Function used to click Back Button
     */

    public void clickBackButton(){
        By BackButtonLoc = TamimiLocators.getCartPageLocators("BackButton");
        WebElement BackButtonBtn = driver.findElement(BackButtonLoc);
        BackButtonBtn.click();
    }

    /**
     * Function used to click Checkout Button
     * @param appName takes appName as the parameter and decides on which particular application clickCheckOutBtn function should be executed
     */

    public void clickCheckOutBtn(String appName){
        By checkOutBtnLoc = CommonUtils.getProductPageLocators(appName, "CheckOut");
        WebElement checkOutBtn = driver.findElement(checkOutBtnLoc);
        checkOutBtn.click();
        By AlertMessage = CommonUtils.getProductPageLocators(appName, "AlertMessage");
        List<WebElement> elements = driver.findElements(AlertMessage);
        while (!elements.isEmpty()) {
            By AlertOkLoc = CommonUtils.getProductPageLocators(appName, "AlertOk");
            WebElement alertOkBtn = driver.findElement(AlertOkLoc);
            alertOkBtn.click();
            checkOutBtn.click();
            elements = driver.findElements(AlertMessage);
        }
    }

    /**
     * Function used to scroll the page till the end
     */

    public void scrollToEnd() {
        Dimension dimension = driver.manage().window().getSize();

        int startX = dimension.width / 2;  // Middle of the screen horizontally
        int startY = (int) (dimension.height * 0.8); // Start swipe from near the bottom
        int endY = (int) (dimension.height * 0.2);   // End swipe near the top

        // Set up PointerInput for touch gestures
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        // Add press, move, and release actions
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), startX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Perform the gesture
        driver.perform(List.of(swipe));
    }

    /**
     * Function used to click Debit Card radio button and Select a particular Debit Card from the available options
     * @param appName takes appName as the parameter and decides on which particular application debitCardSelection function should be executed
     */

    public void debitCardSelection(String appName){
        By debitCardLoc = CommonUtils.getProductPageLocators(appName, "DebitCard");
        WebElement debitCardBtn = driver.findElement(debitCardLoc);
        debitCardBtn.click();
        By cardSelectionLoc = CommonUtils.getProductPageLocators(appName, "CardSelection");
        WebElement cardSelectionBtn = driver.findElement(cardSelectionLoc);
        cardSelectionBtn.click();
    }

    /**
     * Function used to click Cash on Delivery Radio Button
     * @param appName takes appName as the parameter and decides on which particular application CashOnDeliverySelection function should be executed
     */

    public void CashOnDeliverySelection(String appName){
        By CODLoc = CommonUtils.getProductPageLocators(appName, "COD");
        WebElement CODBtn = driver.findElement(CODLoc);
        CODBtn.click();
    }

    /**
     * Function used to click Place Order Button
     * @param appName takes appName as the parameter and decides on which particular application clickPlaceOrder function should be executed
     */

    public void clickPlaceOrder(String appName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        long startTime = System.currentTimeMillis();
        wait.until(driver1 -> (System.currentTimeMillis() - startTime) >= 3000);
        By placeOrderLoc = CommonUtils.getProductPageLocators(appName, "PlaceOrder");
        WebElement placeOrderBtn = driver.findElement(placeOrderLoc);
        placeOrderBtn.click();
    }

    /**
     * Function used to assert Checkout Test Cases
     * Verifies if the Order is placed successfully
     * @param appName takes appName as the parameter and decides on which particular application verifyCheckOut function should be executed
     * @return returns boolean value "true" if the Checkout is Successful and boolean value "false" if the Checkout fails
     */

    public boolean verifyCheckOut(String appName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        long startTime = System.currentTimeMillis();
        wait.until(driver1 -> (System.currentTimeMillis() - startTime) >= 3000);
        By orderPlacedLoc = CommonUtils.getProductPageLocators(appName,"SuccessOrderPlace");
        WebElement oderPlaced = driver.findElement(orderPlacedLoc);
        String orderPlacedMessage = oderPlaced.getText();
        if(orderPlacedMessage.contains("Order placed successfully")){
            LoggerUtil.logInfo("Check Out Test Case Completed Successfully for " + appName);
            return true;
        }
        return false;
    }

    /**
     * Function which control the checkOut using Debit Card Test case Flow
     * @param appName takes appName as the parameter and decides on which particular application checkOutFlowDebitCard function should be executed
     */

    public void checkOutFlowDebitCard(String appName) {
        LoggerUtil.logInfo("Check Out Using Debit Card Test Case Started for " + appName);
        CheckOut checkOut = new CheckOut(driver, wait);
        checkOut.clickCheckOutBtn(appName);
        LoggerUtil.logInfo("Check Out Button Clicked");
        checkOut.scrollToEnd();
        LoggerUtil.logInfo("Scroll down for Selection of Payment Method done");
        checkOut.debitCardSelection(appName);
        LoggerUtil.logInfo("Debit Card Selected");
        checkOut.clickPlaceOrder(appName);
        LoggerUtil.logInfo("Place Order Button Clicked");
    }

    /**
     * Function which control the checkOut using Cash on Collection/Cash on Delivery Test case Flow
     * @param appName takes appName as the parameter and decides on which particular application checkOutFlowCOD function should be executed
     */

    public void checkOutFlowCOD(String appName) {
        LoggerUtil.logInfo("Check Out using COD Test Case Started for " + appName);
        CheckOut checkOut = new CheckOut(driver, wait);
        checkOut.clickSelectSubstitutionBtn(appName);
        LoggerUtil.logInfo("Selection for Substitution Completed");
        checkOut.clickCheckOutBtn(appName);
        LoggerUtil.logInfo("Check Out Button Clicked");
        checkOut.scrollToEnd();
        LoggerUtil.logInfo("Scroll down for Selection of Payment Method done");
        checkOut.CashOnDeliverySelection(appName);
        LoggerUtil.logInfo("Debit Card Selected");
        checkOut.clickPlaceOrder(appName);
        LoggerUtil.logInfo("Place Order Button Clicked");
    }
}
