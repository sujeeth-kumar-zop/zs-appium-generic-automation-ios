package com.zs.locators;

import org.openqa.selenium.By;
import java.util.HashMap;
import java.util.Map;

public class TamimiLocators {

    public static final Map<String, By> loginLocators = new HashMap<>();
    public static final Map<String,By> homePageLocators=new HashMap<>();
    public static final Map<String,By> profileLocators=new HashMap<>();
    public static final Map<String, By> departmentPageLocators=new HashMap<>();
    public static final Map<String, By> searchPageLocators=new HashMap<>();
    public static final Map<String, By> productListsLocators=new HashMap<>();
    public static final Map<String, By> productPageLocators=new HashMap<>();
    public static final Map<String, By> cartPageLocators=new HashMap<>();
    static {


        //login page locators
        loginLocators.put("profileIcon", By.xpath("//XCUIElementTypeTabBar[@name='Tab Bar']/XCUIElementTypeButton[4]"));
        loginLocators.put("enterEmailOrPhoneTextBox", By.xpath("//XCUIElementTypeTextField[@value='0XX XXX XXXX']"));
        loginLocators.put("enterPasswordTextBox", By.xpath("//XCUIElementTypeSecureTextField[@value='Password']"));
        loginLocators.put("loginBtn", By.xpath("//XCUIElementTypeButton[@name='Login']"));

        //profile page locators
        profileLocators.put("username", By.xpath("//XCUIElementTypeStaticText[@name='Mr. Ahmed Khan']"));

        //home page
        homePageLocators.put("department", By.xpath("//XCUIElementTypeButton[@name='FRUITS & VEGETABLES']/XCUIElementTypeImage[2]"));
        homePageLocators.put("homeIcon", By.xpath("//XCUIElementTypeTabBar[@name='Tab Bar']/XCUIElementTypeButton[1]"));
        homePageLocators.put("searchIcon", By.xpath("//XCUIElementTypeTextField[@value='What are you looking for?']"));
        homePageLocators.put("notNow", By.xpath("//XCUIElementTypeButton[@name='Not Now']"));

        //Department page
        departmentPageLocators.put("ProductNameBeforeAdd", By.xpath("//XCUIElementTypeStaticText[@name='Red Onions-1.5 kg']"));
        //departmentPageLocators.put("ProductPriceBeforeAdd", By.xpath("//XCUIElementTypeStaticText[@name='8.95 SAR']"));
        departmentPageLocators.put("addButton", By.xpath("(//XCUIElementTypeButton[@name='increaseQuantity_scarlet'])[1]"));
        departmentPageLocators.put("CartButton", By.xpath("//XCUIElementTypeButton[@value='1 item']"));

        //Search page
        searchPageLocators.put("search", By.xpath("//XCUIElementTypeTextField[@value='Search']"));
        searchPageLocators.put("cancel", By.xpath("//XCUIElementTypeButton[@name='Cancel']"));

        //Product list
        productListsLocators.put("Product1", By.xpath("//XCUIElementTypeStaticText[@name='Onaizah Tomato']"));
        productListsLocators.put("Product2", By.xpath("//XCUIElementTypeStaticText[@name='Tomato']"));
        productListsLocators.put("Product3", By.xpath("//XCUIElementTypeStaticText[@name='Chicken Shish Tawook With Tomato Sauce']"));
        productListsLocators.put("Product4", By.xpath("//XCUIElementTypeStaticText[@name='Sundried Tomato']"));
        productListsLocators.put("Product5", By.xpath("//XCUIElementTypeStaticText[@name='Dried Tomato In Oil']"));

        //Product page
        productPageLocators.put("ProductNameAfterAdd", By.xpath("//XCUIElementTypeStaticText[@name='Red Onions - 1.5 kg']"));
      //  productPageLocators.put("ProductPriceAfterAdd", By.xpath("//XCUIElementTypeStaticText[@name='8.95 SAR']"));
        productPageLocators.put("SpecificProduct", By.xpath("//XCUIElementTypeStaticText[@name='French Cheese Potato Chips']"));
        productPageLocators.put("CheckOut", By.xpath("//XCUIElementTypeButton[@name='CHECKOUT']"));
        productPageLocators.put("ProductIncrement", By.xpath("//XCUIElementTypeButton[@name='increaseQuantity_scarlet']"));
        productPageLocators.put("SubTotal", By.xpath("//XCUIElementTypeStaticText[@name='46.68 SAR']"));
        productPageLocators.put("SelectSubstitution", By.xpath("//XCUIElementTypeImage[@name='downArray']"));
        productPageLocators.put("CallForSubstitution", By.xpath("//XCUIElementTypeButton[@name='Call for Substitution']"));
        productPageLocators.put("EndOfPage", By.xpath("//XCUIElementTypeStaticText[@name='Delivery Charges (Inc VAT)']"));
        productPageLocators.put("DebitCard", By.xpath("//XCUIElementTypeStaticText[@name='mada Debit Card']"));
        productPageLocators.put("CardSelection", By.xpath("//XCUIElementTypeStaticText[@name='xxxx 2387']"));
        productPageLocators.put("PlaceOrder", By.xpath("//XCUIElementTypeButton[@name='PLACE ORDER']"));
        productPageLocators.put("SuccessOrderPlace", By.xpath("//XCUIElementTypeStaticText[@name='Order placed successfully!']"));
        productPageLocators.put("ProductQuantity", By.xpath("//XCUIElementTypeButton[@name='20']"));
        productPageLocators.put("ElementAppearance", By.xpath("//XCUIElementTypeStaticText[@name='Select your preferred day']"));
        productPageLocators.put("AlertMessage", By.xpath("//XCUIElementTypeStaticText[@name='Alert']"));
        productPageLocators.put("AlertOk", By.xpath("//XCUIElementTypeButton[@name='OK']"));
        productPageLocators.put("COD", By.xpath("//XCUIElementTypeStaticText[@name='Cash on collection']"));

        //Cart Page
        cartPageLocators.put("BackButton", By.xpath("//XCUIElementTypeButton[@name='chevron.left']"));
    }

    public static By getLoginLocator(String locatorName) {
        return loginLocators.get(locatorName);
    }
    public static By getProfileLocators(String locatorName){
        return profileLocators.get(locatorName);
    }
    public static By getHomePageLocator(String locatorName) {
        return homePageLocators.get(locatorName);
    }
    public static By getDepartmentLocator(String locatorName) {
        return departmentPageLocators.get(locatorName);
    }
    public static By getSearchPageLocator(String locatorName) {
        return searchPageLocators.get(locatorName);
    }
    public static By getProductListsLocator(String locatorName) {
        return productListsLocators.get(locatorName);
    }
    public static By getProductPageLocators(String locatorName){
        return productPageLocators.get(locatorName);
    }
    public static By getCartPageLocators(String locatorName){
        return cartPageLocators.get(locatorName);
    }
}

