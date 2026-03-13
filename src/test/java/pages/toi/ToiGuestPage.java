package pages.toi;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.toi.login.AccountPage;
import pages.toi.login.LoginMethodPage;

public class ToiGuestPage extends BasePage {

    private By btnDangNhap = AppiumBy.accessibilityId("Đăng nhập");

    public ToiGuestPage(AppiumDriver driver){
        super(driver);
    }

    public boolean isGuest(){

        return isDisplayed(btnDangNhap);
    }

    public BasePage clickLogin(){

        click(btnDangNhap);

        // nếu có account lưu
        if(isDisplayed(AppiumBy.accessibilityId("Đăng nhập bằng tài khoản khác"))){
            return new AccountPage(driver);
        }

        // nếu không có account lưu
        return new LoginMethodPage(driver);
    }
    public void waitForGuestPage(){

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(btnDangNhap)
        );
    }
    public boolean isGuestPageDisplayed() {

        return isDisplayed(btnDangNhap);
    }
}