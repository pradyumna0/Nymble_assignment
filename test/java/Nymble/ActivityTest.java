package Nymble;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ActivityTest {

    @Test
    void TestgetName() {
        Activity activity=new Activity("Chess","good for brain",40,10);
        activity.setname("tabletennis");
        assertEquals("tabletennis",activity.getName());
    }

    @Test
    void TestgetDescription() {
        Activity activity=new Activity("Chess","good for brain",40,10);
        activity.setdescription("new description");
        assertEquals("new description",activity.getDescription());
    }

    @Test
    void Testgetcost() {
        Activity activity=new Activity("Chess","good for brain",40,10);
        activity.setcost(50);
        assertEquals(50,activity.getcost());

    }

    @Test
    void TestgetCapacity() {
        Activity activity=new Activity("Chess","good for brain",40,10);
        activity.setcapacity(30);
        assertEquals(30,activity.getCapacity());
    }

    @Test
    void TestgetPassengers() {
        Activity activity=new Activity("Chess","good for brain",40,10);
        Passenger passenger = new Passenger("Prady", 1, "Gold", 100);
        ArrayList<Passenger>passengers=new ArrayList<>();
        passengers.add(passenger);
        activity.setpassengers(passengers);
        assertNotNull(activity.getPassengers());
    }

    @Test
    void TestaddPassenger() {
        Passenger passenger = new Passenger("Pradyumna", 1, "Gold", 100);
        Passenger passenger1 = new Passenger("Prady", 1, "Gold", 100);
        Activity activity=new Activity("Chess","good for brain",40,10);
        activity.addPassenger(passenger);
        activity.addPassenger(passenger1);
        assertEquals(2,activity.passengers.size());
    }
}