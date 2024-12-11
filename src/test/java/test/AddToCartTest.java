package test;

import com.zs.pages.tamimi.HomePageTamimi;
import com.zs.pages.vijetha.HomePageVijetha;
import com.zs.utils.ExtentReport;
import com.zs.utils.LoggerUtil;
import config.BaseTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Class use to run Add to Cart Test Case
 * @author Nagesharao Shridhar Kunthe
 */

public class AddToCartTest extends BaseTest{

    /**
     * Function addToCart use to run Add to Cart Test Case
     * @param appName takes appName as the parameter and decides on which particular application addToCart function should be executed
     */

    @Test
    @Parameters("appName")
    public void addToCart(@Optional String appName) {

        LoggerUtil.setExtentTest(ExtentReport.getTest());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        switch (appName){
            case "Tamimi":
                HomePageTamimi homePageTamimi = new HomePageTamimi(driver, wait);
                homePageTamimi.addToCartFlow();
                assertTrue(homePageTamimi.verifyProduct());
                break;
            case "Vijetha":
                HomePageVijetha homePageVijetha = new HomePageVijetha(driver, wait);
                homePageVijetha.addToCartFlow();
                assertTrue(homePageVijetha.verifyProduct());
                break;
            default:
                throw new IllegalArgumentException("Invalid app name: " + appName);
        }
    }

}
