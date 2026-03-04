package pages.Toi;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class ToiGuestPage extends BasePage {

    private By btnDangNhap = AppiumBy.accessibilityId("Đăng nhập");

    public ToiGuestPage(AppiumDriver driver) {
        super(driver);
    }

    public boolean isGuestDisplayed() {
        return isDisplayed(btnDangNhap);
    }

    public void clickDangNhap() {
        click(btnDangNhap);
    }
}