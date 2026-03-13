package flows;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import pages.toi.ToiGuestPage;
import pages.toi.ToiProfilePage;
import pages.toi.login.AccountPage;
import pages.toi.login.FbGoogleAccountPage;
import pages.toi.login.LoginMethodPage;
import pages.toi.login.LoginUIDPage;
import pages.toi.login.loginphone.LoginPhonePage;
import pages.toi.login.loginphone.OtpVerificationPage;

public class AuthFlow {

    private final AppiumDriver driver;

    public AuthFlow(AppiumDriver driver) {
        this.driver = driver;
    }

    public ToiProfilePage login(String method, String... args) {

        ToiGuestPage guestPage = new ToiGuestPage(driver);
        BasePage page = guestPage.clickLogin();

        LoginMethodPage methodPage;

        if (page instanceof AccountPage) {
            AccountPage accountPage = (AccountPage) page;
            accountPage.selectAnotherMethodLogin();
            methodPage = new LoginMethodPage(driver);
        } else {
            methodPage = (LoginMethodPage) page;
        }

        switch (method.toLowerCase()) {

            case "uid":
                validateArgs(method, args, 2);

                LoginUIDPage uidPage =
                        (LoginUIDPage) methodPage.loginWith("uid");

                return uidPage.loginByUID(args[0], args[1]);

            case "phone":
                validateArgs(method, args, 2);

                LoginPhonePage phonePage =
                        (LoginPhonePage) methodPage.loginWith("phone");

                OtpVerificationPage otpPage =
                        phonePage.goToOtpPage(args[0]);

                return otpPage.submitValidOtp(args[1]);

            case "facebook":
                FbGoogleAccountPage socialPage =
                        (FbGoogleAccountPage) methodPage.loginWith("facebook");

                socialPage.selectFirstAccount();

                return new ToiProfilePage(driver);

            default:
                throw new RuntimeException("Unsupported login method: " + method);
        }
    }

    private void validateArgs(String method, String[] args, int expectedSize) {
        if (args == null || args.length < expectedSize) {
            throw new IllegalArgumentException(
                    "Login method '" + method + "' requires " + expectedSize + " arguments"
            );
        }
    }
}