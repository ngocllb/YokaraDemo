package pages.Toi;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class SettingPage extends BasePage {

    private By title = AppiumBy.accessibilityId("Cài đặt");
    private By logoutButton = AppiumBy.accessibilityId("Đăng xuất");

    public SettingPage(AppiumDriver driver) {
        super(driver);
    }

    public boolean isSettingDisplayed() {
        return isDisplayed(title);
    }

    public void logout() {
        click(logoutButton);
    }
}