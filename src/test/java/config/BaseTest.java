package config;

import io.appium.java_client.ios.IOSDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static IOSDriver driver;
    public static Logger logger;

    @BeforeClass
    @Parameters("appFile")
    public IOSDriver setUp(@Optional String appFile) throws MalformedURLException {
        logger= LogManager.getLogger(this.getClass());
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "iPhone 16 Pro");
        caps.setCapability("platformName", "iOS");
        caps.setCapability("platformVersion", "18.1");
        caps.setCapability("automationName", "XCUITest");
        caps.setCapability("noReset", true);
        caps.setCapability("app", appFile);
//        logger.info("App name: {}", appName);
        driver = new IOSDriver(new URL("http://127.0.0.1:4723"), caps);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
