package org.rahulshettyacademy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample {
    public static void main(String[] args) {
      //  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://yahoo.com");
        driver.quit();
    }
}
