package pages.toi.login;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import pages.toi.ToiProfilePage;

public class LoginPhonePage extends BasePage {

    private By phoneInput = By.xpath("//android.widget.EditText");

    private By btnNext = AppiumBy.accessibilityId("Tiếp theo");

    private By otpInput = By.xpath("//android.widget.EditText");

    private By btnConfirm = AppiumBy.accessibilityId("Xác nhận");

    public LoginPhonePage(AppiumDriver driver){
        super(driver);
    }

    public ToiProfilePage loginByPhone(String phone, String otp){

        find(phoneInput).sendKeys(phone);

        click(btnNext);

        find(otpInput).sendKeys(otp);

        click(btnConfirm);

        return new ToiProfilePage(driver);
    }

}