package pages.toi;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import pages.toi.login.AccountPage;
import pages.toi.login.LoginMethodPage;

public class ToiGuestPage extends BasePage {

    private By btnLogin = AppiumBy.accessibilityId("Đăng nhập");

    public ToiGuestPage(AppiumDriver driver){
        super(driver);
    }

    public boolean isGuest(){

        return isDisplayed(btnLogin);
    }

    public BasePage clickLogin(){

        click(btnLogin);

        // nếu có account lưu
        if(isDisplayed(AppiumBy.accessibilityId("Đăng nhập bằng tài khoản khác"))){
            return new AccountPage(driver);
        }

        // nếu không có account lưu
        return new LoginMethodPage(driver);
    }
}