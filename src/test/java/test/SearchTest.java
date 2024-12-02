package test;

import com.zs.pages.tamimi.SearchPageTamimi;
import com.zs.pages.vijetha.SearchPageVijetha;
import config.BaseTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;


public class SearchTest extends BaseTest{

    @Test
    @Parameters("appName")
    public void addToCart(@Optional String appName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        if(appName.equals("Tamimi")){
            SearchPageTamimi searchPageTamimi = new SearchPageTamimi(driver, wait);
            searchPageTamimi.generalSearchFlow();
            assertTrue(searchPageTamimi.verifyGeneralProduct());
        }
        else{
            SearchPageVijetha searchPageVijetha = new SearchPageVijetha(driver, wait);
            searchPageVijetha.generalSearchFlow();
            assertTrue(searchPageVijetha.verifyGeneralProduct());
        }
    }

}