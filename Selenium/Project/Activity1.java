package activites;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	public class Activity1 {

	    WebDriver driver;

	    @BeforeMethod
	    public void setUp() {
	        // If FirefoxDriver is already in PATH, no need to set system property
	        driver = new FirefoxDriver();
	        driver.manage().window().maximize();
	    }

	    @Test
	    public void verifyWebsiteTitle() {
	        // Navigate to website
	        driver.get("https://alchemy.hguy.co/jobs");

	        // Get title
	        String actualTitle = driver.getTitle();
	        String expectedTitle = "Alchemy Jobs – Job Board Application";

	        // Verify title
	        Assert.assertEquals(actualTitle, expectedTitle,
	                "Website title does not match!");
	    }

	    @AfterMethod
	    public void tearDown() {
	        // Close browser
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}

	