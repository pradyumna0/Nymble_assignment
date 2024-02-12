package Nymble;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class NymbleTest {

    @Test
    public void testPrintItinerary() {
        TravelPackage travelPackage = new TravelPackage("Pune", 10);
        Destination destination = new Destination("New York");
        Activity activity = new Activity("Swimming", "Physcial excercise", 20, 10);
        Passenger passenger = new Passenger("Pradyumna", 1, "Standard", 100);
        activity.addPassenger(passenger);
        destination.addActivity(activity);
        travelPackage.addDestination(destination);
        travelPackage.addPassenger(passenger);
        passenger.signUpActivity(activity,destination);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Nymble.printItinerary(travelPackage);

        System.setOut(System.out);

        String expectedOutput = "Name of Travel Package: Pune\n" +
                "Name of activity: Swimming\n" +
                "Cost of activity: 20\n" +
                "Capacity of activity: 10\n" +
                "Description of activity: Physcial excercise\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testPrintPassengerList() {
        TravelPackage travelPackage = new TravelPackage("Pune", 10);
        Destination destination = new Destination("New York");
        Activity activity = new Activity("Swimming", "Physcial excercise", 20, 10);
        Passenger passenger = new Passenger("Pradyumna", 1, "Standard", 100);
        activity.addPassenger(passenger);
        destination.addActivity(activity);
        travelPackage.addDestination(destination);
        travelPackage.addPassenger(passenger);
        passenger.signUpActivity(activity,destination);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Nymble.printPassengerList(travelPackage);

        System.setOut(System.out);

        String expectedOutput = "package name: Pune\n" +
                "passenger capacity: 10\n" +
                "Number of Passenger: 1\n" +
                "Name of Passenger: Pradyumna\n" +
                "Number of passengers currently enrolled : 1\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testPrintIndividualPassenger() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        TravelPackage travelPackage = new TravelPackage("Pune", 10);
        Destination destination = new Destination("New York");
        Activity activity = new Activity("Swimming", "Physcial excercise", 20, 10);
        Passenger passenger = new Passenger("Pradyumna", 1, "Standard", 100);
        activity.addPassenger(passenger);
        destination.addActivity(activity);
        travelPackage.addDestination(destination);
        travelPackage.addPassenger(passenger);
        passenger.signUpActivity(activity,destination);
        Nymble.printIndividualPassenger(passenger);
        System.setOut(System.out);

        String expectedOutput = "Name of Passenger: Pradyumna\n" +
                "Passenger Number: 1\n" +
                "balance: 80\n" +
                "name of activity: Swimming\n" +
                "Destionation at which activity is happening: New York\n" +
                "Price passenger paid for activity: 20\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testPrintActivitiesSpaces() {
        TravelPackage travelPackage = new TravelPackage("Pune", 10);
        Destination destination = new Destination("New York");
        Activity activity = new Activity("Swimming", "Physcial excercise", 20, 10);
        Passenger passenger = new Passenger("Pradyumna", 1, "Standard", 100);
        activity.addPassenger(passenger);
        destination.addActivity(activity);
        travelPackage.addDestination(destination);
        travelPackage.addPassenger(passenger);
        passenger.signUpActivity(activity,destination);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Nymble.printActivitiesSpaces(travelPackage);
        System.setOut(System.out);

        String expectedOutput = "Name of activity: Swimming\n" +
                "Destination of activity: New York\n" +
                "Spaces available for activity booking: 9\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}
