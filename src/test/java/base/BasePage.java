package base;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class BasePage {

    protected AppiumDriver driver;
    protected WebDriverWait wait;

    public BasePage(AppiumDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    protected WebElement find(By locator) {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }

    protected void click(By locator) {

        WebElement element =
                wait.until(ExpectedConditions.elementToBeClickable(locator));

        element.click();
    }

    protected void type(By locator, String text){

        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        element.click();
        element.clear();
        element.sendKeys(text);
    }

    protected boolean isDisplayed(By locator) {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(locator)
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    protected void clickByKey(Map<String, By> map, String key){

        By locator = map.get(key.toLowerCase());

        if(locator == null){
            throw new RuntimeException("Locator not found for key: " + key);
        }

        click(locator);
    }
}