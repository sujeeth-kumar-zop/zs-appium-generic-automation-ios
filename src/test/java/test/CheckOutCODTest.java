package test;

import com.zs.pages.common.CartPage;
import com.zs.pages.common.CheckOut;
import com.zs.pages.tamimi.HomePageTamimi;
import config.BaseTest;
import com.zs.utils.ExtentReport;
import com.zs.utils.LoggerUtil;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;

public class CheckOutCODTest extends BaseTest {
    @Test
    @Parameters("appName")
    public void checkOutCOD(@Optional String appName) throws InterruptedException {
        LoggerUtil.setExtentTest(ExtentReport.getTest());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        CheckOut checkOut = new CheckOut(driver, wait);
        HomePageTamimi homePageTamimi = new HomePageTamimi(driver, wait);
        CartPage cartPage = new CartPage(driver, wait);
        checkOut.clickBackButton(); //To go back to Home Page
        homePageTamimi.addToCartFlow();
        cartPage.incrementProductFlow(appName);
        checkOut.checkOutFlowCOD(appName);
        assertTrue(checkOut.verifyPlaceOrder(appName));
    }
}
