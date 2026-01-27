package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity6 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void applyToJob() {
        // Open Alchemy Jobs site
        driver.get("https://alchemy.hguy.co/jobs");

        // Navigate to Jobs page
        driver.findElement(By.linkText("Jobs")).click();

        // Search for a job
        WebElement searchBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("search_keywords")));
        searchBox.sendKeys("Banking");

        // Click Search
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        // Wait for job listings and click first job
        WebElement firstJob = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("ul.job_listings li a")));
        firstJob.click();

        // Click Apply button
        WebElement applyButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.className("application_button")));
        applyButton.click();

        // Get and print email
        WebElement email = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".application_details a")));
        System.out.println("Apply Job Email: " + email.getText());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}