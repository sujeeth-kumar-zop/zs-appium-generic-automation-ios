package com.zs.utils;

import com.zs.constants.Constants;
import com.zs.locators.TamimiLocators;
import com.zs.locators.VijethaLocators;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;


public class CommonUtils{

    private final IOSDriver driver;

    private final WebDriverWait wait;

    public CommonUtils(IOSDriver driver, WebDriverWait wait){
        this.driver =driver;
        this.wait=wait;
    }

    public static By getProfileLocator(String appName, String key){
        return switch (appName){
            case Constants.TAMIMI -> TamimiLocators.getProfileLocators(key);
            case Constants.VIJETHA -> VijethaLocators.getProfileLocators(key);
            default -> throw new IllegalArgumentException("Invalid app name: " + appName);
        };
    }

    public static By getLoginLocator(String appName, String key){
        return switch (appName){
            case Constants.TAMIMI -> TamimiLocators.getLoginLocator(key);
            case Constants.VIJETHA -> VijethaLocators.getLoginLocator(key);
            default -> throw new IllegalArgumentException("Invalid app name: " + appName);
        };
    }

    public static By getHomePageLocator(String appName, String key){
        return switch (appName){
            case Constants.TAMIMI -> TamimiLocators.getHomePageLocator(key);
            case Constants.VIJETHA -> VijethaLocators.getHomePageLocator(key);
            default -> throw new IllegalArgumentException("Invalid app name: " + appName);
        };
    }

    public static By getDepartmentPageLocators(String appName, String key){
        return switch (appName){
            case Constants.TAMIMI -> TamimiLocators.getDepartmentLocator(key);
            default -> throw new IllegalArgumentException("Invalid app name: " + appName);
        };
    }

    public static By getSearchPageLocators(String appName, String key){
        return switch (appName){
            case Constants.TAMIMI -> TamimiLocators.getSearchPageLocator(key);
            case Constants.VIJETHA -> VijethaLocators.getSearchPageLocator(key);
            default -> throw new IllegalArgumentException("Invalid app name: " + appName);
        };
    }

    public static By getProductListsLocators(String appName, String key){
        return switch (appName){
            case Constants.TAMIMI -> TamimiLocators.getProductListsLocator(key);
            case Constants.VIJETHA -> VijethaLocators.getProductListsLocator(key);
            default -> throw new IllegalArgumentException("Invalid app name: " + appName);
        };
    }

    public static By getProductPageLocators(String appName, String key){
        return switch (appName){
            case Constants.TAMIMI -> TamimiLocators.getProductListsLocator(key);
            case Constants.VIJETHA -> VijethaLocators.getProductListsLocator(key);
            default -> throw new IllegalArgumentException("Invalid app name: " + appName);
        };
    }

    public static By getCartPageLocators(String appName, String key){
        return switch (appName){
            case Constants.VIJETHA -> VijethaLocators.getCartPageLocator(key);
            default -> throw new IllegalArgumentException("Invalid app name: " + appName);
        };
    }

}