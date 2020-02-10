package tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class GestureToolButtonTest extends ExtentReportsDemo{
	AppiumDriver driver;
	DesiredCapabilities capabilities;
	ExtentTest test1, test2, test3;

	@BeforeClass
	private void configure() throws MalformedURLException {
		test1 = extent.createTest("BeforeClass", "Configure method in Before Class");
		capabilities = new DesiredCapabilities();
		File app = new File("C:\\Users\\15132\\git\\testAutomation\\testAutomation\\src\\test\\resources\\apps\\com.davemac327.gesture.tool.apk");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Moto E4 Plus");
		capabilities.setCapability(MobileCapabilityType.UDID, "ZY2258RPB2");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

		URL url = new URL("http://127.0.0.1:4723/wd/hub");	  
		driver = new AppiumDriver<MobileElement>(url, capabilities);
		test1.log(Status.PASS, "Gesture tool application is launched.");
		System.out.println("Gesture tool application is launched.");
	}

	@Test
	private void test1FindElement() throws MalformedURLException, InterruptedException {
		test2 = extent.createTest("Test1", "findElement Test");
		driver.findElement(By.id("com.davemac327.gesture.tool:id/addButton")).click();	  
		Thread.sleep(1000);
		test2.log(Status.PASS, "Add Gesture button is clicked.");
		System.out.println("Add Gesture button is clicked.");
		
		WebElement nameText = driver.findElementById("com.davemac327.gesture.tool:id/gesture_name");
		System.out.println("Name file attribute is: "+ nameText.getAttribute("enabled"));
		
		List<WebElement> buttons = driver.findElementsByClassName("android.widget.Button");
		for(WebElement button : buttons) {
			System.out.println("button text is: "+ button.getAttribute("text"));
			if(button.getText().equals("Discard")) {
				button.click();
				Thread.sleep(1000);
				System.out.println("Discard button is clicked.");
				test2.log(Status.PASS, "Discard button is clicked.");
			}
		}		
	}
	
	
	@Test
	private void test2FindElements() {
		test3 = extent.createTest("Test2", "FindElements");
		List<WebElement> buttons = driver.findElementsByClassName("android.widget.Button");
		buttons.forEach(b -> {
			System.out.println("button text is: "+ b.getAttribute("text"));
		});
	}
}
