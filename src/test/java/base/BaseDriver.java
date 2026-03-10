package base;

import core.DriverFactory;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utils.AuthFlow;

import java.time.Duration;

public class BaseDriver {

    protected AppiumDriver driver;
    protected WebDriverWait wait;

    protected AuthFlow auth;

    @BeforeMethod(alwaysRun = true)
    public void setup() {

        driver = DriverFactory.createDriver();

        if (driver == null) {
            throw new RuntimeException("Driver initialization failed!");
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        auth = new AuthFlow(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {

        try {

            if (driver != null) {
                driver.quit();
            }

        } catch (Exception e) {

            System.out.println("Driver quit failed: " + e.getMessage());

        }
    }

    public AppiumDriver getDriver() {
        return driver;
    }
}