package base;

import core.DriverFactory;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseDriver {

    protected AndroidDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod
    public void setup() {

        driver = DriverFactory.createDriver();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterMethod
    public void teardown() {

        if (driver != null) {
            driver.quit();
        }
    }
}