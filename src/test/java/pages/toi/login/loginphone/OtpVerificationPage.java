package pages.toi.login.loginphone;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.toi.ToiProfilePage;

public class OtpVerificationPage extends BasePage {

    private final By otpTitle = AppiumBy.xpath(
            "//android.view.View[contains(@content-desc,'Nhập mã OTP')]"
    );

    private final By otpInput = By.xpath("//android.widget.EditText");

    private final By btnConfirm = AppiumBy.accessibilityId("Xác nhận");

    private final By btnResendCode = AppiumBy.accessibilityId("Gửi lại mã");

    private final By otpErrorMessage = AppiumBy.xpath(
            "//*[contains(@content-desc,'Mã kích hoạt không đúng. Vui lòng kiểm tra lại')]"
    );

    public OtpVerificationPage(AppiumDriver driver) {
        super(driver);
    }

    public boolean isOtpPageDisplayed() {
        return isDisplayed(otpTitle);
    }

    public void enterOtp(String otp) {
        type(otpInput, otp);
    }

    public void clickConfirm() {
        click(btnConfirm);
    }

    public void clickResendCode() {
        click(btnResendCode);
    }

    public boolean isOtpErrorDisplayed() {
        return isDisplayed(otpErrorMessage);
    }

    public void waitForOtpError() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(otpErrorMessage));
    }

    public ToiProfilePage submitValidOtp(String otp) {
        enterOtp(otp);
        clickConfirm();
        return new ToiProfilePage(driver);
    }

    public OtpVerificationPage submitInvalidOtp(String otp) {
        enterOtp(otp);
        clickConfirm();
        return this;
    }

    public boolean isLoginSuccess(String expectedUid) {
        try {
            return new ToiProfilePage(driver).isUserIdDisplayed(expectedUid);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isStillOnOtpPage() {
        return isDisplayed(btnConfirm);
    }
}