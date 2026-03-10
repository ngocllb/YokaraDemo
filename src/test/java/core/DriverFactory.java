package core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.net.URL;

public class DriverFactory {

    public static AppiumDriver createDriver() {

        try {

            String server =
                    ConfigManager.get("appiumServer");

            String platform =
                    ConfigManager.get("platform");

            if (platform.equalsIgnoreCase("android") || platform.equalsIgnoreCase("auto")) {

                String udid = DeviceManager.getAndroidUDID();

                UiAutomator2Options options = new UiAutomator2Options();

                options.setAutomationName("UiAutomator2");
                options.setPlatformName("Android");
                options.setDeviceName(udid);
                options.setUdid(udid);

                options.setAppPackage(
                        ConfigManager.get("android.appPackage")
                );

                options.setAppActivity(
                        ConfigManager.get("android.appActivity")
                );

                options.setNoReset(true);

                return new AndroidDriver(new URL(server), options);
            }

            if (platform.equalsIgnoreCase("ios")) {

                XCUITestOptions options = new XCUITestOptions();

                options.setAutomationName("XCUITest");
                options.setPlatformName("iOS");

                options.setBundleId(
                        ConfigManager.get("ios.bundleId")
                );

                return new IOSDriver(new URL(server), options);
            }

        } catch (Exception e) {

            throw new RuntimeException(e);
        }

        throw new RuntimeException("Platform not supported");
    }
}