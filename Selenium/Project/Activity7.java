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

public class Activity7 {

    WebDriver driver;
    WebDriverWait wait;

    String jobTitle = "Automation Test Engineer";

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test
    public void createNewJobListing() {

        // Open Alchemy Jobs site
        driver.get("https://alchemy.hguy.co/jobs");

        // Click "Post a Job"
        driver.findElement(By.linkText("Post a Job")).click();

        // Fill Job Title
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("job_title")))
                .sendKeys(jobTitle);

        // Fill Job Location
        driver.findElement(By.id("job_location")).sendKeys("Bangalore, India");

        // Fill Job Type
        driver.findElement(By.id("job_type")).sendKeys("Full Time");

        // Fill Job Description (inside iframe)
        WebElement iframe = driver.findElement(By.id("job_description_ifr"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.id("tinymce")).sendKeys("This is a test job posted via Selenium TestNG.");
        driver.switchTo().defaultContent();

        // Fill Company Name
        driver.findElement(By.id("company_name")).sendKeys("Alchemy Automation Pvt Ltd");

        // Click Preview
        driver.findElement(By.name("preview")).click();

        // Click Submit Listing
        wait.until(ExpectedConditions.elementToBeClickable(By.id("job_preview_submit_button")))
                .click();

        // Verify job is listed
        driver.findElement(By.linkText("Jobs")).click();

        WebElement postedJob = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.linkText(jobTitle)));

        Assert.assertTrue(postedJob.isDisplayed(),
                "Job listing was NOT posted successfully!");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}