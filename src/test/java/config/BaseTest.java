package config;

import io.appium.java_client.ios.IOSDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * BaseTest class serves as a base for Appium-based test automation for iOS applications.
 * It provides common setup and teardown functionality for the tests, including the initialization
 * of the Appium IOSDriver and configuration of capabilities for iOS devices.
 */

public class BaseTest {

    public static IOSDriver driver;
    public static Logger logger;

    @BeforeClass
    @Parameters("appFile")

    /**
     * The setup method creates a driver instance with the desired capabilities based on the
     * provided parameters appFile path and sets the necessary configurations for the iOS
     * device and app under test.
     */

    public IOSDriver setUp(@Optional String appFile) throws MalformedURLException {
        logger= LogManager.getLogger(this.getClass());
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "iPhone 16 Pro");
        caps.setCapability("platformName", "iOS");
        caps.setCapability("platformVersion", "18.1");
        caps.setCapability("automationName", "XCUITest");
        caps.setCapability("noReset", true);
        caps.setCapability("app", appFile);
        driver = new IOSDriver(new URL("http://127.0.0.1:4723"), caps);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    /**
     * The teardown method ensures the driver is properly quit after the tests are finished
     */
    
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
