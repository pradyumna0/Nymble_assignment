package Nymble;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PassengerTest {

    @Test
    void TestgetName() {
        Passenger passenger = new Passenger("Pradyumna", 1, "Gold", 100);
        passenger.setname("Prady");
        assertEquals("Prady",passenger.getName());
    }

    @Test
    void TestgetPassenger_number() {
        Passenger passenger = new Passenger("Pradyumna", 1, "Gold", 100);
        passenger.setPassenger_number(10);
        assertEquals(10,passenger.getPassenger_number());
    }

    @Test
    void TestgetPassenger_type() {
        Passenger passenger = new Passenger("Pradyumna", 1, "Gold", 100);
        passenger.setPassenger_type("Silver");
        assertEquals("Silver",passenger.getPassenger_type());
    }

    @Test
    void TestgetBalance() {
        Passenger passenger = new Passenger("Pradyumna", 1, "Gold", 100);
        passenger.setbalance(20);
        assertEquals(20,passenger.getBalance());
    }

    @Test
    void TestgetActivities() {
        Passenger passenger = new Passenger("Pradyumna", 1, "Gold", 100);
        Activity activity1 = new Activity("Sightseeing", "Visit famous landmarks", 50, 20);
        Activity activity2 = new Activity("Shopping", "Shop at local markets", 30, 15);
        ArrayList<Activity>activities=new ArrayList<>();
        activities.add(activity1);
        activities.add(activity2);
        passenger.setActivities(activities);
        assertEquals(2,passenger.getActivities().size());
    }

    @Test
    void TestgetDestinations() {
        Passenger passenger = new Passenger("Pradyumna", 1, "Gold", 100);
        Destination destination=new Destination("Dubai");
        ArrayList<Destination>destinations=new ArrayList<>();
        destinations.add(destination);
        passenger.setDestinations(destinations);
        assertEquals(1,passenger.getDestinations().size());
    }

    @Test
    public void TestSignUpActivityStandard() {
        Passenger passenger = new Passenger("Pradyumna", 1, "Standard", 100);
        Activity activity = new Activity("Chess", "Brain exercise", 20, 10);
        Destination destination = new Destination("New York");

        passenger.signUpActivity(activity, destination);

        assertTrue(passenger.getActivities().contains(activity));
        assertTrue(passenger.getDestinations().contains(destination));
        assertEquals(80, passenger.getBalance());
    }

    @Test
    public void TestSignUpActivityGold() {
        Passenger passenger = new Passenger("Pradyumna", 1, "Gold", 100);
        Activity activity = new Activity("Chess", "Brain exercise", 20, 10);
        Destination destination = new Destination("New York");

        passenger.signUpActivity(activity, destination);

        assertTrue(passenger.getActivities().contains(activity));
        assertTrue(passenger.getDestinations().contains(destination));
        assertEquals(82, passenger.getBalance());
    }

    @Test
    public void TestSignUpActivityPremium() {
        Passenger passenger = new Passenger("Pradyumna", 1, "Premium", 100);
        Activity activity = new Activity("Chess", "Brain exercise", 20, 10);
        Destination destination = new Destination("New York");

        passenger.signUpActivity(activity, destination);

        assertTrue(passenger.getActivities().contains(activity));
        assertTrue(passenger.getDestinations().contains(destination));
        assertEquals(100, passenger.getBalance());
    }
}