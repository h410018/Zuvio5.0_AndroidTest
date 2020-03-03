package initialAppium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class InitialAppium {
	public AppiumDriver<MobileElement> driver;
	String appPackage = "com.zuvio.student";
	String appActivity = "com.zuvio.student.LauncherActivity";

	public void initial() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		// capabilities.setCapability(CapabilityType.BROWSER_NAME, "");//不一定要加
		capabilities.setCapability("deviceName", "phone");
		capabilities.setCapability("uuid", "F5AZFG06J546");// 需要變動的
		capabilities.setCapability("platformVersion", "6.0.1");// 需要變動的
		capabilities.setCapability("platformName", "Android");// 需要變動的
		capabilities.setCapability("appPackage", appPackage);// 需要變動的
		capabilities.setCapability("appActivity", appActivity);// 需要變動的
		capabilities.setCapability("noRest", "true");

		capabilities.setCapability("unicodeKeyboard", "true");// unicodeKeyboard是使用unicode編碼方式傳送字串
		capabilities.setCapability("resetKeyboard", "true");// resetKeyboard是將鍵盤隱藏起來
		// capabilities.setCapability("newCommandTimeout", 6000);

//		 mCurrentFocus=Window{8261ee2 u0 com.example.zuvio.myapplication/com.example.zu
//			 io.myapplication.MainActivity}
		// Instantiate Appium Driver
		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
	}
}
