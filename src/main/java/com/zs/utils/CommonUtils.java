package com.zs.utils;

import com.zs.constants.Constants;
import com.zs.locators.TamimiLocators;
import com.zs.locators.VijethaLocators;
import org.openqa.selenium.By;

/**
 * Class which contains all the functions which return the locators of the particular application
 */

public class CommonUtils{

    /**
     * Function which returns the locators of Profile Page
     * @param appName takes appName as the parameter and decides which particular application's locator is to be returned
     * @param key contains the name of the locator
     * @return returns the locator
     */

    public static By getProfileLocator(String appName, String key){
        return switch (appName){
            case Constants.TAMIMI -> TamimiLocators.getProfileLocators(key);
            case Constants.VIJETHA -> VijethaLocators.getProfileLocators(key);
            default -> throw new IllegalArgumentException("Invalid app name: " + appName);
        };
    }

    /**
     * Function which returns the locators of Login Page
     * @param appName takes appName as the parameter and decides which particular application's locator is to be returned
     * @param key contains the name of the locator
     * @return returns the locator
     */

    public static By getLoginLocator(String appName, String key){
        return switch (appName){
            case Constants.TAMIMI -> TamimiLocators.getLoginLocator(key);
            case Constants.VIJETHA -> VijethaLocators.getLoginLocator(key);
            default -> throw new IllegalArgumentException("Invalid app name: " + appName);
        };
    }

    /**
     * Function which returns the locators of Home Page
     * @param appName takes appName as the parameter and decides which particular application's locator is to be returned
     * @param key contains the name of the locator
     * @return returns the locator
     */

    public static By getHomePageLocator(String appName, String key){
        return switch (appName){
            case Constants.TAMIMI -> TamimiLocators.getHomePageLocator(key);
            case Constants.VIJETHA -> VijethaLocators.getHomePageLocator(key);
            default -> throw new IllegalArgumentException("Invalid app name: " + appName);
        };
    }

    /**
     * Function which returns the locators of Department Page
     * @param appName takes appName as the parameter and decides which particular application's locator is to be returned
     * @param key contains the name of the locator
     * @return returns the locator
     */

    public static By getDepartmentPageLocators(String appName, String key){
        return switch (appName){
            case Constants.TAMIMI -> TamimiLocators.getDepartmentLocator(key);
            default -> throw new IllegalArgumentException("Invalid app name: " + appName);
        };
    }

    /**
     * Function which returns the locators of Search Page
     * @param appName takes appName as the parameter and decides which particular application's locator is to be returned
     * @param key contains the name of the locator
     * @return returns the locator
     */

    public static By getSearchPageLocators(String appName, String key){
        return switch (appName){
            case Constants.TAMIMI -> TamimiLocators.getSearchPageLocator(key);
            case Constants.VIJETHA -> VijethaLocators.getSearchPageLocator(key);
            default -> throw new IllegalArgumentException("Invalid app name: " + appName);
        };
    }

    /**
     * Function which returns the locators of ProductList
     * @param appName takes appName as the parameter and decides which particular application's locator is to be returned
     * @param key contains the name of the locator
     * @return returns the locator
     */

    public static By getProductListsLocators(String appName, String key){
        return switch (appName){
            case Constants.TAMIMI -> TamimiLocators.getProductListsLocator(key);
            case Constants.VIJETHA -> VijethaLocators.getProductListsLocator(key);
            default -> throw new IllegalArgumentException("Invalid app name: " + appName);
        };
    }

    /**
     * Function which returns the locators of Product Page
     * @param appName takes appName as the parameter and decides which particular application's locator is to be returned
     * @param key contains the name of the locator
     * @return returns the locator
     */

    public static By getProductPageLocators(String appName, String key){
        return switch (appName){
            case Constants.TAMIMI -> TamimiLocators.getProductPageLocators(key);
            case Constants.VIJETHA -> VijethaLocators.getProductPageLocators(key);
            default -> throw new IllegalArgumentException("Invalid app name: " + appName);
        };
    }

    /**
     * Function which returns the locators of Cart Page
     * @param appName takes appName as the parameter and decides which particular application's locator is to be returned
     * @param key contains the name of the locator
     * @return returns the locator
     */

    public static By getCartPageLocators(String appName, String key){
        return switch (appName){
            case Constants.VIJETHA -> VijethaLocators.getCartPageLocator(key);
            default -> throw new IllegalArgumentException("Invalid app name: " + appName);
        };
    }
}