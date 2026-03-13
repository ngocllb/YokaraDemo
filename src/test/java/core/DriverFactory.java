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

            String server = ConfigManager.getRequired("appiumServer");
            String platform = ConfigManager.getRequired("platform");

            if ("android".equalsIgnoreCase(platform) || "auto".equalsIgnoreCase(platform)) {

                String udid = DeviceManager.getAndroidUDID();

                UiAutomator2Options options = new UiAutomator2Options();

                options.setAutomationName("UiAutomator2");
                options.setPlatformName("Android");

                options.setDeviceName(udid);
                options.setUdid(udid);

                options.setAppPackage(
                        ConfigManager.getRequired("android.appPackage")
                );

                options.setAppActivity(
                        ConfigManager.getRequired("android.appActivity")
                );

                options.setNoReset(true);

                // 👇 QUAN TRỌNG - tránh lỗi Android 13/14
                options.setAutoGrantPermissions(true);
                options.setIgnoreHiddenApiPolicyError(true);
                options.setDisableWindowAnimation(true);
                options.setSkipDeviceInitialization(true);

                return new AndroidDriver(new URL(server), options);
            }

            if ("ios".equalsIgnoreCase(platform)) {

                XCUITestOptions options = new XCUITestOptions();

                options.setAutomationName("XCUITest");
                options.setPlatformName("iOS");

                options.setBundleId(
                        ConfigManager.getRequired("ios.bundleId")
                );

                options.setNoReset(true);

                return new IOSDriver(new URL(server), options);
            }

        } catch (Exception e) {

            throw new RuntimeException("Failed to create driver: " + e.getMessage(), e);
        }

        throw new RuntimeException("Platform not supported");
    }
}