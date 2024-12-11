package test;

import com.zs.pages.common.SearchPage;
import config.BaseTest;
import com.zs.utils.ExtentReport;
import com.zs.utils.LoggerUtil;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Class use to run Search a Specific Product Test Case
 * @author Nagesharao Shridhar Kunthe
 */

public class SearchProductTest extends BaseTest{

    /**
     * Function searchSpecificProduct use to run Search a Specific Product Test Case
     * @param appName takes appName as the parameter and decides on which particular application searchSpecificProduct function should be executed
     */

    @Test
    @Parameters("appName")
    public void searchSpecificProduct(@Optional String appName) {
        LoggerUtil.setExtentTest(ExtentReport.getTest());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        SearchPage searchPage = new SearchPage(driver, wait);
        searchPage.productSearchFlow(appName);
        assertTrue(searchPage.verifyProduct(appName));
    }

}