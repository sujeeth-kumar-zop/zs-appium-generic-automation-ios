package com.zs.pages.common;

import com.zs.pages.tamimi.LoginPageTamimi;
import com.zs.pages.vijetha.LoginPageVijetha;
import com.zs.utils.CommonUtils;
import com.zs.utils.LoggerUtil;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private static IOSDriver driver;
    private final WebDriverWait wait;

    public LoginPage(IOSDriver CurrentDriver, WebDriverWait wait){
        driver =CurrentDriver;
        this.wait=wait;
    }

    public void clickOnProfileIcon(String appName){
        By profileIconLoc = CommonUtils.getLoginLocator(appName, "profileIcon");
        WebElement profileIcon = wait.until(ExpectedConditions.visibilityOfElementLocated(profileIconLoc));
        profileIcon.click();
    }

    public void enterPhNo(String username, String appName){

        By phnoTextBoxLoc = CommonUtils.getLoginLocator(appName, "enterEmailOrPhoneTextBox");
        WebElement phnoTextBox= driver.findElement(phnoTextBoxLoc);
        wait.until(ExpectedConditions.visibilityOf(phnoTextBox)).sendKeys(username);
    }

    public void enterPassword(String password, String appName){

        By passTextBoxLoc = CommonUtils.getLoginLocator(appName, "enterPasswordTextBox");
        WebElement passTextBox= driver.findElement(passTextBoxLoc);
        wait.until(ExpectedConditions.visibilityOf(passTextBox)).sendKeys(password);
    }

    public void clickLoginBtn(String appName){

        By loginBtnLoc = CommonUtils.getLoginLocator(appName, "loginBtn");
        WebElement loginBtn = driver.findElement(loginBtnLoc);
        loginBtn.click();
    }

    public static void handlePopUp(String appName){
        int loop = switch (appName) {
            case "Tamimi" -> 3;
            case "Vijetha" -> 2;
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

    public void loginFlow(String password, String username, String appName){
        LoggerUtil.logInfo("Login Test Case Started for " + appName);
        LoginPage loginPage =new LoginPage(driver, wait);
        LoginPageVijetha loginPageVijetha =new LoginPageVijetha(wait);
        LoginPageTamimi loginPageTamimi =new LoginPageTamimi(wait);
        loginPage.clickOnProfileIcon(appName);
        LoggerUtil.logInfo("Profile Icon Clicked");
        if(appName.equals("Vijetha")){
            loginPageVijetha.clickLoginWithPassword();
            LoggerUtil.logInfo("Login with PassWord clicked");

        }
        loginPage.enterPhNo(username, appName);
        LoggerUtil.logInfo("Phone number entered");
        loginPage.enterPassword(password, appName);
        LoggerUtil.logInfo("PassWord entered");
        loginPage.clickLoginBtn(appName);
        LoggerUtil.logInfo("Login Button Clicked");
        if(appName.equals("Tamimi")){
            loginPageTamimi.clickNotNow();
            LoggerUtil.logInfo("Not Now Button Clicked");
        }
        loginPage.clickOnProfileIcon(appName);
        LoggerUtil.logInfo("Login Test Case Completed Successfully for " + appName);
    }

}
