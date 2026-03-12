package tests;

import base.BaseDriver;
import base.BottomNav;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.toi.ToiGuestPage;
import pages.toi.ToiProfilePage;
import utils.AuthFlow;

public class LoginMethodTest extends BaseDriver {

    private final String TEST_UID = "6026833";
    private final String TEST_PASSWORD = "Abcd1234";

    @Test
    public void loginByUIDTest(){

        BottomNav bottomNav = new BottomNav(driver);
        AuthFlow auth = new AuthFlow(driver);

        Allure.step("Navigate tới tab Tôi");
        bottomNav.goToToi();
        ToiGuestPage guestPage = new ToiGuestPage(driver);
        Allure.step("Verify đang ở trạng thái Guest");
        Assert.assertTrue(
                guestPage.isGuest(),
                "Expected guest state but login button not found"
        );
        ToiProfilePage profilePage = Allure.step(
                "Login bằng UID",
                () -> auth.login("uid", TEST_UID, TEST_PASSWORD)
        );
        Allure.step("Verify UID sau khi login");
        Assert.assertTrue(
                profilePage.isUserIdDisplayed(TEST_UID),
                "UID hiển thị không đúng sau khi login"
        );
    }
}