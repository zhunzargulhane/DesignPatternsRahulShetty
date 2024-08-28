package org.rahulshettyacademy.abstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class AbstractComponent {
    WebElement sectionElement;
    WebDriver driver;
    public AbstractComponent(){}

    public AbstractComponent(WebDriver driver, By sectionElement) {
        this.sectionElement = driver.findElement(sectionElement);
        this.driver=driver;
    }

    public WebElement findElement(By searchElement) {
        return sectionElement.findElement(searchElement);
    }

    public List<WebElement> findElements(By searchElement){
        return sectionElement.findElements(searchElement);
    }

    public void waitForElementToDisappear(By element){
        WebDriverWait webDriverWait = new WebDriverWait(driver,10);
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }
}
