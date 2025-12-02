package Final_project;

import java.util.ArrayList;

public class Car extends Vehicle  {
	
	// Attributes
	private int seats; 
	private String type; 
	private ArrayList <String> accidentHistory; // List of accidents
	private int numberOfAccidents; // Total accident counts
	
	
	//Constructor
	public Car(int id, String model, double pricePerDay, int seats, String type) {
		super(id, model, pricePerDay);
		this.seats = seats;
		this.type = type;
		this.accidentHistory = new ArrayList <>();
		this.numberOfAccidents = 0; 
	}
	
	// Getters & Setters
	public int getSeats() {
		return seats;
	}
	public void setSeats (int seats) {
		this.seats = seats;
	}
	public String getType() {
		return type;
	}
	public void setType (String type) {
		this.type = type;
	}
	public ArrayList <String> getaccidentHistory(){
		return accidentHistory;
	}
	public int getnumberOfAccidents() {
		return numberOfAccidents;	
	}
	
	//Methods
	public void addAccidents(String accidentDetails) {
		accidentHistory.add(accidentDetails);
		numberOfAccidents++;
	}
	
	// Utility Method
	@Override 
	public String toString() {
		return super.toString() +
				", Seats: " + seats + 
				", Type: " + type + 
				", Number of Accidents: " + numberOfAccidents + 
				", Accident History: " + accidentHistory;
				
	}

}
