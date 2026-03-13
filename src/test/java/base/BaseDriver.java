package base;

import core.DriverFactory;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import flows.AuthFlow;

import java.io.ByteArrayInputStream;
import java.time.Duration;

public class BaseDriver {

    protected static AppiumDriver driver;
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

    public static AppiumDriver getDriver() {
        return driver;
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(ITestResult result) {

        try {

            // nếu test fail → attach screenshot
            if (result.getStatus() == ITestResult.FAILURE) {

                byte[] screenshot = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES);

                Allure.addAttachment(
                        "Failure Screenshot",
                        new ByteArrayInputStream(screenshot)
                );
            }

            if (driver != null) {
                driver.quit();
            }

        } catch (Exception e) {

            System.out.println("Driver quit failed: " + e.getMessage());

        }
    }
}