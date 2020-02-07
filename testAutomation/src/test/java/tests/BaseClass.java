package tests;

import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import org.testng.annotations.BeforeTest;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

public class BaseClass {
	AppiumDriver<MobileElement> driver;
 
  @BeforeTest
  public void beforeTest() {	  
	  try {
		  DesiredCapabilities capability = new DesiredCapabilities();
		  capability.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		  capability.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
		  capability.setCapability(MobileCapabilityType.DEVICE_NAME, "Moto E4 Plus");
		  capability.setCapability(MobileCapabilityType.UDID, "ZY2258RPB2");
		  capability.setCapability("autowebview", true);
		  capability.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		  
		  URL url = new URL("http://127.0.0.1:4723/wd/hub");
		  driver = new AppiumDriver<MobileElement>(url, capability);
		  
	} catch (MalformedURLException e) {
		System.out.println("Reason for failure is: " + e.getCause());
		System.out.println("Message is: "+ e.getMessage());
		e.printStackTrace();
	}
	  

  }
  
  @Test
  public void f() {
	  System.out.println("Launching browser on mobile...");
  }

  @AfterTest
  public void afterTest() {
  }

}
