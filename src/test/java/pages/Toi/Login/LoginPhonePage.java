package pages.Toi.Login;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPhonePage extends BasePage {

    /* ================= ELEMENTS ================= */

    @AndroidFindBy(xpath = "//android.widget.EditText[@hint=' Nhập số điện thoại']")
    private WebElement inputPhone;

    @AndroidFindBy(accessibility = "Tiếp theo")
    private WebElement btnNext;

    @AndroidFindBy(accessibility = "(+84)")
    private WebElement countryCode;

    /* ================= CONSTRUCTOR ================= */

    public LoginPhonePage(AppiumDriver driver) {

        super(driver);

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /* ================= ACTIONS ================= */

    @Step("Nhập số điện thoại: {phone}")
    public LoginPhonePage enterPhone(String phone) {

        inputPhone.clear();
        inputPhone.sendKeys(phone);

        return this;
    }

    @Step("Bấm nút Tiếp theo để nhận OTP")
    public LoginPhonePage clickNext() {

        btnNext.click();

        return this;
    }

    @Step("Đăng nhập bằng số điện thoại")
    public LoginPhonePage loginWithPhone(String phone) {

        return enterPhone(phone)
                .clickNext();
    }

}