package test;

import com.zs.pages.common.LoginPage;
import com.zs.pages.common.ProfilePage;
import config.BaseTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;
import config.readCredentials;
import static org.testng.AssertJUnit.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    @Parameters("appName")
    public void login(@Optional String appName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        readCredentials credentials=new readCredentials();
        credentials.setCredientials(appName);
        LoginPage loginPage = new LoginPage(driver,wait);
        LoginPage.handlePopUp(appName);
        loginPage.loginFlow(credentials.getPassword(), credentials.getUserName(), appName);
        ProfilePage profilePage = new ProfilePage(driver,wait);
        assertTrue(profilePage.isUsernameVisible(appName));
    }

}