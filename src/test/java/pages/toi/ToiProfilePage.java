package pages.toi;

import base.BasePage;
import base.BottomNav;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ToiProfilePage extends BasePage {

    private final BottomNav bottomNav;

    private final By menuVIP =
            AppiumBy.accessibilityId("VIP");

    private final By userUID =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().className(\"android.widget.ImageView\")"
            );

    public ToiProfilePage(AppiumDriver driver){
        super(driver);
        bottomNav = new BottomNav(driver);
    }

    /**
     * Verify VIP menu hiển thị
     */
    public boolean isVipMenuDisplayed(){
        return isDisplayed(menuVIP);
    }

    /**
     * Verify UID hiển thị
     */
    public boolean isUserIDDisplayed(){
        return isDisplayed(userUID);
    }

    /**
     * Access Bottom Navigation
     */
    public BottomNav nav(){
        return bottomNav;
    }
}