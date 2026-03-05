package tests;

import base.BaseDriver;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseDriver {

    By tabToi = AppiumBy.accessibilityId("Tôi");
    By menuVIP = AppiumBy.accessibilityId("VIP");

    @Test
    @Description("Navigate to Tôi page and verify VIP menu")
    public void testNavigateToToi() {

        clickToiTab();

        verifyVipMenu();
    }

    @Step("Click tab Tôi")
    public void clickToiTab(){

        wait.until(ExpectedConditions.elementToBeClickable(tabToi)).click();

    }

    @Step("Verify VIP menu is displayed")
    public void verifyVipMenu(){

        boolean isVipVisible =
                wait.until(ExpectedConditions.visibilityOfElementLocated(menuVIP))
                        .isDisplayed();

        Assert.assertTrue(isVipVisible,"VIP menu not found");

    }
}