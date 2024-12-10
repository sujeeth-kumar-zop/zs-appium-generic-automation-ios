package com.zs.locators;

import org.openqa.selenium.By;
import java.util.HashMap;
import java.util.Map;

public class VijethaLocators {

    public static final Map<String, By> loginLocators = new HashMap<>();
    public static final Map<String,By> homePageLocators=new HashMap<>();
    public static final Map<String,By> profileLocators=new HashMap<>();
    public static final Map<String,By> productPageLocators =new HashMap<>();
    public static final Map<String, By> searchPageLocators=new HashMap<>();
    public static final Map<String, By> productListsLocators=new HashMap<>();
    public static final Map<String, By> cartPageLocators=new HashMap<>();
    static {


        //login page locators
        loginLocators.put("profileIcon", By.xpath("//XCUIElementTypeButton[@name='account_moonshot']"));
        loginLocators.put("logInWithPassword", By.xpath("//XCUIElementTypeStaticText[@name='Login with Password']"));
        loginLocators.put("enterEmailOrPhoneTextBox", By.xpath("//XCUIElementTypeTextField[@value='Enter your email or phone number']"));
        loginLocators.put("enterPasswordTextBox", By.xpath("//XCUIElementTypeSecureTextField[@value='Enter password']"));
        loginLocators.put("loginBtn", By.xpath("//XCUIElementTypeButton[@name='Login']"));

        //profile page locators
        profileLocators.put("username", By.xpath("//XCUIElementTypeStaticText[@name='Harika kannuri']"));

        //home page locators
        homePageLocators.put("department", By.xpath("//XCUIElementTypeButton[@name='Vegetables']/XCUIElementTypeImage[2]"));
        homePageLocators.put("viewCart", By.xpath("//XCUIElementTypeStaticText[@name='View cart']"));
        homePageLocators.put("homeIcon", By.xpath("//XCUIElementTypeButton[@value='1']"));
        homePageLocators.put("searchIcon", By.xpath("//XCUIElementTypeTabBar[@name='Tab Bar']/XCUIElementTypeButton[2]"));


        //product page locators
        productPageLocators.put("ProductNameBeforeAdd", By.xpath("//XCUIElementTypeStaticText[@name='Tomato Local - Tamatar-500 gm']"));
        productPageLocators.put("addButton", By.xpath("(//XCUIElementTypeButton[@name='Add'])[2]"));
        productPageLocators.put("backButton", By.xpath("//XCUIElementTypeButton[@name='curved_chevron']"));
        productPageLocators.put("product", By.xpath("//XCUIElementTypeStaticText[@name='Tomato Local - Tamatar']"));
        productPageLocators.put("optionButton", By.xpath("//XCUIElementTypeButton[@name='2 option more']"));
        productPageLocators.put("cancelButton", By.xpath("//XCUIElementTypeButton[@name='multiply']"));
        productPageLocators.put("SpecificProduct", By.xpath("//XCUIElementTypeStaticText[@name='Bingo Hashtags Spicy Masala']"));
        productPageLocators.put("IncrementProduct", By.xpath("//XCUIElementTypeImage[@name='dropdown_moonshot']"));
        productPageLocators.put("OkayButton", By.xpath("//XCUIElementTypeButton[@name='Okay']"));
        productPageLocators.put("ProductBack", By.xpath("(//XCUIElementTypeButton[@name='curved_chevron'])[1]"));
        productPageLocators.put("ProductQuantity", By.xpath("//XCUIElementTypeStaticText[@name='2']"));


        //Product list
        productListsLocators.put("Product1", By.xpath("//XCUIElementTypeStaticText[@name='Orange Cloth Pegs Uniclip Pack']"));
        productListsLocators.put("Product2", By.xpath("//XCUIElementTypeStaticText[@name='Orange Cloth Pegs Unimac Pack']"));
        productListsLocators.put("Product3", By.xpath("//XCUIElementTypeStaticText[@name='Orange Cloth Pegs Unipeg Pack']"));
        productListsLocators.put("Product4", By.xpath("//XCUIElementTypeStaticText[@name='Avni Sweet Orange']"));
        productListsLocators.put("Product5", By.xpath("//XCUIElementTypeStaticText[@name='Glucovita Bolts Orange']"));

        //search page locators
        searchPageLocators.put("search", By.xpath("//XCUIElementTypeTextField[@value='Search for product, brand…']"));
        searchPageLocators.put("back", By.xpath("//XCUIElementTypeButton[@name='curved_chevron']"));
        searchPageLocators.put("cancel", By.xpath("//XCUIElementTypeButton[@name='multiply']"));
        searchPageLocators.put("CentralPage", By.xpath("//XCUIElementTypeOther[@name='CenterPageView']/XCUIElementTypeOther[1]"));
        searchPageLocators.put("homeIcon", By.xpath("//XCUIElementTypeTabBar[@name='Tab Bar']/XCUIElementTypeButton[1]"));

        //cart page locators
        cartPageLocators.put("ProductNameAfterAdd", By.xpath("//XCUIElementTypeStaticText[@name='Tomato Local - Tamatar - 500 gm']"));
        cartPageLocators.put("PlaceOrder", By.xpath("//XCUIElementTypeButton[@name='Place Order']"));
    }

    public static By getLoginLocator(String locatorName) {
        return loginLocators.get(locatorName);
    }

    public static By getHomePageLocator(String locatorName) {
        return homePageLocators.get(locatorName);
    }

    public static By getProfileLocators(String locatorName){
        return profileLocators.get(locatorName);
    }

    public static By getProductPageLocators(String locatorName){
        return productPageLocators.get(locatorName);
    }

    public static By getSearchPageLocator(String locatorName) {
        return searchPageLocators.get(locatorName);
    }

    public static By getProductListsLocator(String locatorName) {
        return productListsLocators.get(locatorName);
    }

    public static By getCartPageLocator(String locatorName) {
        return cartPageLocators.get(locatorName);
    }
}

