package test;

import com.zs.pages.common.LoginPage;
import com.zs.pages.common.ProfilePage;
import config.BaseTest;
import com.zs.utils.ExtentReport;
import com.zs.utils.LoggerUtil;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;
import config.readCredentials;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Class use to run Login Test Case
 * @author Nagesharao Shridhar Kunthe
 */

public class LoginTest extends BaseTest {

    /**
     * Function login use to run Login Test Case
     * @param appName takes appName as the parameter and decides on which particular application login function should be executed
     */

    @Test
    @Parameters("appName")
    public void login(@Optional String appName) {
        LoggerUtil.setExtentTest(ExtentReport.getTest());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        readCredentials credentials=new readCredentials();
        credentials.setCredentials(appName);
        LoginPage loginPage = new LoginPage(driver,wait);
        LoginPage.handlePopUp(appName);
        loginPage.loginFlow(credentials.getPassword(), credentials.getUserName(), appName);
        ProfilePage profilePage = new ProfilePage(driver,wait);
        assertTrue(profilePage.isUsernameVisible(appName));
    }

}