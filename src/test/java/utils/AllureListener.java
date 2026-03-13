package utils;

import base.BaseDriver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        captureScreenshot();
    }

    @Attachment(value = "Failure Screenshot", type = "image/png")
    public byte[] captureScreenshot() {

        return ((TakesScreenshot) BaseDriver.getDriver())
                .getScreenshotAs(OutputType.BYTES);
    }
}