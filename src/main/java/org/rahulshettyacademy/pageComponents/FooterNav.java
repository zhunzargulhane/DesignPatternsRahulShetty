package org.rahulshettyacademy.pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.abstractComponents.AbstractComponent;
import org.rahulshettyacademy.abstractComponents.LinkCounts;

public class FooterNav extends AbstractComponent implements LinkCounts {
    By flights = By.cssSelector("[title='Flights']");
    By clickFlight = By.xpath("//a[@title='Flights']");

    By link = By.cssSelector("a");
    By linkWithHref = By.xpath("descendant::a");

    public FooterNav(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    public void linksCountInFooter() {
        System.out.println(findElements(link).size());
    }

    public int linksCountWithHref() {
        return findElements(linkWithHref).size();
    }


    public void getFlightAttribute() {
        System.out.println(findElement(flights).getAttribute("class"));
    }

    public void selectFlight() {
        findElement(clickFlight).click();
    }
}
