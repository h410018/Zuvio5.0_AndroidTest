package login;

import org.testng.annotations.Test;

import initialAppium.InitialAppium;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.validator.PublicClassValidator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.python.modules.operator;

import swipe.Swipe;

//import org.sikuli.script.*;

public class AppLogin {

//	@BeforeSuite:        被注释的方法将在所有测试运行前运行
//	@AfterSuite:        被注释的方法将在所有测试运行后运行
//	@BeforeTest:        被注释的方法将在测试运行前运行
//	@AfterTest:        被注释的方法将在测试运行后运行
//	@BeforeGroups:        被配置的方法将在列表中的gourp前运行。这个方法保证在第一个属于这些组的测试方法调用前立即执行。
//	@AfterGroups:        被配置的方法将在列表中的gourp后运行。这个方法保证在最后一个属于这些组的测试方法调用后立即执行。
//	@BeforeClass:        被注释的方法将在当前类的第一个测试方法调用前运行。
//	@AfterClass:        被注释的方法将在当前类的所有测试方法调用后运行。
//	@BeforeMethod:        被注释的方法将在每一个测试方法@test调用前运行。
//	@AfterMethod:        被注释的方法将在每一个测试方法@test调用后运行。

	InitialAppium ia;
	String login_btn_id = "com.zuvio.student:id/login_button";
	String email_editText_id = "com.zuvio.student:id/email_editText";
	String password_editText_id = "com.zuvio.student:id/password_editText";
	String email_error_textView_id = "com.zuvio.student:id/email_error_textView";
	String password_error_textView_id = "com.zuvio.student:id/password_error_textView";
	
	@BeforeMethod
	public void beforeMethod() {
		ia = new InitialAppium();
		ia.initial();
		ia.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	@Parameters({"e_mail","ps"})
	public void login_successfully(@Optional("s001@com.tw")String e_mail,@Optional("123")String ps) throws InterruptedException {

		Thread.sleep(2000);
		//ia.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		MobileElement email, password, login, keyword;
		ia.driver.findElement(By.id(login_btn_id)).click();

		email = ia.driver.findElement(By.id(email_editText_id));
		email.sendKeys(e_mail);
		password = ia.driver.findElement(By.id(password_editText_id));
		password.sendKeys(ps);
		if (email.getText() != null && password.getText() != null) {
			login = ia.driver.findElement(By.id(login_btn_id));
			login.click();
		}

	}
	
	@Test(priority = 5)
	public void error_msg_5() {//Show password is wrong error message.
		
		//ia.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		MobileElement email, password, login, keyword;
		ia.driver.findElement(By.id(login_btn_id)).click();
		email = ia.driver.findElement(By.id(email_editText_id));
		email.sendKeys("s001@com.tw");
		password = ia.driver.findElement(By.id(password_editText_id));
		password.sendKeys("***");
		if (email.getText() != null && password.getText() != null) {
			login = ia.driver.findElement(By.id(login_btn_id));
			login.click();
		}
		WebDriverWait wait = new WebDriverWait(ia.driver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(password_error_textView_id)));//wait for error
		Assert.assertEquals(ia.driver.findElementById(password_error_textView_id).getText(), "密碼錯誤");	//Assert error message
	}
	
	@Test(priority = 4)
	public void error_msg_4() {//Show email not found error message.
		
		//ia.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		MobileElement email, password, login, keyword;
		ia.driver.findElement(By.id(login_btn_id)).click();
		email = ia.driver.findElement(By.id(email_editText_id));
		email.sendKeys("*****");
		password = ia.driver.findElement(By.id(password_editText_id));
		password.sendKeys("123");
		if (email.getText() != null && password.getText() != null) {
			login = ia.driver.findElement(By.id(login_btn_id));
			login.click();
		}
		WebDriverWait wait = new WebDriverWait(ia.driver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(email_error_textView_id)));//wait for error
		Assert.assertEquals(ia.driver.findElementById(email_error_textView_id).getText(), "查無帳號");	//Assert error message
		
	}
	
	@Test(priority = 3)
	public void error_msg_3() { //Error message with empty Email
		ia.driver.findElement(By.id(login_btn_id)).click();
		MobileElement email, password, login;
		WebDriverWait wait = new WebDriverWait(ia.driver,5);
		password = ia.driver.findElement(By.id(password_editText_id));
		password.sendKeys("zuvio7878");
		ia.driver.findElement(By.id(login_btn_id)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(email_error_textView_id)));//wait for error
		Assert.assertEquals(ia.driver.findElementById(email_error_textView_id).getText(), "尚未填寫");	//Assert error message

	}

	
	
	@Test(priority = 2)
	public void error_msg_2() { //Error message with empty Password
		ia.driver.findElement(By.id(login_btn_id)).click();
		MobileElement email, password, login;
		WebDriverWait wait = new WebDriverWait(ia.driver,5);
		email = ia.driver.findElement(By.id(email_editText_id));
		email.sendKeys("s001@com.tw");
		ia.driver.findElement(By.id(login_btn_id)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(password_error_textView_id)));//wait for error
		Assert.assertEquals(ia.driver.findElementById(password_error_textView_id).getText(), "尚未填寫");//Assert error message

	}

	@Test(priority = 1)
	public void error_msg_1() {//Error message with empty Email and Password.
		WebDriverWait wait = new WebDriverWait(ia.driver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(login_btn_id)));//wait for login btn
		ia.driver.findElement(By.id(login_btn_id)).click();
		ia.driver.findElement(By.id(login_btn_id)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(email_error_textView_id)));//wait for error
		Assert.assertEquals(ia.driver.findElementById(email_error_textView_id).getText(), "尚未填寫");//Assert error message
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.zuvio.student:id/password_error_textView")));//wait for error
		//Assert.assertEquals(ia.driver.findElementById("com.zuvio.student:id/password_error_textView").getText(), "尚未填寫");	//Assert error message
	}

	@Test(priority = 0)
	public void back_to_mainpage() {// Press login button then press back button.
		MobileElement back_btn;
		ia.driver.findElement(By.id(login_btn_id)).click();
		WebDriverWait wait = new WebDriverWait(ia.driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(
				"android.widget.ImageButton"))); // wait for back_btn
		ia.driver.findElementByClassName(
				"android.widget.ImageButton")
				.click();
	}

	@AfterMethod
	public void afterMethod() {
		try {
			Thread.sleep(2000);
			ia.driver.quit();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
