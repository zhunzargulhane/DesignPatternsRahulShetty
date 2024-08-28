package org.rahulshettyacademy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    public static WebDriver initializeDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
