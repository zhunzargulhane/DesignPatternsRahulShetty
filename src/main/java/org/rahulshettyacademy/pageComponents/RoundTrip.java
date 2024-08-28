package org.rahulshettyacademy.pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.rahulshettyacademy.abstractComponents.AbstractComponent;
import org.rahulshettyacademy.abstractComponents.FlightSearch;

import java.util.HashMap;

public class RoundTrip extends AbstractComponent implements FlightSearch {

    private By rdo = By.id("ctl00_mainContent_rbtnl_Trip_1");
    private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By checkBox = By.id("ctl00_mainContent_chk_IndArm");
    private By search = By.id("ctl00_mainContent_btn_FindFlights");

    public RoundTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    public RoundTrip() {
    }

    public void checkAvailability(HashMap<String,String> reservationDetails) {
        findElement(rdo).click();
        selectOriginCity(reservationDetails.get("origin1"));
        selectDestinationCity(reservationDetails.get("destination1"));
        findElement(checkBox).click();
        findElement(search);
        System.out.println("I am in RoundTrip");
    }
    public void selectOriginCity(String origin) {
        findElement(from).click();
        findElement(By.xpath("//a[@value='" + origin + "']")).click();
    }

    public void selectDestinationCity(String destination) {
        findElement(By.xpath("(//a[@value='" + destination + "'])")).click();
    }

}
