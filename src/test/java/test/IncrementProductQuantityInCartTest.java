package test;

import com.zs.pages.common.CartPage;
import com.zs.pages.common.SearchPage;
import config.BaseTest;
import com.zs.utils.ExtentReport;
import com.zs.utils.LoggerUtil;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;

public class IncrementProductQuantityInCartTest extends BaseTest {
    @Test
    @Parameters("appName")
    public void incrementProductQuantity(@Optional String appName) throws InterruptedException {
        LoggerUtil.setExtentTest(ExtentReport.getTest());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        CartPage cartPage = new CartPage(driver, wait);
        SearchPage searchPage =new SearchPage(driver, wait);
        searchPage.clickCancelButton(appName);
        cartPage.incrementProductFlow(appName);
        assertTrue(cartPage.verifyIncrement(appName));
    }
}
