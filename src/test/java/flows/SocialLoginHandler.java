package flows;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SocialLoginHandler {

    private final AppiumDriver driver;

    public SocialLoginHandler(AppiumDriver driver){
        this.driver = driver;
    }

    private final By googleAccount =
            By.id("com.google.android.gms:id/account_name");

    private final By facebookContinue =
            By.id("com.facebook.katana:id/continue_button");

    private final By zaloAccount =
            By.id("com.zing.zalo:id/tv_name");

    public void handle(){

        if (clickFirstIfPresent(googleAccount)) {
            return;
        }

        if (clickFirstIfPresent(facebookContinue)) {
            return;
        }

        clickFirstIfPresent(zaloAccount);
    }

    private boolean clickFirstIfPresent(By locator) {
        List<WebElement> matches = driver.findElements(locator);

        if (matches.isEmpty()) {
            return false;
        }

        matches.get(0).click();
        return true;
    }
}