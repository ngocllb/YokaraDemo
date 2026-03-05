package pages.Toi.Login;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import pages.Toi.ToiProfilePage;
import utils.SocialLoginHandler;

public class SocialAccountPage extends BasePage {

    private SocialLoginHandler handler;

    public SocialAccountPage(AppiumDriver driver) {

        super(driver);

        handler = new SocialLoginHandler(driver);
    }

    public ToiProfilePage login(){

        handler.handle();

        return new ToiProfilePage(driver);
    }
}