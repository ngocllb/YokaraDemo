package pages.toi.login;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import pages.toi.ToiProfilePage;

public class LoginUIDPage extends BasePage {

    // container để focus UID
    private By uidContainer =
            AppiumBy.accessibilityId("Mời nhập ID");

    // UID input
    private By inputUID =
            AppiumBy.xpath("//android.view.View[@content-desc='Mời nhập ID']//android.widget.EditText");

    // PASSWORD input
    private By inputPassword =
            AppiumBy.xpath("//android.widget.EditText[@hint='Vui lòng nhập mật khẩu']");

    // LOGIN button
    private By btnLogin =
            AppiumBy.accessibilityId("Đăng nhập");

    public LoginUIDPage(AppiumDriver driver){
        super(driver);
    }

    public ToiProfilePage loginByUID(String uid, String password){

        // focus UID field
        click(uidContainer);

        // nhập UID
        type(inputUID, uid);

        click(inputPassword);
        // nhập password
        type(inputPassword, password);

        // click login
        click(btnLogin);

        return new ToiProfilePage(driver);
    }
}