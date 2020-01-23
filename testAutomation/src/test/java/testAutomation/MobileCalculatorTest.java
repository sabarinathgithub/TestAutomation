package testAutomation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.asserts.Assertion;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class MobileCalculatorTest {
	
	static AppiumDriver<MobileElement> driver;

	public static void main(String[] args) {
		try {
			openCalculator();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public static void openCalculator() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Moto E4 Plus");
		cap.setCapability("uid", "ZY2258RPB2");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "7.1.1");
		cap.setCapability("appPackage", "com.google.android.calculator");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, cap);
		System.out.println("Appium started the Application successfully...");	
		Thread.sleep(500);
		
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
	}
	
	private static void additionTest() {
		MobileElement two = driver.findElement(By.id("	com.google.android.calculator:id/digit_2"));
		MobileElement plus = driver.findElement(By.id("com.google.android.calculator:id/op_add"));
		MobileElement six = driver.findElement(By.id("com.google.android.calculator:id/digit_6"));
		MobileElement equals = driver.findElement(By.id("com.google.android.calculator:id/eq"));
		MobileElement total = driver.findElement(By.className("android.widget.TextView"));
		
		two.click();
		plus.click();
		six.click();
		equals.click();
		
		String result = total.getText();
		System.out.println("Result is: "+ result);
		System.out.println("Completed...");
	}

}
