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
import swipe.Swipe;

public class App_Test {

	public static void main(String[] args) throws InterruptedException {

		InitialAppium ia = new InitialAppium();
		Swipe swipe = new Swipe();
		
		ia.initial();
		ia.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		MobileElement email, password, login, confirm;
		
		ia.driver.findElement(By.id("com.zuvio.student:id/login_button")).click();

		email = ia.driver.findElement(By.id("com.zuvio.student:id/email_editText"));
		email.sendKeys("boyuan@zuvio.com");
		password = ia.driver.findElement(By.id("com.zuvio.student:id/password_editText"));
		password.sendKeys("123");
		
		if (email.getText() != null && password.getText() != null) {
			login = ia.driver.findElement(By.id("com.zuvio.student:id/login_button"));
			login.click();
		}
		Thread.sleep(2000);
		
		confirm = ia.driver.findElementById("com.zuvio.student:id/confirm_fragment_sure_button");
		
		if(confirm.isDisplayed()==true || confirm.isEnabled()==true) {
			confirm.click();
		}
		
		Thread.sleep(2000);
		
		int count = 0;
		while(count<10) {
			swipe.SwipeDown(ia.driver);
			count++;
		}
		
		
		ia.driver.quit();

	}

}
