package Final_project;

import java.util.ArrayList;

public class Bike extends Vehicle {
	
	// Attributes
	private boolean electric; 
	private int gearCount; 
	private double batteryCapacity;
	private ArrayList<String> accidentHistory; // List of accidents
	private int numberOfAccidents; 
	
	// Constructor
	public Bike(int id, String model, double pricePerDay, boolean electric, int gearCount, double batteryCapacity) {
		super(id, model, pricePerDay);
		this.electric= electric; 
		this.gearCount = gearCount; 
		this.batteryCapacity = batteryCapacity;
		this.accidentHistory = new ArrayList<>();
		this.numberOfAccidents = 0; 
	}
	
	// Getters & Setters
	public boolean isElectric() {
		return electric;
	}

	public void setElectric(boolean electric) {
		this.electric = electric;
	}

	public int getGearCount() {
		return gearCount;
	}

	public void setGearCount(int gearCount) {
		this.gearCount = gearCount;
	}

	public double getBatteryCapacity() {
		return batteryCapacity;
	}

	public void setBatteryCapacity(double batteryCapacity) {
		this.batteryCapacity = batteryCapacity;
	}
	public int getNumberOfAccidents() {
		return numberOfAccidents;
		
	}
	
	public ArrayList<String> getAccidentHistory() {
		return accidentHistory;
	}
	
	public void addAccident(String accidentDetails) {
		accidentHistory.add(accidentDetails);
		numberOfAccidents++;
	}
	
	// Utility Method
	@Override
	public String toString() {
		return super.toString() + 
				", Electric: " + electric + 
				", Gears: " + gearCount + 
				", Battery Capacity: " + batteryCapacity + 
				", Number of Accidents: " + numberOfAccidents +
				", Accident History: " + accidentHistory;
	}

}
