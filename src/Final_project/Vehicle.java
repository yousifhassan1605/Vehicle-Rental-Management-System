package Final_project;

import java.util.LinkedList;
import java.util.Queue;

public class Vehicle {
	
	// Attributes
    private int id;
    private String model;
    private double pricePerDay;
    private boolean available;
    private Queue<String> serviceDates;

    // Constructor
    public Vehicle(int id, String model, double pricePerDay) {
        this.id = id;
        this.model = model;
        this.pricePerDay = pricePerDay;
        this.available = true;   // It will be true by default
        this.serviceDates = new LinkedList<>();
    }

    // Getters & Setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public double getPricePerDay() {
        return pricePerDay;
    }
    
    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    
    public Queue<String> getServiceDates() {
        return serviceDates;
    }
    
    // Methods
    public void markAsRented() {
        this.available = false;
    }

    public void markAsReturned() {
        this.available = true;
    }

    // Add value into serviceDate queue
    public void addServiceDate(String date) {
        serviceDates.add(date);
    }

    // Removes value of the head serviceDate queue
    public String completeNextService() {
        return serviceDates.poll();
    }

    // Peeks into the value of serviceDate queue
    public String getNextServiceDate() {
        return serviceDates.peek();
    }

    // Utility Method
    @Override
    public String toString() {
        return "Vehicle ID: " + id +
               ", Model: " + model +
               ", Price/Day: " + pricePerDay +
               ", Available: " + available ;
    }
}
