package utils;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;

public class ScreenshotUtils {

    public static void takeScreenshot(AppiumDriver driver, String name) {

        try {

            File src = driver.getScreenshotAs(OutputType.FILE);

            FileUtils.copyFile(src,
                    new File("reports/screenshots/" + name + ".png"));

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}