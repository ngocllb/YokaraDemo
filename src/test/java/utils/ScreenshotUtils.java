package utils;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    private static final String SCREENSHOT_DIR = "reports/screenshots/";

    public static void takeScreenshot(AppiumDriver driver, String testName) {

        try {

            File dir = new File(SCREENSHOT_DIR);

            if (!dir.exists() && !dir.mkdirs()) {
                throw new RuntimeException("Failed to create screenshot directory");
            }

            String timestamp =
                    new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            String fileName =
                    SCREENSHOT_DIR + testName + "_" + timestamp + ".png";

            File screenshot = driver.getScreenshotAs(OutputType.FILE);

            Files.copy(screenshot.toPath(), new File(fileName).toPath());

            attachScreenshot(driver);

        } catch (Exception e) {

            System.out.println("Screenshot capture failed: " + e.getMessage());

        }
    }

    @Attachment(value = "Failure Screenshot", type = "image/png")
    public static byte[] attachScreenshot(AppiumDriver driver) {

        return driver.getScreenshotAs(OutputType.BYTES);

    }
}