package test;

import com.zs.pages.common.HomePage;
import com.zs.pages.tamimi.HomePageTamimi;
import com.zs.pages.vijetha.HomePageVijetha;
import config.BaseTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;


public class AddToCartTest extends BaseTest{

    @Test
    @Parameters("appName")
    public void addToCart(@Optional String appName) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        HomePage homePage = new HomePage(driver, wait);
        if(appName.equals("Tamimi")){
            HomePageTamimi homePageTamimi = new HomePageTamimi(driver, wait);
            homePageTamimi.addToCartFlow();
            assertTrue(homePageTamimi.verifyProduct());
        }
        else{
            HomePageVijetha homePageVijetha = new HomePageVijetha(driver, wait);
            homePageVijetha.addToCartFlow();
            assertTrue(homePageVijetha.verifyProduct());
        }
    }

}