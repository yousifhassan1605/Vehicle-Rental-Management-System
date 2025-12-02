package Final_project;

public class Customer {
    
    // Attributes
    private int id;
    private String name;
    private String phone;
    private Vehicle rentedVehicle;   // The vehicle currently rented by the customer
    
    // Constructor
    public Customer(int id, String name, String phone, Vehicle rentedVehicle) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.rentedVehicle = rentedVehicle;
    }
    
    // Getters & Setters
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public Vehicle getRentedVehicle() {
        return rentedVehicle;
    }
    
    public Vehicle getCurrentVehicle() {
        return rentedVehicle;
    }
    
    public void setRentedVehicle(Vehicle rentedVehicle) {
        this.rentedVehicle = rentedVehicle;
    }
    
    // Utility Method
    @Override
    public String toString() {
        return "Customer ID: " + id +
               ", Name: " + name +
               ", Phone: " + phone +
               ", Rented Vehicle: " + (rentedVehicle != null ? rentedVehicle.getModel() : "None");
    }
}
