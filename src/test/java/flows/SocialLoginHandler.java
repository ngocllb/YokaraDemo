package flows;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SocialLoginHandler {

    private AppiumDriver driver;

    public SocialLoginHandler(AppiumDriver driver){
        this.driver = driver;
    }

    private By googleAccount =
            By.id("com.google.android.gms:id/account_name");

    private By facebookContinue =
            By.id("com.facebook.katana:id/continue_button");

    private By zaloAccount =
            By.id("com.zing.zalo:id/tv_name");

    public void handle(){

        if(isGoogleLogin()){
            selectGoogleAccount();
        }
        else if(isFacebookLogin()){
            continueFacebook();
        }
        else if(isZaloLogin()){
            selectZaloAccount();
        }

    }

    private boolean isGoogleLogin(){

        return driver.findElements(googleAccount).size() > 0;

    }

    private boolean isFacebookLogin(){

        return driver.findElements(facebookContinue).size() > 0;

    }

    private boolean isZaloLogin(){

        return driver.findElements(zaloAccount).size() > 0;

    }

    private void selectGoogleAccount(){

        List<WebElement> accounts = driver.findElements(googleAccount);

        if(accounts.size() > 0){
            accounts.get(0).click();
        }

    }

    private void continueFacebook(){

        driver.findElement(facebookContinue).click();

    }

    private void selectZaloAccount(){

        List<WebElement> accounts = driver.findElements(zaloAccount);

        if(accounts.size() > 0){
            accounts.get(0).click();
        }

    }

}