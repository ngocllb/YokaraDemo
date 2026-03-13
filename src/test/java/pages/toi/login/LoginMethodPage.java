package pages.toi.login;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import pages.toi.login.loginphone.LoginPhonePage;

import java.util.HashMap;
import java.util.Map;

public class LoginMethodPage extends BasePage {

    private Map<String, By> loginMethods = new HashMap<>();

    public LoginMethodPage(AppiumDriver driver) {

        super(driver);

        loginMethods.put("facebook", AppiumBy.accessibilityId("Đăng nhập Facebook"));
        loginMethods.put("google", AppiumBy.accessibilityId("Đăng nhập bằng Google"));
        loginMethods.put("zalo", AppiumBy.accessibilityId("Đăng nhập Zalo"));
        loginMethods.put("phone", AppiumBy.accessibilityId("Đăng nhập số điện thoại"));
        loginMethods.put("uid", AppiumBy.accessibilityId("Đăng nhập bằng ID"));
    }


    public BasePage loginWith(String method){

        By locator = loginMethods.get(method.toLowerCase());

        if(locator == null){
            throw new RuntimeException("Unsupported login method: " + method);
        }

        click(locator);

        switch(method.toLowerCase()){

            case "uid":
                return new LoginUIDPage(driver);

            case "phone":
                return new LoginPhonePage(driver);

            default:
                return new AccountPage(driver);
        }
    }
}