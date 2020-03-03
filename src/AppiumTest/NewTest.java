package AppiumTest;

import org.testng.annotations.Test;

import initialAppium.InitialAppium;

import org.testng.annotations.AfterClass;

public class NewTest {

	InitialAppium ia ;
	
	@Test
	public void plus() {
		ia = new InitialAppium();
		ia.initial();
		// 获取1
		ia.driver.findElementById("com.android.calculator2:id/digit_1").click();
		// 获取+
		ia.driver.findElementById("com.android.calculator2:id/op_add").click();
		// 获取2
		ia.driver.findElementById("com.android.calculator2:id/digit_2").click();
		// 获取=
		ia.driver.findElementById("com.android.calculator2:id/eq").click();

	}

	@AfterClass
	public void tearDown() throws Exception {

		ia.driver.quit();

	}

}
