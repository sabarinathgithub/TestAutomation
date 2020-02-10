package tests;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;

public class FindElementsTest {
	private AppiumDriver driver;

	@BeforeMethod
	public void beforeMethod() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Moto E4 Plus");
		cap.setCapability(MobileCapabilityType.UDID, "ZY2258RPB2");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
		cap.setCapability("appPackage", "com.android.settings");
		cap.setCapability("appActivity", "com.android.settings.Settings");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, cap);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void f() {
		boolean flag = false;
		List<WebElement> lst = driver.findElementsById("android:id/title");
		for(WebElement element : lst) {
			System.out.println("Element is: "+ element.getText());
			if(element.getAttribute("text").equals("Data usage")) {
				element.click();
				flag = true;
			}
			if(flag) {
				break;
			}
		}
	}


	@AfterMethod
	public void afterMethod() {
	}

}
