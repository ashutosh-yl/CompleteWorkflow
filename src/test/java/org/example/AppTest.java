package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
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
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
            driver.get("https://www.google.com");
            Assert.assertEquals(driver.getTitle(), "Google");
        } finally {
            if (driver != null)
            driver.quit();
        }
    }
}
