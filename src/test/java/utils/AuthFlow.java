package utils;

import base.BasePage;
import io.appium.java_client.AppiumDriver;
import pages.toi.ToiGuestPage;
import pages.toi.ToiProfilePage;
import pages.toi.login.*;

public class AuthFlow {

    private AppiumDriver driver;

    public AuthFlow(AppiumDriver driver){
        this.driver = driver;
    }

    public ToiProfilePage login(String method, String... args){

        ToiGuestPage guestPage = new ToiGuestPage(driver);

        BasePage page = guestPage.clickLogin();

        LoginMethodPage methodPage;

        if(page instanceof AccountPage){

            AccountPage accountPage = (AccountPage) page;

            accountPage.selectAnotherMethodLogin();

            methodPage = new LoginMethodPage(driver);

        }else{

            methodPage = (LoginMethodPage) page;
        }

        switch(method.toLowerCase()){

            case "uid":

                LoginUIDPage uidPage =
                        (LoginUIDPage) methodPage.loginWith("uid");

                return uidPage.loginByUID(args[0], args[1]);

            case "phone":

                LoginPhonePage phonePage =
                        (LoginPhonePage) methodPage.loginWith("phone");

                return phonePage.loginByPhone(args[0], args[1]);

            case "facebook":

                AccountPage socialPage =
                        (AccountPage) methodPage.loginWith("facebook");

                socialPage.selectFirstAccount();

                return new ToiProfilePage(driver);

            default:
                throw new RuntimeException("Unsupported login method");
        }
    }
}