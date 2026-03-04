package tests;

import base.BaseDriver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NavigationTest extends BaseDriver {

    By tabToi = AppiumBy.accessibilityId("Tôi");
    By menuVIP = AppiumBy.accessibilityId("VIP");

    @BeforeClass
    public void setup() throws Exception {
        initDriver();
    }

    @Test
    public void testNavigateToToi() throws InterruptedException {

        System.out.println("Navigate to Tôi page");

        Thread.sleep(3000);

        driver.findElement(tabToi).click();

        Thread.sleep(3000);

        boolean isVipVisible = driver.findElement(menuVIP).isDisplayed();

        Assert.assertTrue(isVipVisible, "VIP menu not found");

        System.out.println("VIP menu verified");

    }

    @AfterClass
    public void tearDown() {

        quitDriver();

    }
}