package core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.URL;

public class DriverFactory {

    public static AndroidDriver createDriver() {

        try {

            String deviceId = DeviceManager.getConnectedDevice();

            System.out.println("Detected device: " + deviceId);

            UiAutomator2Options options = new UiAutomator2Options();

            options.setPlatformName("Android");
            options.setAutomationName("UiAutomator2");

            options.setUdid(deviceId);

            options.setAppPackage("com.yokara.v3");
            options.setAppActivity(".MainActivity");

            options.setCapability("noReset", true);
            options.setCapability("autoGrantPermissions", true);
            options.setCapability("ignoreHiddenApiPolicyError", true);

            return new AndroidDriver(
                    new URL("http://127.0.0.1:4723"),
                    options
            );

        } catch (Exception e) {

            throw new RuntimeException("Failed to create driver", e);
        }
    }
}