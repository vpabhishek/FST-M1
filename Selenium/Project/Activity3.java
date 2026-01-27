package activities;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void printHeaderImageURL() {
        // Navigate to website
        driver.get("https://alchemy.hguy.co/jobs");

        // Locate header image
        WebElement headerImage = driver.findElement(By.cssSelector("header img"));

        // Get image URL
        String imageUrl = headerImage.getAttribute("src");

        // Print URL to console
        System.out.println("Header Image URL: " + imageUrl);
    }

    @AfterMethod
    public void tearDown() {
        // Close browser
        if (driver != null) {
            driver.quit();
        }
    }
}