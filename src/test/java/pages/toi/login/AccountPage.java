package pages.toi.login;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class AccountPage extends BasePage {

    public AccountPage(AppiumDriver driver){
        super(driver);
    }

    /**
     * Chọn account đã lưu theo UID
     * Ví dụ: 6069820
     */
    public void selectAccountByUID(String uid) {

        driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiSelector()" +
                                ".className(\"android.view.View\")" +
                                ".descriptionContains(\"ID: " + uid + "\")"
                )
        ).click();
    }

    /**
     * Chọn đăng nhập bằng tài khoản khác
     */
    public void selectAnotherMethodLogin() {

        driver.findElement(
                AppiumBy.accessibilityId("Đăng nhập bằng tài khoản khác")
        ).click();
    }

    /**
     * Chọn account đầu tiên (dùng cho social login)
     */
    public void selectFirstAccount(){

        driver.findElements(
                AppiumBy.androidUIAutomator(
                        "new UiSelector().className(\"android.view.View\").clickable(true)"
                )
        ).get(0).click();
    }
}