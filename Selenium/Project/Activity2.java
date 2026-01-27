package activities;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

	public class Activity2 {

	    WebDriver driver;

	    @BeforeMethod
	    public void setUp() {
	        driver = new FirefoxDriver();
	        driver.manage().window().maximize();
	    }

	    @Test
	    public void verifyWebsiteHeading() {
	        // Navigate to website
	        driver.get("https://alchemy.hguy.co/jobs");

	        // Locate heading (H1)
	        WebElement heading = driver.findElement(By.tagName("h1"));
	        String actualHeading = heading.getText();
	        String expectedHeading = "Welcome to Alchemy Jobs";

	        // Verify heading text
	        Assert.assertEquals(actualHeading, expectedHeading,
	                "Website heading does not match!");
	    }

	    @AfterMethod
	    public void tearDown() {
	        // Close browser
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}

