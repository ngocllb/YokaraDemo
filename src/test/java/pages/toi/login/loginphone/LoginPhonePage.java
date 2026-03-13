package pages.toi.login.loginphone;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LoginPhonePage extends BasePage {

    private final By phoneInput = By.xpath("//android.widget.EditText");
    private final By btnNext = AppiumBy.accessibilityId("Tiếp theo");

    public LoginPhonePage(AppiumDriver driver){
        super(driver);
    }

    public boolean isDisplayedPage() {
        return isDisplayed(btnNext);
    }

    public OtpVerificationPage goToOtpPage(String phone){

        type(phoneInput, phone);
        click(btnNext);

        return new OtpVerificationPage(driver);
    }
}