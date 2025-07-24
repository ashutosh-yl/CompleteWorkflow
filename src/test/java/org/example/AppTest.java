package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.URL;

public class AppTest {
    WebDriver driver;

    @Test
    public void titleCheck() {
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");

            // Connect to selenium/standalone-chrome container
            driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);

            driver.get("https://www.google.com");
            Assert.assertEquals(driver.getTitle(), "Google2");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null)
                driver.quit();
        }
    }
}
