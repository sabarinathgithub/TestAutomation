package tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class WebElements_Inside_WebElement {
	AppiumDriver driver;
  @Test
  public void f() throws MalformedURLException, InterruptedException {
	  DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Moto E4 Plus");
		capabilities.setCapability(MobileCapabilityType.UDID, "ZY2258RPB2");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
		capabilities.setCapability("appPackage", "com.android.settings");
		capabilities.setCapability("appActivity", "com.android.settings.Settings");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");	  
		driver = new AppiumDriver(url, capabilities);	
		System.out.println("Gesture tool application is launched.");
		Thread.sleep(1000);
		List<WebElement> Categories = driver.findElementsById("com.android.settings:id/category");
		System.out.println("number of categories is: "+ Categories.size());
		WebElement wirelessContainer = Categories.get(0);
		
		List<WebElement> titles = wirelessContainer.findElements(By.id("com.android.settings:id/dashboard_tile"));
		System.out.println("number of wirelessContainer elements is: "+ titles.size());
		
		
  }
}
