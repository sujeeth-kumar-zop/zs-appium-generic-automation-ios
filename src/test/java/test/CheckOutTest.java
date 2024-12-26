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

/**
 * Class use to run Checkout Using Debit Card Test Case
 * @author Nagesharao Shridhar Kunthe
 */

public class CheckOutTest extends BaseTest {

    /**
     * Function checkOutDebitCard use to run Checkout Using Debit Card Test Case
     * @param appName takes appName as the parameter and decides on which particular application checkOutDebitCard function should be executed
     */

    @Test
    @Parameters("appName")
    public void checkOutDebitCard(@Optional String appName) throws InterruptedException {
        LoggerUtil.setExtentTest(ExtentReport.getTest());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        CheckOut checkOut = new CheckOut(driver, wait);
        HomePageTamimi homePageTamimi = new HomePageTamimi(driver, wait);
        CartPage cartPage = new CartPage(driver, wait);
        checkOut.clickBackButton();
        homePageTamimi.addToCartFlow();
        cartPage.incrementProductFlow(appName);
        checkOut.checkOutFlowDebitCard(appName);
        assertTrue(checkOut.verifyCheckOut(appName));
    }

    /**
     * Function checkOutCOD use to run Checkout Using Case on Collection/Case on Delivery Test Case
     * @param appName takes appName as the parameter and decides on which particular application checkOutCOD function should be executed
     */

    @Test
    @Parameters("appName")
    public void checkOutCOD(@Optional String appName) throws InterruptedException {
        LoggerUtil.setExtentTest(ExtentReport.getTest());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        CheckOut checkOut = new CheckOut(driver, wait);
        checkOut.checkOutFlowCOD(appName);
        assertTrue(checkOut.verifyCheckOut(appName));
    }

}
