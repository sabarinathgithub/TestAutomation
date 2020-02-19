package tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class UiSelectorTest {
	AndroidDriver driver;

	@Test
	public void f() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		File app = new File("C:\\Users\\15132\\git\\testAutomation\\testAutomation\\src\\test\\resources\\apps\\com.davemac327.gesture.tool.apk");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Moto E4 Plus");
		capabilities.setCapability(MobileCapabilityType.UDID, "ZY2258RPB2");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

		URL url = new URL("http://127.0.0.1:4723/wd/hub");	  
		driver = new AndroidDriver(url, capabilities);	
		System.out.println("Gesture tool application is launched.");
		
		driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.davemac327.gesture.tool:id/addButton\")").click();
	}
}
