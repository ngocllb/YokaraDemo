package base;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;
import java.util.List;

public class BasePage {

    protected AppiumDriver driver;
    protected WebDriverWait wait;

    public BasePage(AppiumDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    /* ================= FIND ================= */

    protected WebElement find(By locator) {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }

    protected List<WebElement> finds(By locator) {

        return driver.findElements(locator);
    }

    /* ================= CLICK ================= */

    protected void click(By locator) {

        WebElement element =
                wait.until(ExpectedConditions.elementToBeClickable(locator));

        element.click();
    }

    /* ================= TYPE ================= */

    protected void type(By locator, String text){

        WebElement element =
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        element.click();
        element.clear();
        element.sendKeys(text);
    }

    /* ================= DISPLAY ================= */

    protected boolean isDisplayed(By locator) {

        try {
            return driver.findElements(locator).size() > 0;
        }
        catch (Exception e){
            return false;
        }
    }

    /* ================= SWIPE ================= */

    public void swipeUp() {

        Dimension size = driver.manage().window().getSize();

        int width = size.width;
        int height = size.height;

        int startX = width / 2;
        int startY = (int) (height * 0.8);
        int endY = (int) (height * 0.3);

        driver.executeScript("mobile: swipeGesture", Map.of(
                "left", startX,
                "top", startY,
                "width", 0,
                "height", height,
                "direction", "up",
                "percent", 0.7
        ));
    }

    /* ================= SCROLL ================= */

    public void scrollToElement(By locator) {

        int maxScroll = 6;

        for (int i = 0; i < maxScroll; i++) {

            if (isDisplayed(locator)) {
                return;
            }

            swipeUp();
        }

        throw new RuntimeException("Không tìm thấy element sau khi scroll: " + locator);
    }

    /* ================= MAP CLICK ================= */

    protected void clickByKey(Map<String, By> map, String key){

        By locator = map.get(key.toLowerCase());

        if(locator == null){
            throw new RuntimeException("Locator not found for key: " + key);
        }

        click(locator);
    }
}