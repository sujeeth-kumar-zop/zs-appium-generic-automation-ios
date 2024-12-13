package com.zs.pages.common;

import com.zs.constants.Constants;
import com.zs.utils.CommonUtils;
import com.zs.utils.LoggerUtil;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static com.zs.locators.VijethaLocators.getLoginLocator;

/**
 * Class which contains all the functions which perform operation in Login Page
 */

public class LoginPage {
    private static IOSDriver driver;
    private final WebDriverWait wait;

    /**
     * Constructor that initialises IOSDriver and WebDriverWait
     * @param CurrentDriver Current IOSDriver on which test cases will run
     * @param wait WebDriverWait variable used to initialise wait variable of the class
     */

    public LoginPage(IOSDriver CurrentDriver, WebDriverWait wait){
        driver =CurrentDriver;
        this.wait=wait;
    }

    /**
     * Function used to click Profile Icon Button
     * @param appName takes appName as the parameter and decides on which particular application clickOnProfileIcon function should be executed
     */

    public void clickOnProfileIcon(String appName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        long startTime = System.currentTimeMillis();
        wait.until(driver1 -> (System.currentTimeMillis() - startTime) >= 3000);
        By profileIconLoc = CommonUtils.getLoginLocator(appName, "profileIcon");
        WebElement profileIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(profileIconLoc));
        profileIcon.click();
    }

    /**
     * Function used to Enter Phone Number in the "Enter Email or Phone Number" text box
     * @param appName takes appName as the parameter and decides on which particular application enterPhNo function should be executed
     * @param username takes String username as the parameter which contains Phone number or Email that is entered in the "Enter Email or Phone Number" text box
     */

    public void enterPhNo(String username, String appName){

        By phnoTextBoxLoc = CommonUtils.getLoginLocator(appName, "enterEmailOrPhoneTextBox");
        WebElement phnoTextBox= driver.findElement(phnoTextBoxLoc);
        wait.until(ExpectedConditions.visibilityOf(phnoTextBox)).sendKeys(username);
    }

    /**
     * Function used to click LoginWithPassword Button for Vijetha
     */

    public void clickLoginWithPassword(){
        By loginWithPasswordLoc = getLoginLocator("logInWithPassword");
        WebElement loginWithPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(loginWithPasswordLoc));
        loginWithPassword.click();
    }

    /**
     * Function used to Enter Password in the "Enter password" text box
     * @param appName takes appName as the parameter and decides on which particular application enterPassword function should be executed
     * @param password takes String password as the parameter which contains password that is entered in the "Enter password" text box
     */

    public void enterPassword(String password, String appName){

        By passTextBoxLoc = CommonUtils.getLoginLocator(appName, "enterPasswordTextBox");
        WebElement passTextBox= driver.findElement(passTextBoxLoc);
        wait.until(ExpectedConditions.visibilityOf(passTextBox)).sendKeys(password);
    }

    /**
     * Function used click Login button
     * @param appName takes appName as the parameter and decides on which particular application clickLoginBtn function should be executed
     */

    public void clickLoginBtn(String appName){

        By loginBtnLoc = CommonUtils.getLoginLocator(appName, "loginBtn");
        WebElement loginBtn = driver.findElement(loginBtnLoc);
        loginBtn.click();
    }

    /**
     * Function used to Handle the popups that appear once the app is installed and starts running
     * @param appName takes appName as the parameter and decides on which particular application handlePopUp function should be executed
     */

    public static void handlePopUp(String appName){
        int loop = switch (appName) {
            case Constants.TAMIMI -> 3;
            case Constants.VIJETHA -> 2;
            default -> -1;
        };
        for(int i=0; i<loop; i++) {
            try {
                WebDriverWait waitAlert = new WebDriverWait(driver, Duration.ofSeconds(30));
                waitAlert.until(ExpectedConditions.alertIsPresent());
                driver.switchTo().alert().accept();
            } catch (Exception e) {
                System.out.println("Alert not present within the timeout");
            }
        }
    }

    /**
     * Function which control the flow of Login Test case
     * @param appName takes appName as the parameter and decides on which particular application loginFlow function should be executed
     */

    public void loginFlow(String password, String username, String appName){
        LoggerUtil.logInfo("Login Test Case Started for " + appName);
        LoginPage loginPage =new LoginPage(driver, wait);
        loginPage.clickOnProfileIcon(appName);
        LoggerUtil.logInfo("Profile Icon Clicked");
        if(appName.equals(Constants.VIJETHA)){
            loginPage.clickLoginWithPassword();
            LoggerUtil.logInfo("Login with PassWord clicked");

        }
        loginPage.enterPhNo(username, appName);
        LoggerUtil.logInfo("Phone number entered");
        loginPage.enterPassword(password, appName);
        LoggerUtil.logInfo("PassWord entered");
        loginPage.clickLoginBtn(appName);
        LoggerUtil.logInfo("Login Button Clicked");
        loginPage.clickOnProfileIcon(appName);
        LoggerUtil.logInfo("Login Test Case Completed Successfully for " + appName);
    }

}
