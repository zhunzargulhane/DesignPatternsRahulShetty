package org.rahulshettyacademy.abstractComponents;

import java.util.HashMap;

public interface FlightSearch {

//    void checkAvailability(String origin, String destination) throws InterruptedException;
    void checkAvailability(HashMap<String,String> reservationDetails) throws InterruptedException;

}
