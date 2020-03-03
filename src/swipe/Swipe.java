package swipe;


import org.openqa.selenium.Dimension;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class Swipe {
    // ¤W·Æ
    public void SwipeUp(AppiumDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction(driver).longPress(PointOption.point(width / 2, 100))
                .moveTo(PointOption.point(width / 2, height - 100)).release()
                .perform();
    }

    // ¤U·Æ
    public void SwipeDown(AppiumDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction(driver)
                .longPress(PointOption.point(width / 2, height - 100))
                .moveTo(PointOption.point(width / 2, 100)).release().perform();
    }

    // ¥ª·Æ
    public void SwipeLeft(AppiumDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction(driver)
                .longPress(PointOption.point(width - 100, height / 2))
                .moveTo(PointOption.point(100, height / 2)).release().perform();
    }

    // ¥k·Æ
    public void SwipeRight(AppiumDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction(driver).longPress(PointOption.point(100, height / 2))
                .moveTo(PointOption.point(width - 100, height / 2)).release()
                .perform();
    }
}
