package listeners;

import base.BaseDriver;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.StepContext;

public class AllureListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        String stepName = StepContext.getStep();

        if (stepName == null) {
            stepName = "Unknown Step";
        }

        captureScreenshot(stepName);
    }

    @Attachment(value = "Failure Screenshot - {stepName}", type = "image/png")
    public byte[] captureScreenshot(String stepName) {

        return ((TakesScreenshot) BaseDriver.getDriver())
                .getScreenshotAs(OutputType.BYTES);
    }
}