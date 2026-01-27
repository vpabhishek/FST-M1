package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity8 {

    WebDriver driver;

    String username = "root";
    String password = "pa$$w0rd";

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void loginToBackend() {

        // Navigate to backend login page
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");

        // Enter username
        WebElement usernameField = driver.findElement(By.id("user_login"));
        usernameField.sendKeys(username);

        // Enter password
        WebElement passwordField = driver.findElement(By.id("user_pass"));
        passwordField.sendKeys(password);

        // Click Login button
        driver.findElement(By.id("wp-submit")).click();

        // Verify successful login (Dashboard visible)
        WebElement dashboard = driver.findElement(By.xpath("//h1[contains(text(),'Dashboard')]"));
        Assert.assertTrue(dashboard.isDisplayed(),
                "Login failed! Dashboard not displayed.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}