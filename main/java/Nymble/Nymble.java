package Nymble;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

/*
Problem statement=>Design, implement and test a software system that allows travel agencies to maintain their travel packages' itinerary and passengers.
Author-Pradyumna Daware
 */
class TravelPackage {
    private String name;
    private int capacity;
    private ArrayList<Passenger> passengers;
    private ArrayList<Destination> destinations;

    TravelPackage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.passengers = new ArrayList<>();
        this.destinations = new ArrayList<>();
    }
    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public ArrayList<Destination> getDestinations() {
        return destinations;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    public void setDestinations(ArrayList<Destination> destinations) {
        this.destinations = destinations;
    }

    public void addPassenger(Passenger passenger) {
        if (passengers.size() <= capacity) {
            passengers.add(passenger);
        } else {
            System.out.println("Cannnot add passenger as capacity is full");
        }
    }

    public void addDestination(Destination destination) {
        destinations.add(destination);
    }
}

class Destination {
    private String name;
    private ArrayList<Activity> activities;

    Destination(String name) {
        this.name = name;
        this.activities = new ArrayList<>();
    }

    public String getname() {
        return name;
    }

    public ArrayList<Activity> getActivities() {
        return activities;
    }

    public String setname(String name) {
        return this.name = name;
    }

    public ArrayList<Activity> setActivities(ArrayList<Activity> activities) {
        return this.activities = activities;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }
}

class Activity {
    private String name;
    private String description;
    private int cost;
    private int capacity;
    ArrayList<Passenger> passengers;

    Activity(String name, String description, int cost, int capacity) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.passengers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getcost() {
        return cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public String setname(String name) {
        return this.name = name;
    }

    public String setdescription(String description) {
        return this.description = description;
    }

    public int setcost(int cost) {
        return this.cost = cost;
    }

    public int setcapacity(int capacity) {
        return this.capacity = capacity;
    }

    public ArrayList<Passenger> setpassengers(ArrayList<Passenger> passengers) {
        return this.passengers = passengers;
    }

    public void addPassenger(Passenger passenger) {
        if (passengers.size() < capacity) {
            passengers.add(passenger);
        } else {
            System.out.println("Cannot add passenger as list is full");
        }
    }
}

class Passenger {
    private String name;
    private int passenger_number;
    private String passenger_type;
    private int balance;
    private ArrayList<Activity> activities;
    private ArrayList<Destination> destinations;

    Passenger(String name, int passenger_number, String passenger_type, int balance) {
        this.name = name;
        this.passenger_number = passenger_number;
        this.passenger_type = passenger_type;
        this.balance = balance;
        this.activities = new ArrayList<>();
        this.destinations = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getPassenger_number() {
        return passenger_number;
    }

    public String getPassenger_type() {
        return passenger_type;
    }

    public int getBalance() {
        return balance;
    }

    public ArrayList<Activity> getActivities() {
        return activities;
    }

    public ArrayList<Destination> getDestinations() {
        return destinations;
    }

    public String setname(String name) {
        return this.name = name;
    }

    public int setPassenger_number(int passenger_number) {
        return this.passenger_number = passenger_number;
    }

    public String setPassenger_type(String passenger_type) {
        return this.passenger_type = passenger_type;
    }

    public int setbalance(int balance) {
        return this.balance = balance;
    }

    public ArrayList<Activity> setActivities(ArrayList<Activity> activities) {
        return this.activities = activities;
    }

    public ArrayList<Destination> setDestinations(ArrayList<Destination> destinations) {
        return this.destinations = destinations;
    }

    public void signUpActivity(Activity activity, Destination destination) {
        if (passenger_type.equals("Standard")) {
            if (balance >= activity.getcost()) {
                balance -= activity.getcost();
                activities.add(activity);
                destinations.add(destination);
            } else {
                System.out.println("Activity cannot be added as your balance is " + balance);
            }
        } else if (passenger_type.equals("Gold")) {
            float discount = (float) activity.getcost() - ((float) activity.getcost() / 10);
            if (balance >= discount) {
                balance -= discount;
                activities.add(activity);
                destinations.add(destination);
            } else {
                System.out.println("Activity cannot be added as your balance is " + balance);
            }
        } else if (passenger_type.equals("Premium")) {
            activities.add(activity);
            destinations.add(destination);
        }
    }
}


public class Nymble {
    public static void main(String[] args) {
    }

    static void printItinerary(TravelPackage travelPackage) {
        for (Destination destination : travelPackage.getDestinations()) {
            for (Activity activity : destination.getActivities()) {
                System.out.print("Name of Travel Package: "+travelPackage.getName()+"\n" +
                        "Name of activity: "+activity.getName()+"\n" +
                        "Cost of activity: "+activity.getcost()+"\n" +
                        "Capacity of activity: "+activity.getCapacity()+"\n" +
                        "Description of activity: "+activity.getDescription()+"\n");
            }
        }
    }

    static void printPassengerList(TravelPackage travelPackage) {
        for (Passenger passenger : travelPackage.getPassengers()) {
            System.out.print("package name: "+ travelPackage.getName()+"\n" +
                    "passenger capacity: "+travelPackage.getCapacity()+"\n" +
                    "Number of Passenger: "+passenger.getPassenger_number()+"\n" +
                    "Name of Passenger: "+passenger.getName()+"\n" +
                    "Number of passengers currently enrolled : "+travelPackage.getPassengers().size() +"\n");
        }
    }

    static void printIndividualPassenger(Passenger passenger) {
        for (Activity activity : passenger.getActivities()) {
            for (Destination destination : passenger.getDestinations()) {
                System.out.print("Name of Passenger: "+passenger.getName()+"\n" +
                        "Passenger Number: "+passenger.getPassenger_number()+"\n" +
                        "balance: "+passenger.getBalance()+"\n" +
                        "name of activity: "+activity.getName()+"\n" +
                        "Destionation at which activity is happening: "+destination.getname()+"\n" +
                        "Price passenger paid for activity: "+activity.getcost()+"\n");
            }
        }

    }

    static void printActivitiesSpaces(TravelPackage travelPackage) {
        for (Destination destination : travelPackage.getDestinations()) {
            for (Activity activity : destination.getActivities()) {
                int spacesAvailable = activity.getCapacity() - activity.passengers.size();
                System.out.print("Name of activity: "+activity.getName()+"\n" +
                        "Destination of activity: "+destination.getname()+"\n" +
                        "Spaces available for activity booking: "+spacesAvailable+"\n");
            }
        }
    }
}