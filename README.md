# Vehicle Rental Management System  

**Authors:**  

- Abdullah Syed (F2400163)  
- Yousif Mahfoudhi (F2400002)  
- Kishan Biju (F2400101)

## 📌 Project Overview  

The **Vehicle Rental Management System** is a Java-based application designed to manage vehicles, customers, and rental operations for a vehicle rental business.  
The system supports adding, editing, deleting, searching, and generating reports for vehicles and customers.  
It also includes text-file persistence and full Arabic language support.

---

## 🚗 Main Components

### **1. Classes Overview**

#### **Vehicle (Parent Class)**  

**Attributes:**  

- `int id`  
- `String model`  
- `double pricePerDay`  
- `boolean available`  
- `Queue<String> serviceDates`  

**Methods:**  

- **Constructor:** `Vehicle(int id, String model, double pricePerDay)`
- **Getters:**  
  - `int getId()`  
  - `String getModel()`  
  - `double getPricePerDay()`  
  - `boolean isAvailable()`  
  - `Queue<String> getServiceDates()`  
- **Setters:**  
  - `void setModel(String model)`  
  - `void setPricePerDay(double pricePerDay)`  
  - `void setAvailable(boolean available)`  
- **Utility:**  
  - `void markAsRented()`  
  - `void markAsReturned()`  
  - `void addServiceDate(String date)`  
  - `String completeNextService()`  
  - `String getNextServiceDate()`  
  - `String toString()`  

---

#### **Car (Child Class of Vehicle)**  

**Attributes:**  

- `int seats`  
- `String type`  
- `ArrayList<String> accidentHistory`  
- `int numberOfAccidents`  

**Methods:**  

- **Constructor:**  
  `Car(int id, String model, double pricePerDay, int seats, String type)`  
- **Getters/Setters:**  
  - `int getSeats()`  
  - `void setSeats(int seats)`  
  - `String getType()`  
  - `void setType(String type)`  
  - `ArrayList<String> getAccidentHistory()`  
  - `int getNumberOfAccidents()`  
- **Utility:**  
  - `void addAccidents(String accidentDetails)`  
  - `String toString()`  

---

#### **Bike (Child Class of Vehicle)**  

**Attributes:**  

- `boolean electric`  
- `int gearCount`

**Methods:**  

- **Constructor:**  
  `Bike(int id, String model, double pricePerDay, boolean electric, int gearCount)`  
- **Getters/Setters:**  
  - `boolean isElectric()`  
  - `void setElectric(boolean electric)`  
  - `int getGearCount()`  
  - `void setGearCount(int gearCount)`  
- **Utility:**  
  - `String toString()`  

---

#### **Customer**  

**Attributes:**  

- `int id`  
- `String name`  
- `String phone`  
- `Vehicle rentedVehicle`

**Methods:**  

- **Constructor:**  
  `Customer(int id, String name, String phone, Vehicle rentedVehicle)`  
- **Getters/Setters:**  
  - `int getId()`  
  - `String getName()`  
  - `void setName(String name)`  
  - `String getPhone()`  
  - `void setPhone(String phone)`  
  - `Vehicle getRentedVehicle()`  
  - `void setRentedVehicle(Vehicle rentedVehicle)`  
- **Utility:**  
  - `String toString()`  

---

## 🧰 User Operations  

The system will support the following menu options:  

- **Help**  
- **Data Management**  
- **Search**  
- **Reports**  
- **Rental Operations**  
- **Quit**

---

## 🗂 Data Structures Used  

- `ArrayList` – storing vehicles and customers  
- `HashMap` – mapping customer IDs or rental records  
- `Queue` – handling service dates for vehicles  

---

## 📝 Text I/O & Arabic Language Support  

The system will:  

- Read and write **all data** (vehicles, customers, rentals) using text files
- Fully support **Arabic input/output** in the console  
- Display **menus and messages in Arabic**  
- Save Arabic characters correctly using UTF-8 encoding  

---

## 📄 File Persistence  

All program data will be stored in text files so the system can:  

- Load data at startup  
- Save changes immediately  
- Preserve both English and Arabic text without corruption
