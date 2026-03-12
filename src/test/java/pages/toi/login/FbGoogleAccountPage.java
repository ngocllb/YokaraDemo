package pages.toi.login;

import base.BasePage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class FbGoogleAccountPage extends BasePage {

    // account đầu tiên trong list
    private By firstAccount =
            AppiumBy.xpath("(//android.widget.TextView)[1]");

    public FbGoogleAccountPage(AppiumDriver driver){
        super(driver);
    }

    public void selectFirstAccount(){

        click(firstAccount);
    }
}