package org.rahulshettyacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.rahulshettyacademy.abstractComponents.FlightSearch;
import org.rahulshettyacademy.pageComponents.MultiTrip;
import org.rahulshettyacademy.pageComponents.OneWay;
import org.rahulshettyacademy.pageComponents.RoundTrip;
import org.rahulshettyacademy.pageObjects.TravelHomePage;
import org.rahulshettyacademy.utility.DataReaderUtils;
import org.testng.annotations.*;
import org.testng.log4testng.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Flights extends BaseTest {
    TravelHomePage travelHomePage;
    WebDriver driver;

    @BeforeTest
    public void gearUpSetup() {
        driver = BaseTest.initializeDriver();
        travelHomePage = new TravelHomePage(driver);

    }

    @Test(dataProvider = "getData")
    public void flightTest(HashMap<String, String> reservationDetails) {
        travelHomePage.goTo();
        travelHomePage.getFooterNav().getFlightAttribute();
        travelHomePage.getFooterNav().selectFlight();
        travelHomePage.getNavigationBar().getFlightAttribute();
        travelHomePage.getFooterNav().linksCountInFooter();
        travelHomePage.getNavigationBar().linksCountInHeader();
        travelHomePage.goTo();
        travelHomePage.setBookStrategy("multitrip");
        travelHomePage.checkAvailability(reservationDetails);
        travelHomePage.setLinksCountSectionStrategy("footer");
        System.out.println("The link counts with href "+travelHomePage.getLinksCountWithHref());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @DataProvider
    public Object[][] getData() throws IOException {
       /* HashMap<String, String> reservationDetails = new HashMap<>();
        reservationDetails.put("origin1", "MAA");
        reservationDetails.put("destination1", "ATQ");
        reservationDetails.put("origin2", "ATQ");
        reservationDetails.put("destination2", "AMD");*/
        List<HashMap<String, String>> list
                = DataReaderUtils.getJSONData(System.getProperty("user.dir") + "//src//main//resources//dataFiles//reservationDetails.json");
        return new Object[][]{{list.get(0)}, {list.get(1)}};
    }

}

