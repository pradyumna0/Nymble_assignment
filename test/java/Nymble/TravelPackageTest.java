package Nymble;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TravelPackageTest {

    @Test
    void TestgetName() {
        TravelPackage travelPackage=new TravelPackage("Pune",10);
        travelPackage.setName("Mumbai");
        assertEquals("Mumbai",travelPackage.getName());
    }

    @Test
    void TestgetCapacity() {
        TravelPackage travelPackage=new TravelPackage("Pune",10);
        travelPackage.setCapacity(30);
        assertEquals(30,travelPackage.getCapacity());
    }

    @Test
    void TestgetPassengers() {
        Passenger passenger = new Passenger("Pradyumna", 1, "Gold", 100);
        TravelPackage travelPackage=new TravelPackage("Pune",10);
        ArrayList<Passenger>passengers=new ArrayList<>();
        passengers.add(passenger);
        travelPackage.setPassengers(passengers);
        assertEquals(passengers,travelPackage.getPassengers());
    }

    @Test
    void TestgetDestinations() {
        TravelPackage travelPackage = new TravelPackage("Europe Tour", 20);
        ArrayList<Destination> destinations = new ArrayList<>();
        Destination destination1=new Destination("Paris");
        Destination destination2=new Destination("Switzerland");
        destinations.add(destination1);
        destinations.add(destination2);
        travelPackage.setDestinations(destinations);

        assertEquals(destinations, travelPackage.getDestinations());
    }


    @Test
    void TestaddPassenger() {
        TravelPackage travelPackage = new TravelPackage("Pune", 20);
        Passenger passenger = new Passenger("Pradyumna", 111, "Gold", 100);
        Passenger passenger1 = new Passenger("Prady", 111, "Gold", 100);
        travelPackage.addPassenger(passenger);
        travelPackage.addPassenger(passenger1);
        ArrayList<Passenger> passengers = travelPackage.getPassengers();

        assertEquals(2, passengers.size());
        assertTrue(passengers.contains(passenger));
    }

    @Test
    void TestaddDestination() {
        Destination destination=new Destination("Seattle");
        TravelPackage travelPackage = new TravelPackage("Pune", 20);
        travelPackage.addDestination(destination);
        assertTrue(travelPackage.getDestinations().contains(destination));
    }
}