package org.rahulshettyacademy.pageComponents;

import org.rahulshettyacademy.abstractComponents.FlightSearch;

import java.sql.SQLOutput;
import java.util.HashMap;

public class OneWay implements FlightSearch {

    public void checkAvailability(HashMap<String,String> reservationDetails) {
        System.out.println("I am inside one way");
    }
}
