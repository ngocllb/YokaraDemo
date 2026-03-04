package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.URL;

public class BaseDriver {

    protected AndroidDriver driver;

    public AndroidDriver getDriver() {
        return driver;
    }

    public void initDriver() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setDeviceName("4c039a0d");

        options.setAppPackage("com.yokara.v3");
        options.setAppActivity("com.yokara.v3.MainActivity");

        options.setAutomationName("UiAutomator2");

        options.setCapability("noReset", true);

        options.setCapability("ignoreHiddenApiPolicyError", true);

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                options
        );
    }

    public void quitDriver() {

        if (driver != null) {
            driver.quit();
        }

    }
}