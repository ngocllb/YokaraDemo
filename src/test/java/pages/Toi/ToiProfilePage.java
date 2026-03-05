package pages.Toi;

import base.BasePage;
import base.BottomNav;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ToiProfilePage extends BasePage {

    private BottomNav bottomNav;

    private By menuVIP = AppiumBy.accessibilityId("VIP");

    public ToiProfilePage(AppiumDriver driver) {

        super(driver);
        this.bottomNav = new BottomNav(driver);

    }

    public boolean isVipMenuVisible() {

        return isDisplayed(menuVIP);

    }

    public boolean isProfileLoaded() {

        return isVipMenuVisible();

    }

    public BottomNav nav() {

        return bottomNav;

    }

}