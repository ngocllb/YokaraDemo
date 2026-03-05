package utils;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    private static final String SCREENSHOT_DIR = "reports/screenshots/";

    public static void takeScreenshot(AppiumDriver driver, String testName) {

        try {

            File dir = new File(SCREENSHOT_DIR);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            String fileName = SCREENSHOT_DIR + testName + "_" + timestamp + ".png";

            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            Files.copy(screenshot.toPath(), new File(fileName).toPath());

            attachScreenshot(driver);

        } catch (Exception e) {

            System.out.println("Screenshot capture failed: " + e.getMessage());

        }
    }

    @Attachment(value = "Failure Screenshot", type = "image/png")
    public static byte[] attachScreenshot(AppiumDriver driver) {

        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

    }
}