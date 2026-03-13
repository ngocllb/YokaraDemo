package pages.toi.caidat;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

import pages.toi.ToiGuestPage;

public class LogoutPopup extends BasePage {

    public LogoutPopup(AppiumDriver driver) {
        super(driver);
    }

    /* ================= LOCATORS ================= */

    private final By btnDong = AppiumBy.accessibilityId("Đóng");

    private final By btnXacNhan = AppiumBy.accessibilityId("Xác nhận");


    /* ================= ACTION ================= */

    public CaiDatPage closePopup() {

        click(btnDong);

        return new CaiDatPage(driver);
    }

    public ToiGuestPage confirmLogout() {

        click(btnXacNhan);

        ToiGuestPage guestPage = new ToiGuestPage(driver);

        // wait màn guest
        guestPage.waitForGuestPage();

        return guestPage;
    }


    /* ================= VERIFY ================= */

    public boolean isPopupDisplayed() {

        return isDisplayed(btnXacNhan);

    }


}