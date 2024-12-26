package test;

import com.zs.pages.common.OrderPage;
import config.BaseTest;
import com.zs.utils.ExtentReport;
import com.zs.utils.LoggerUtil;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Class use to run Order Cancellation Test Case
 * @author Nagesharao Shridhar Kunthe
 */

public class OrderCancellationTest extends BaseTest {

    /**
     * Function login use to run Login Test Case
     * @param appName takes appName as the parameter and decides on which particular application login function should be executed
     */

    @Test
    @Parameters("appName")
    public void orderCancellation(@Optional String appName) {
        LoggerUtil.setExtentTest(ExtentReport.getTest());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        OrderPage orderPage = new OrderPage(driver, wait);
        orderPage.cancelOrderFlow(appName);
        assertTrue(orderPage.verifyCancellation(appName));
    }

}
