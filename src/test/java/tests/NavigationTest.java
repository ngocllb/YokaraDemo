package tests;

import base.BaseDriver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseDriver {

    By tabToi = AppiumBy.accessibilityId("Tôi");
    By menuVIP = AppiumBy.accessibilityId("VIP");

    @Test
    public void testNavigateToToi() {

        System.out.println("Navigate to Tôi page");

        wait.until(ExpectedConditions.elementToBeClickable(tabToi)).click();

        boolean isVipVisible =
                wait.until(ExpectedConditions.visibilityOfElementLocated(menuVIP))
                        .isDisplayed();

        Assert.assertTrue(isVipVisible, "VIP menu not found");

        System.out.println("VIP menu verified");
    }
}