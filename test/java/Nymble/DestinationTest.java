package Nymble;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DestinationTest {

    @Test
    void Testgetname() {
        Destination destinationA = new Destination("California");
        destinationA.setname("New Jersey");
        assertEquals("New Jersey",destinationA.getname());
    }

    @Test
    void TestgetActivities() {
        ArrayList<Activity>activities=new ArrayList<>() ;
        Destination destinationA = new Destination("California");
        Activity activity=new Activity("Chess","good for brain",40,10);
        Activity activity2=new Activity("Badminton","physical exercise",20,10);
        activities.add(activity);
        activities.add(activity2);
        destinationA.setActivities(activities);
        assertEquals(2,destinationA.getActivities().size());
    }

    @Test
    void TestaddActivity() {
        Destination destinationA = new Destination("California");
        Activity activity1 = new Activity("Sightseeing", "Visit famous landmarks", 50, 20);
        destinationA.addActivity(activity1);
        assertTrue(destinationA.getActivities().contains(activity1));
    }
}