package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity9 {

    WebDriver driver;
    WebDriverWait wait;

    String username = "root";
    String password = "pa$$w0rd";

    String jobTitle = "Backend Automation Tester";

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test
    public void createJobListingFromBackend() {

        // Navigate to backend login
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");

        // Login
        driver.findElement(By.id("user_login")).sendKeys(username);
        driver.findElement(By.id("user_pass")).sendKeys(password);
        driver.findElement(By.id("wp-submit")).click();

        // Verify login (Dashboard)
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[contains(text(),'Dashboard')]")));

        // Click Job Listings from left menu
        driver.findElement(By.xpath("//div[text()='Job Listings']")).click();

        // Click Add New
        wait.until(ExpectedConditions.elementToBeClickable(
                By.linkText("Add New"))).click();

        // Enter Job Title
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("title"))).sendKeys(jobTitle);

        // Enter Job Description (iframe)
        WebElement iframe = driver.findElement(By.id("job_description_ifr"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.id("tinymce"))
                .sendKeys("Job created using Selenium TestNG backend automation.");
        driver.switchTo().defaultContent();

        // Click Publish
        WebElement publishButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("publish")));
        publishButton.click();

        // Verify published message
        WebElement successMsg = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//*[contains(text(),'Post published')]")));

        Assert.assertTrue(successMsg.isDisplayed(),
                "Job listing was NOT published successfully!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}