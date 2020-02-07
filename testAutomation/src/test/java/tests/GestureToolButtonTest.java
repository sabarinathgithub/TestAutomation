package tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class GestureToolButtonTest {
	AppiumDriver driver;
  @Test
  public void findElements() throws MalformedURLException {
	  DesiredCapabilities capabilities = new DesiredCapabilities();
	  File app = new File("C:\\Users\\15132\\git\\testAutomation\\testAutomation\\src\\test\\resources\\apps\\com.davemac327.gesture.tool.apk");
	  capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Moto E4 Plus");
	  capabilities.setCapability(MobileCapabilityType.UDID, "ZY2258RPB2");
	  capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	  capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
	  capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	  
	  URL url = new URL("http://127.0.0.1:4723/wd/hub");	  
	  driver = new AppiumDriver<MobileElement>(url, capabilities);
	  
	  driver.findElement(By.id("com.davemac327.gesture.tool:id/addButton")).click();	  
	  WebElement nameText = driver.findElementById("com.davemac327.gesture.tool:id/gesture_name");
	  System.out.println("Name file attribute is: "+ nameText.getAttribute("enabled"));
	  
  }
}
