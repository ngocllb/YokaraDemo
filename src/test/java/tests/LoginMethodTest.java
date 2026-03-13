package tests;

import base.BaseDriver;
import base.BasePage;
import base.BottomNav;
import flows.AuthFlow;
import listeners.AllureListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.toi.ToiGuestPage;
import pages.toi.ToiProfilePage;
import pages.toi.caidat.CaiDatPage;
import pages.toi.caidat.LogoutPopup;
import pages.toi.login.AccountPage;
import pages.toi.login.LoginMethodPage;
import pages.toi.login.loginphone.LoginPhonePage;
import pages.toi.login.loginphone.OtpVerificationPage;
import utils.StepUtils;

@Listeners(AllureListener.class)
public class LoginMethodTest extends BaseDriver {

    private final String TEST_UID = "6026833";
    private final String TEST_PASSWORD = "Abcd1234";
    private final String TEST_PHONE = "0799047868";
    private final String TEST_OTP = "123455";
    private final String TEST_INVALID_OTP = "111111";

    @Test(priority = 1)
    public void loginByUIDTest() {

        BottomNav bottomNav = new BottomNav(driver);
        AuthFlow auth = new AuthFlow(driver);
        ToiGuestPage guestPage = new ToiGuestPage(driver);

        StepUtils.step("Launch app và navigate tới tab Tôi", bottomNav::goToToi);
        StepUtils.step("Verify đang ở trạng thái Guest",
                () -> Assert.assertTrue(guestPage.isGuest(),
                        "Không tìm thấy button Đăng nhập"
                )
        );
        ToiProfilePage profilePage = StepUtils.step(
                "Login bằng UID",
                () -> auth.login("uid", TEST_UID, TEST_PASSWORD)
        );
        StepUtils.step("Verify Login thành công và UID chính xác sau khi login",
                () -> Assert.assertTrue(profilePage.isUserIdDisplayed(TEST_UID),
                        "UID hiển thị không đúng sau khi login"
                )
        );
        logoutAndVerify(profilePage);
    }
    @Test(priority = 2)
    public void loginByPhoneTest() {

        BottomNav bottomNav = new BottomNav(driver);
        ToiGuestPage guestPage = new ToiGuestPage(driver);

        StepUtils.step("Navigate tới tab Tôi", bottomNav::goToToi);
        StepUtils.step("Verify đang ở trạng thái Guest",
                () -> Assert.assertTrue(guestPage.isGuest(),
                        "Không tìm thấy button Đăng nhập"
                )
        );
        BasePage page = StepUtils.step(
                "Mở màn hình chọn phương thức đăng nhập",
                guestPage::clickLogin
        );
        LoginMethodPage loginMethodPage = StepUtils.step(
                "Đi tới màn Login Method",
                () -> {
                    if (page instanceof AccountPage accountPage) {
                        accountPage.selectAnotherMethodLogin();
                        return new LoginMethodPage(driver);
                    }
                    return (LoginMethodPage) page;
                }
        );
        LoginPhonePage loginPhonePage = StepUtils.step(
                "Mở màn hình đăng nhập bằng số điện thoại",
                () -> (LoginPhonePage) loginMethodPage.loginWith("phone")
        );
        OtpVerificationPage otpPage = StepUtils.step(
                "Nhập số điện thoại và chuyển sang màn OTP",
                () -> loginPhonePage.goToOtpPage(TEST_PHONE)
        );
        StepUtils.step("Nhập OTP sai và verify hiển thị lỗi", () -> {
            otpPage.submitInvalidOtp(TEST_INVALID_OTP);

            Assert.assertTrue(otpPage.isOtpErrorDisplayed(),
                    "Không hiển thị lỗi khi nhập OTP sai"
            );
            Assert.assertTrue(otpPage.isStillOnOtpPage(),
                    "Nhập OTP sai nhưng không còn ở màn OTP"
            );
        });
        ToiProfilePage profilePage = StepUtils.step(
                "Nhập OTP đúng và đăng nhập thành công",
                () -> otpPage.submitValidOtp(TEST_OTP)
        );
        StepUtils.step("Verify Login thành công với đúng OTP",
                () -> Assert.assertTrue(profilePage.isUserIdDisplayed(TEST_UID),
                        "UID hiển thị không đúng sau khi login"
                )
        );
        logoutAndVerify(profilePage);
    }

    private void logoutAndVerify(ToiProfilePage profilePage) {
        CaiDatPage caiDatPage = StepUtils.step("Mở Cài đặt", profilePage::openSetting);
        LogoutPopup popup = StepUtils.step("Click Đăng xuất", caiDatPage::clickDangXuat);
        ToiGuestPage guestAfterLogout = StepUtils.step("Xác nhận đăng xuất", popup::confirmLogout);

        StepUtils.step("Verify đã logout",
                () -> Assert.assertTrue(guestAfterLogout.isGuest(),
                        "Logout thất bại"
                )
        );
    }
}