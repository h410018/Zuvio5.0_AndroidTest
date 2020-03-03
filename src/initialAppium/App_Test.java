package initialAppium;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class App_Test {

	public static void main(String[] args) throws InterruptedException {
//		AppiumDriver<MobileElement> driver = null;
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//		MobileElement email, password, login,chat_message;
//		// capabilities.setCapability(CapabilityType.BROWSER_NAME, "");// �o�y���O������
//		capabilities.setCapability("deviceName", "phone");
//		capabilities.setCapability("uuid", "RAMDU16325000239");
//		capabilities.setCapability("platformVersion", "6.0.1");
//		capabilities.setCapability("platformName", "Android");
//		capabilities.setCapability("appPackage", "com.zuvio.student");
//		capabilities.setCapability("appActivity", "com.zuvio.student.login.LoginActivity");
//		capabilities.setCapability("noRest", "true");
//
//		// Instantiate Appium Driver
//		try {
//			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
//
//		} catch (MalformedURLException e) {
//			System.out.println(e.getMessage());
//		}
		InitialAppium ia = new InitialAppium();
		ia.initial();
		
		//wait command...........................................
		
		MobileElement email, password, login;
		Thread.sleep(10000);
		ia.driver.findElement(By.id("com.zuvio.student:id/login_button")).click();

		email = ia.driver.findElement(By.id("com.zuvio.student:id/email_editText"));
		email.sendKeys("s001@com.tw");
		password = ia.driver.findElement(By.id("com.zuvio.student:id/password_editText"));
		password.sendKeys("123");
		if (email.getText() != null && password.getText() != null) {
			login = ia.driver.findElement(By.id("com.zuvio.student:id/login_button"));
			login.click();
		}
		Thread.sleep(2000);
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		TouchAction action = new TouchAction(ia.driver);
		action.tap(PointOption.point(85, 100)).perform();// close guide view
		ia.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		// action.tap(PointOption.point(370, 1210)).perform();
		// driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Thread.sleep(2000);
		ia.driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();// allow access
																										// permission
//		action.tap(PointOption.point(870, 1390)).perform();// go to shrimp
//
//		ia.driver.findElement(By.id("com.zuvio.student:id/favorite_imageView")).click();
//		ia.driver.findElement(By.id("com.zuvio.student:id/name_textView")).click();
//		chat_message = ia.driver.findElement(By.id("com.zuvio.student:id/edittext_group_chat_message"));
//		
//		while(true) {
//			for(int i = 0; i< 10 ; i++) {
//				chat_message.sendKeys(""+i);
//				ia.driver.findElement(By.id("com.zuvio.student:id/button_message_send")).click();
//				chat_message.sendKeys("");
//			}
//		}
		// action.press(PointOption.point(360,850)).moveTo(PointOption.point(360,
		// 1230)).release().perform();

	}

}
