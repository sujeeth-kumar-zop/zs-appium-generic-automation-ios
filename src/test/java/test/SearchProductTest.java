package test;

import com.zs.pages.tamimi.SearchPageTamimi;
import com.zs.pages.vijetha.SearchPageVijetha;
import config.BaseTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;


public class SearchProductTest extends BaseTest{

    @Test
    @Parameters("appName")
    public void addToCart(@Optional String appName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        if(appName.equals("Tamimi")){
            SearchPageTamimi searchPageTamimi = new SearchPageTamimi(driver, wait);
            searchPageTamimi.productSearchFlow();
            assertTrue(searchPageTamimi.verifyProduct());
        }
        else{
            SearchPageVijetha searchPageVijetha = new SearchPageVijetha(driver, wait);
            searchPageVijetha.productSearchFlow();
            assertTrue(searchPageVijetha.verifyProduct());
        }
    }

}