package pages.tinnhan;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class TinNhanPage extends BasePage {

    private By title = AppiumBy.accessibilityId("Tin nhắn");

    public TinNhanPage(AppiumDriver driver) {
        super(driver);
    }

    public boolean isTinNhanDisplayed() {
        return isDisplayed(title);
    }
}