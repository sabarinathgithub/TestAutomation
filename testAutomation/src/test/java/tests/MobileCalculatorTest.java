package tests;

import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileCalculatorTest extends ExtentReportsDemo{
	
	static AppiumDriver<MobileElement> driver;
	ExtentTest test1;
	
	@Test
	private void mobileCalculatorExampleTest() {
		 // creates a toggle for the given test, adds all log events under it    
		test1 = extent.createTest("MyFirstTest -->", "mobileCalculatorExampleTest");
		try {
			test1.log(Status.INFO, "Test started....");
			openCalculator();
			test1.log(Status.PASS, "Appium opened Calculator Application Successfully...");
			addNumbers();
			test1.log(Status.PASS, "Addition operation is completed successfully....");
			test1.log(Status.INFO, "Test completed...");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	private void openCalculator() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Moto E4 Plus");
		cap.setCapability(MobileCapabilityType.UDID, "ZY2258RPB2");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
		cap.setCapability("appPackage", "com.google.android.calculator");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, cap);
		System.out.println("Appium started the Application successfully...");	
		
		Thread.sleep(500);
	}
	
	private void addNumbers() {
		MobileElement two = driver.findElement(By.id("com.google.android.calculator:id/digit_2"));
		MobileElement plus = driver.findElement(By.id("com.google.android.calculator:id/op_add"));
		MobileElement six = driver.findElement(By.id("com.google.android.calculator:id/digit_6"));
		MobileElement equals = driver.findElement(By.id("com.google.android.calculator:id/eq"));
		
		two.click();
		plus.click();
		six.click();
		equals.click();
		
		MobileElement total = driver.findElement(By.id("com.google.android.calculator:id/result_final"));
		String result = total.getText();
		System.out.println("Result is: "+ result);
		System.out.println("Completed...");
	}

}
