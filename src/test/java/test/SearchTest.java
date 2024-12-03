package test;

import com.zs.pages.common.SearchPage;
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
        SearchPage searchPage = new SearchPage(driver, wait);
        searchPage.generalSearchFlow(appName);
        assertTrue(searchPage.verifyGeneralProduct(appName));
    }

}