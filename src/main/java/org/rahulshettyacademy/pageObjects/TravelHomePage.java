package org.rahulshettyacademy.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.abstractComponents.FlightSearch;
import org.rahulshettyacademy.abstractComponents.LinkCounts;
import org.rahulshettyacademy.abstractComponents.StrategyFactory;
import org.rahulshettyacademy.pageComponents.FooterNav;
import org.rahulshettyacademy.pageComponents.NavigationBar;
import org.rahulshettyacademy.pageComponents.RoundTrip;

import java.util.HashMap;

public class TravelHomePage {
    FlightSearch flightSearch;
    LinkCounts linkCounts;
    WebDriver driver;
    //footer
    By sectionElement = By.xpath("//div[@id='traveller-home']");
    //header
    By headerElement = By.xpath("//div[@id='buttons']");

    By flightSearchContainer = By.id("flightSearchContainer");

    public void goTo() {
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    public TravelHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public NavigationBar getNavigationBar() {
        return new NavigationBar(driver, headerElement);
    }

    public FooterNav getFooterNav() {
        return new FooterNav(driver, sectionElement);
    }

    public void setBookStrategy(String strategyType) {
        StrategyFactory strategyFactory = new StrategyFactory(driver);
        flightSearch = strategyFactory.createStrategy(strategyType);
    }

    public void setLinksCountSectionStrategy(String strategyType) {
        StrategyFactory strategyFactory = new StrategyFactory(driver);
        linkCounts = strategyFactory.createStrategyLinks(strategyType);
    }

    public int getLinksCountWithHref(){
        return linkCounts.linksCountWithHref();
    }

    public void checkAvailability(HashMap<String,String> reservationDetails) {
        try {
            flightSearch.checkAvailability(reservationDetails);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getTitle(){
        System.out.println("hello zhunzar");
        return driver.getTitle();
    }
}
