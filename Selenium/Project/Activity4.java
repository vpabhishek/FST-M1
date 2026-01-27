package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity4 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void verifySecondHeading() {
        // Navigate to website
        driver.get("https://alchemy.hguy.co/jobs");

        // Locate all H2 headings and get the second one
        WebElement secondHeading = driver.findElements(By.tagName("h2")).get(0);

        String actualText = secondHeading.getText();
        String expectedText = "Quia quis non";

        // Verify second heading text
        Assert.assertEquals(actualText, expectedText,
                "Second heading text does not match!");
    }

    @AfterMethod
    public void tearDown() {
        // Close browser
        if (driver != null) {
            driver.quit();
        }
    }
}