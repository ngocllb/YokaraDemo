package pages.Hat;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class HatPage extends BasePage {

    private By btnHat = AppiumBy.accessibilityId("Hát");

    public HatPage(AppiumDriver driver) {
        super(driver);
    }

    public void clickHat() {
        click(btnHat);
    }
}