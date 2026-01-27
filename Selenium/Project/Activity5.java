package activities;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	public class Activity5 {

	    WebDriver driver;

	    @BeforeMethod
	    public void setUp() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	    }

	    @Test
	    public void navigateToJobsPage() {
	        // Navigate to website
	        driver.get("https://alchemy.hguy.co/jobs");

	        // Click "Jobs" from navigation bar
	        WebElement jobsLink = driver.findElement(By.linkText("Jobs"));
	        jobsLink.click();

	        // Get page title
	        String actualTitle = driver.getTitle();
	        String expectedTitle = "Jobs – Alchemy Jobs";

	        // Verify correct page
	        Assert.assertEquals(actualTitle, expectedTitle,
	                "Not navigated to Jobs page!");
	    }

	    @AfterMethod
	    public void tearDown() {
	        // Close browser
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}

