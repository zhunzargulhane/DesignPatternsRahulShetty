package org.rahulshettyacademy.pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.rahulshettyacademy.abstractComponents.AbstractComponent;
import org.rahulshettyacademy.abstractComponents.FlightSearch;

import java.beans.Visibility;
import java.util.HashMap;
import java.util.function.Consumer;

public class MultiTrip extends AbstractComponent implements FlightSearch {
    private By alert = By.id("MultiCityModelAlert");
    private By rdo = By.id("ctl00_mainContent_rbtnl_Trip_2");
    private By from = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By to = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By findFlight = By.xpath("//input[@name='ctl00$mainContent$btn_FindFlights']");
    private By originCityReturn = By.id("ctl00_mainContent_ddl_originStation2_CTXT");
    private By destinationCityReturn = By.id("ctl00_mainContent_ddl_destinationStation2_CTXT");
    WebDriver driver;
    public MultiTrip(WebDriver driver, By searchElement) {
        super(driver, searchElement);
        this.driver=driver;
    }

    public MultiTrip() {
    }

    public void checkAvailability(HashMap<String,String> reservationDetails) {

        makeStateReady(s->selectOriginCity(reservationDetails.get("origin1")));
        selectDestinationCity(reservationDetails.get("destination1"));
        setOriginCityReturn(reservationDetails.get("origin2"));
        setDestinationCityReturn(reservationDetails.get("destination2"));
        makeStateReady(s->selectOriginCity(reservationDetails.get("origin1")));
        findElement(findFlight).click();
        System.out.println("I am in MultiTrip");
    }

    public void selectOriginCity(String origin) {
        findElement(from).click();
        findElement(By.xpath("//a[@value='" + origin + "']")).click();
    }

    public void setOriginCityReturn(String destination) {
        findElement(originCityReturn).click();
        findElement(By.xpath("(//a[@value='" + destination + "'])[3]")).click();
    }

    public void setDestinationCityReturn(String origin) {
        findElement(By.xpath("(//a[@value='" + origin + "'])[3]")).click();
    }
    public void selectDestinationCity(String destination) {
        findElement(to).click();
        findElement(By.xpath("(//a[@value='" + destination + "'])[2]")).click();
    }

    public void makeStateReady(Consumer<MultiTrip> consumer){
        findElement(rdo).click();
        findElement(alert).click();
        waitForElementToDisappear(alert);
        consumer.accept(this);
    }
}
