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

public class CheckOut {
    private static IOSDriver driver;
    private final WebDriverWait wait;

    public CheckOut(IOSDriver CurrentDriver, WebDriverWait wait) {
        driver = CurrentDriver;
        this.wait = wait;
    }

    public void clickSelectSubstitutionBtn(String appName){
        By selectSubstitutionBtnLoc = CommonUtils.getProductPageLocators(appName, "SelectSubstitution");
        WebElement selectSubstitutionBtn = driver.findElement(selectSubstitutionBtnLoc);
        selectSubstitutionBtn.click();
        By callForSubstitutionBtnLoc = CommonUtils.getProductPageLocators(appName, "CallForSubstitution");
        WebElement callForSubstitutionBtn = driver.findElement(callForSubstitutionBtnLoc);
        callForSubstitutionBtn.click();
    }

    public void clickBackButton(){
        By BackButtonLoc = TamimiLocators.getCartPageLocators("BackButton");
        WebElement BackButtonBtn = driver.findElement(BackButtonLoc);
        BackButtonBtn.click();
    }

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

    public void scrollToEnd(String appName) {
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

    public void debitCardSelection(String appName){
        By debitCardLoc = CommonUtils.getProductPageLocators(appName, "DebitCard");
        WebElement debitCardBtn = driver.findElement(debitCardLoc);
        debitCardBtn.click();
        By cardSelectionLoc = CommonUtils.getProductPageLocators(appName, "CardSelection");
        WebElement cardSelectionBtn = driver.findElement(cardSelectionLoc);
        cardSelectionBtn.click();
    }

    public void CashOnDeliverySelection(String appName){
        By CODLoc = CommonUtils.getProductPageLocators(appName, "COD");
        WebElement CODBtn = driver.findElement(CODLoc);
        CODBtn.click();
    }

    public void clickPlaceOrder(String appName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        long startTime = System.currentTimeMillis();
        wait.until(driver1 -> (System.currentTimeMillis() - startTime) >= 3000);
        By placeOrderLoc = CommonUtils.getProductPageLocators(appName, "PlaceOrder");
        WebElement placeOrderBtn = driver.findElement(placeOrderLoc);
        placeOrderBtn.click();
    }
    public boolean verifyPlaceOrder(String appName){
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

    public void checkOutFlow(String appName) {
        LoggerUtil.logInfo("Check Out Using Debit Card Test Case Started for " + appName);
        CheckOut checkOut = new CheckOut(driver, wait);
        checkOut.clickSelectSubstitutionBtn(appName);
        LoggerUtil.logInfo("Selection for Substitution Completed");
        checkOut.clickCheckOutBtn(appName);
        LoggerUtil.logInfo("Check Out Button Clicked");
        checkOut.scrollToEnd(appName);
        LoggerUtil.logInfo("Scroll down for Selection of Payment Method done");
        checkOut.debitCardSelection(appName);
        LoggerUtil.logInfo("Debit Card Selected");
        checkOut.clickPlaceOrder(appName);
        LoggerUtil.logInfo("Place Order Button Clicked");
    }

    public void checkOutFlowCOD(String appName) {
        LoggerUtil.logInfo("Check Out using COD Test Case Started for " + appName);
        CheckOut checkOut = new CheckOut(driver, wait);
        checkOut.clickCheckOutBtn(appName);
        LoggerUtil.logInfo("Check Out Button Clicked");
        checkOut.scrollToEnd(appName);
        LoggerUtil.logInfo("Scroll down for Selection of Payment Method done");
        checkOut.CashOnDeliverySelection(appName);
        LoggerUtil.logInfo("Debit Card Selected");
        checkOut.clickPlaceOrder(appName);
        LoggerUtil.logInfo("Place Order Button Clicked");
    }
}
