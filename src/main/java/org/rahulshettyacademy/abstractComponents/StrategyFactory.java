package org.rahulshettyacademy.abstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.rahulshettyacademy.pageComponents.FooterNav;
import org.rahulshettyacademy.pageComponents.MultiTrip;
import org.rahulshettyacademy.pageComponents.NavigationBar;
import org.rahulshettyacademy.pageComponents.RoundTrip;

public class StrategyFactory {
    WebDriver driver;
    By bookingSection = By.id("flightSearchContainer");
    By footerSection = By.id("traveller-home");

    public StrategyFactory(WebDriver driver) {
        this.driver = driver;
    }

    public FlightSearch createStrategy(String strategyType) {
        if (strategyType.equalsIgnoreCase("roundTrip"))
            return new RoundTrip(driver, bookingSection);
        if (strategyType.equalsIgnoreCase("multiTrip"))
            return new MultiTrip(driver, bookingSection);
        return null;
    }

    public LinkCounts createStrategyLinks(String strategyType) {
        if (strategyType.equalsIgnoreCase("footer"))
            return new FooterNav(driver, footerSection);
        return null;
    }

}
