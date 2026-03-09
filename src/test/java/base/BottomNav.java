package base;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

import pages.trangchu.TrangChuPage;
import pages.tructuyen.TrucTuyenPage;
import pages.hat.HatPage;
import pages.tinnhan.TinNhanPage;
import pages.toi.ToiProfilePage;

public class BottomNav extends BasePage {

    private By tabTrangChu =
           // AppiumBy.androidUIAutomator("new UiSelector().descriptionContains(\"Trang chủ\")");
AppiumBy.accessibilityId("Trang Chủ");
    private By tabTrucTuyen =
           // AppiumBy.androidUIAutomator("new UiSelector().descriptionContains(\"Trực tuyến\")");
            AppiumBy.accessibilityId("Trực Tuyến");
    private By tabHat =
            AppiumBy.accessibilityId("Hát");

    private By tabTinNhan =
            //AppiumBy.androidUIAutomator("new UiSelector().descriptionContains(\"Tin nhắn\")");
            AppiumBy.accessibilityId("Tin Nhắn");
    private By tabToi =
           // AppiumBy.androidUIAutomator("new UiSelector().descriptionContains(\"Tôi\")");
            AppiumBy.accessibilityId("Tôi");
    public BottomNav(AppiumDriver driver) {
        super(driver);
    }

    public TrangChuPage goToTrangChu() {

        click(tabTrangChu);
        return new TrangChuPage(driver);
    }

    public TrucTuyenPage goToTrucTuyen() {

        click(tabTrucTuyen);
        return new TrucTuyenPage(driver);
    }

    public HatPage goToHat() {

        click(tabHat);
        return new HatPage(driver);
    }

    public TinNhanPage goToTinNhan() {

        click(tabTinNhan);
        return new TinNhanPage(driver);
    }

    public ToiProfilePage goToToi() {

        click(tabToi);
        return new ToiProfilePage(driver);
    }
}