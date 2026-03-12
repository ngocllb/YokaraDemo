package pages.toi.login;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import pages.toi.ToiProfilePage;

public class LoginUIDPage extends BasePage {

    // UID input
    private By inputUID =
            AppiumBy.xpath("//android.widget.EditText[@password='false']");

    // PASSWORD input
    private By inputPassword =
            AppiumBy.xpath("//android.widget.EditText[@password='true']");

    // LOGIN button
    private By btnLogin =
            AppiumBy.accessibilityId("Đăng nhập");

    public LoginUIDPage(AppiumDriver driver){
        super(driver);
    }

    public ToiProfilePage loginByUID(String uid, String password){

        type(inputUID, uid);

        type(inputPassword, password);

        click(btnLogin);

        return new ToiProfilePage(driver);
    }
}