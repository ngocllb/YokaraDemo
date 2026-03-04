package core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.URL;

public class DriverFactory {

    public static AppiumDriver createDriver() throws Exception {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setDeviceName(ConfigManager.get("deviceName"));
        options.setUdid(ConfigManager.get("udid"));
        options.setAppPackage(ConfigManager.get("appPackage"));
        options.setAppActivity(ConfigManager.get("appActivity"));
        options.setAutomationName("UiAutomator2");

        options.setCapability("noReset", true);

        return new AndroidDriver(
                new URL(ConfigManager.get("serverURL")),
                options
        );
    }
}