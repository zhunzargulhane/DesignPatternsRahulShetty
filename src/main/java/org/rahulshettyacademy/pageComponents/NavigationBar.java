package org.rahulshettyacademy.pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.abstractComponents.AbstractComponent;

public class NavigationBar extends AbstractComponent {
    By clickFlight = By.xpath("//a[@title='Flights']");
    By link = By.cssSelector("a");

    public NavigationBar(WebDriver driver, By searchElement) {
        super(driver, searchElement);
    }

    public void getFlightAttribute() {
        System.out.println(findElement(clickFlight).getAttribute("class"));
    }

    public void linksCountInHeader() {
        System.out.println(findElements(link).size());
    }

}
