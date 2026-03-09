package pages.toi.login;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import pages.toi.ToiProfilePage;

public class LoginUIDPage extends BasePage {

    // container để focus UID input
    private By uidContainer =
            AppiumBy.accessibilityId("Mời nhập ID");

    // UID input
    private By inputUID =
            AppiumBy.className("android.widget.EditText");

    // password input
    private By inputPassword =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().className(\"android.widget.EditText\").password(true)"
            );

    // login button
    private By btnLogin =
            AppiumBy.accessibilityId("Đăng nhập");

    public LoginUIDPage(AppiumDriver driver){
        super(driver);
    }

    public ToiProfilePage loginByUID(String uid, String password){

        // focus UID field
        click(uidContainer);

        type(inputUID, uid);

        // nhập password
        click(inputPassword);

        type(inputPassword, password);

        // click login
        click(btnLogin);

        return new ToiProfilePage(driver);
    }
}