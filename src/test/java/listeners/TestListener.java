package listeners;

import base.BaseDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        BaseDriver base = (BaseDriver) result.getInstance();

        ScreenshotUtils.takeScreenshot(
                base.getDriver(),
                result.getName()
        );
    }
}