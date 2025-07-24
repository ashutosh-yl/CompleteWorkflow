package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {

    WebDriver driver;

    @Test
    public void titleCheck() {

        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new"); // New headless mode (recommended)
            options.addArguments("--no-sandbox"); // Required in CI
            options.addArguments("--disable-dev-shm-usage"); // Prevent crashes in limited environments

            driver = new ChromeDriver(options);
            driver.get("https://www.google.com");

            Assert.assertEquals(driver.getTitle(), "Google");
        } finally {
            if (driver != null) driver.quit();
        }
    }
}
