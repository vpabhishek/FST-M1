package examples;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1 {
	
	//Declaration of Objects
		AppiumDriver driver;
		WebDriverWait wait;
		
		
		//setUp function
		@BeforeClass
		public void Setup() throws MalformedURLException, URISyntaxException
		{
		//Desired Capabalities
			File appFile = new File("src/test/resources/Calculator.apk");
			UiAutomator2Options caps = new UiAutomator2Options();
			caps.setPlatformName("android");
			caps.setAutomationName("UiAutomator2");
			caps.setApp(appFile.getAbsolutePath());
			caps.noReset(); // Always resetting the app before launching it 
			
			//Set the appium server url
			URL serverURL = new URI("http://localhost:4723/").toURL();
			
			//Initialse android driver
			
			driver = new AndroidDriver(serverURL, caps);
			
		}
		@Test
		public void testMethod()
		
		{
			driver.findElement(AppiumBy.id("digit_5")).click();
			driver.findElement(AppiumBy.accessibilityId("multiply")).click();
			driver.findElement(AppiumBy.id("digit_6")).click();
			driver.findElement(AppiumBy.accessibilityId("equals")).click();
			String result = driver.findElement(AppiumBy.id("result_final")).getText();
			assertEquals(result, "30");
			
		}
		
		@AfterClass
		public void tearDown()
		{
			driver.quit();
		}

}