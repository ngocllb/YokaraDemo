package pages.TrangChu;

import base.BasePage;
import base.BottomNav;
import io.appium.java_client.AppiumDriver;

public class TrangChuPage extends BasePage {

    BottomNav bottomNav;

    public TrangChuPage(AppiumDriver driver) {

        super(driver);
        bottomNav = new BottomNav(driver);
    }

    public BottomNav nav() {
        return bottomNav;
    }
}