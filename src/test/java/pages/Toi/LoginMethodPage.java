package pages.Toi;

import base.BasePage;
import base.LoginMethod;
import io.appium.java_client.AppiumDriver;

public class LoginMethodPage extends BasePage {

    private LoginMethod selector = new LoginMethod();

    public LoginMethodPage(AppiumDriver driver) {
        super(driver);
    }

    public void loginWithGoogle() {
        click(selector.loginGoogle);
    }

    public void skipLogin() {
        click(selector.btnBoQua);
    }
}