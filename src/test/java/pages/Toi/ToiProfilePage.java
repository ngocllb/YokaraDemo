package pages.toi;

import base.BasePage;
import base.BottomNav;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ToiProfilePage extends BasePage {

    BottomNav bottomNav;

    private By menuVIP = AppiumBy.accessibilityId("VIP");

    public ToiProfilePage(AppiumDriver driver) {

        super(driver);
        bottomNav = new BottomNav(driver);
    }

    public boolean isVipMenuDisplayed() {

        return isDisplayed(menuVIP);
    }

    public BottomNav nav() {
        return bottomNav;
    }
}