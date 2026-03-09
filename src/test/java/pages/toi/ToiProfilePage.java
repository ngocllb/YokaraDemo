package pages.toi;

import base.BasePage;
import base.BottomNav;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ToiProfilePage extends BasePage {

    BottomNav bottomNav;

    // UID hiển thị trên profile
    private By userId =
            AppiumBy.xpath("//android.widget.ImageView[@content-desc]");

    public ToiProfilePage(AppiumDriver driver){
        super(driver);
        bottomNav = new BottomNav(driver);
    }

    public String getUserId(){

        return find(userId).getAttribute("content-desc");
    }

    public boolean isUserIdDisplayed(String uid){

        By userId =
                AppiumBy.xpath("//android.widget.ImageView[@content-desc='" + uid + "']");

        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(userId));
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public BottomNav nav(){
        return bottomNav;
    }
}