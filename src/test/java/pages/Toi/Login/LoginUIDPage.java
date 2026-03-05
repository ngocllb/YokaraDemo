package pages.Toi.Login;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.Toi.ToiProfilePage;

public class LoginUIDPage extends BasePage {

    /* ================= ELEMENTS ================= */

    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Mời nhập ID']")
    private WebElement inputUID;

    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Vui lòng nhập mật khẩu']")
    private WebElement inputPassword;

    @AndroidFindBy(accessibility = "Đăng nhập")
    private WebElement btnLogin;

    @AndroidFindBy(accessibility = "Quên mật khẩu")
    private WebElement btnForgotPassword;

    /* ================= CONSTRUCTOR ================= */

    public LoginUIDPage(AppiumDriver driver) {

        super(driver);

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /* ================= ACTIONS ================= */

    @Step("Nhập UID: {uid}")
    public LoginUIDPage enterUID(String uid) {

        inputUID.clear();
        inputUID.sendKeys(uid);

        return this;
    }

    @Step("Nhập mật khẩu")
    public LoginUIDPage enterPassword(String password) {

        inputPassword.clear();
        inputPassword.sendKeys(password);

        return this;
    }

    @Step("Bấm nút Đăng nhập")
    public ToiProfilePage submitLogin() {

        btnLogin.click();

        return new ToiProfilePage(driver);
    }

    @Step("Đăng nhập với UID")
    public ToiProfilePage login(String uid, String password) {

        return enterUID(uid)
                .enterPassword(password)
                .submitLogin();
    }

    @Step("Bấm Quên mật khẩu")
    public void clickForgotPassword() {

        btnForgotPassword.click();
    }
}