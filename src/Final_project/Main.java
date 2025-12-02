package Final_project;

import java.util.*;
import java.io.*;

// Main class for the Vehicle Rental Management System.

public class Main {

    private static final String VEHICLES_FILE = "vehicles.txt";
    private static final String CUSTOMERS_FILE = "customers.txt";
    private static final String RENTALS_FILE = "rentals.txt";

    private static List<Vehicle> vehicles = new ArrayList<>();
    private static List<Customer> customers = new ArrayList<>();
    private static List<String> rentals = new ArrayList<>();

    // Added HashMap for efficient searching
    private static Map<Integer, Vehicle> vehicleMap = new HashMap<>();
    private static Map<Integer, Customer> customerMap = new HashMap<>();

    public static void main(String[] args) {
        Locale.setDefault(Locale.forLanguageTag("ar"));
        Scanner scanner = new Scanner(System.in, "UTF-8");

        ensureFilesExist();
        loadVehicles();
        loadCustomers();
        loadRentals();

        while (true) {
            System.out.println("\n--- نظام إدارة تأجير المركبات ---");
            System.out.println("1. إدارة المركبات");
            System.out.println("2. إدارة العملاء");
            System.out.println("3. عمليات التأجير");
            System.out.println("4. تقارير");
            System.out.println("5. مساعدة");
            System.out.println("6. خروج");
            System.out.println("7. البحث");
            System.out.print("اختر خيارًا: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    manageVehicles(scanner);
                    break;
                case 2:
                    manageCustomers(scanner);
                    break;
                case 3:
                    rentalOperations(scanner);
                    break;
                case 4:
                    generateReports(scanner); // Pass scanner to generateReports
                    break;
                case 5:
                    showHelp();
                    break;
                case 6:
                    saveData();
                    System.out.println("وداعًا!");
                    return;
                case 7: // Search option
                    searchData(scanner);
                    break;
                default:
                    System.out.println("خيار غير صالح. حاول مرة أخرى.");
            }
        }
    }

    private static void manageVehicles(Scanner scanner) {
        System.out.println("\n--- إدارة المركبات ---");
        System.out.println("1. إضافة مركبة");
        System.out.println("2. تعديل مركبة");
        System.out.println("3. حذف مركبة");
        System.out.println("4. عرض جميع المركبات");
        System.out.print("اختر خيارًا: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                addVehicle(scanner);
                break;
            case 2:
                editVehicle(scanner);
                break;
            case 3:
                deleteVehicle(scanner);
                break;
            case 4:
                displayVehicles();
                break;
            default:
                System.out.println("خيار غير صالح.");
        }
    }

    private static void addVehicle(Scanner scanner) {
        System.out.print("أدخل معرف المركبة: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("أدخل طراز المركبة: ");
        String model = scanner.nextLine();
        System.out.print("أدخل سعر الإيجار اليومي: ");
        double pricePerDay = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        vehicles.add(new Vehicle(id, model, pricePerDay));
        System.out.println("تمت إضافة المركبة بنجاح.");
    }

    private static void editVehicle(Scanner scanner) {
        System.out.print("أدخل معرف المركبة لتعديلها: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId() == id) {
                System.out.print("أدخل طراز المركبة الجديد: ");
                String model = scanner.nextLine();
                System.out.print("أدخل سعر الإيجار اليومي الجديد: ");
                double pricePerDay = scanner.nextDouble();
                scanner.nextLine(); // Consume newline

                vehicle.setModel(model);
                vehicle.setPricePerDay(pricePerDay);
                System.out.println("تم تعديل المركبة بنجاح.");
                return;
            }
        }
        System.out.println("لم يتم العثور على مركبة بالمعرف المدخل.");
    }

    private static void deleteVehicle(Scanner scanner) {
        System.out.print("أدخل معرف المركبة لحذفها: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Iterator<Vehicle> iterator = vehicles.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
                System.out.println("تم حذف المركبة بنجاح.");
                return;
            }
        }
        System.out.println("لم يتم العثور على مركبة بالمعرف المدخل.");
    }

    // Display all vehicles in the system
    private static void displayVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("لا توجد مركبات مسجلة.");
        } else {
            System.out.println("\n--- قائمة المركبات ---");
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);
            }
        }
    }

    // Manage customer-related operations
    private static void manageCustomers(Scanner scanner) {
        System.out.println("\n--- إدارة العملاء ---");
        System.out.println("1. إضافة عميل");
        System.out.println("2. تعديل عميل");
        System.out.println("3. حذف عميل");
        System.out.println("4. عرض جميع العملاء");
        System.out.print("اختر خيارًا: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                addCustomer(scanner);
                break;
            case 2:
                editCustomer(scanner);
                break;
            case 3:
                deleteCustomer(scanner);
                break;
            case 4:
                displayCustomers();
                break;
            default:
                System.out.println("خيار غير صالح.");
        }
    }

    private static void addCustomer(Scanner scanner) {
        System.out.print("أدخل معرف العميل: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("أدخل اسم العميل: ");
        String name = scanner.nextLine();
        System.out.print("أدخل رقم هاتف العميل: ");
        String phone = scanner.nextLine();

        customers.add(new Customer(id, name, phone, null));
        System.out.println("تمت إضافة العميل بنجاح.");
    }

    private static void editCustomer(Scanner scanner) {
        System.out.print("أدخل معرف العميل لتعديله: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Customer customer : customers) {
            if (customer.getId() == id) {
                System.out.print("أدخل الاسم الجديد للعميل: ");
                String name = scanner.nextLine();
                System.out.print("أدخل رقم الهاتف الجديد للعميل: ");
                String phone = scanner.nextLine();

                customer.setName(name);
                customer.setPhone(phone);
                System.out.println("تم تعديل بيانات العميل بنجاح.");
                return;
            }
        }
        System.out.println("لم يتم العثور على عميل بالمعرف المدخل.");
    }

    private static void deleteCustomer(Scanner scanner) {
        System.out.print("أدخل معرف العميل لحذفه: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Iterator<Customer> iterator = customers.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == id) {
                iterator.remove();
                System.out.println("تم حذف العميل بنجاح.");
                return;
            }
        }
        System.out.println("لم يتم العثور على عميل بالمعرف المدخل.");
    }

    private static void displayCustomers() {
        if (customers.isEmpty()) {
            System.out.println("لا توجد بيانات عملاء مسجلة.");
        } else {
            System.out.println("\n--- قائمة العملاء ---");
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }

    private static void rentalOperations(Scanner scanner) {
        System.out.println("\n--- عمليات التأجير ---");
        System.out.println("1. تأجير مركبة");
        System.out.println("2. إرجاع مركبة");
        System.out.println("3. عرض جميع الإيجارات");
        System.out.print("اختر خيارًا: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                rentVehicle(scanner);
                break;
            case 2:
                returnVehicle(scanner);
                break;
            case 3:
                displayRentals();
                break;
            default:
                System.out.println("خيار غير صالح.");
        }
    }

    private static void rentVehicle(Scanner scanner) {
        System.out.print("أدخل معرف العميل: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("أدخل معرف المركبة: ");
        int vehicleId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Customer customer = null;
        for (Customer c : customers) {
            if (c.getId() == customerId) {
                customer = c;
                break;
            }
        }

        if (customer == null) {
            System.out.println("لم يتم العثور على العميل.");
            return;
        }

        Vehicle vehicle = null;
        for (Vehicle v : vehicles) {
            if (v.getId() == vehicleId && v.isAvailable()) {
                vehicle = v;
                break;
            }
        }

        if (vehicle == null) {
            System.out.println("لم يتم العثور على المركبة أو أنها غير متاحة.");
            return;
        }

        vehicle.markAsRented();
        customer.setRentedVehicle(vehicle);
        rentals.add("عميل: " + customer.getName() + " استأجر مركبة: " + vehicle.getModel());
        System.out.println("تمت عملية التأجير بنجاح.");
    }

    private static void returnVehicle(Scanner scanner) {
        System.out.print("أدخل معرف العميل: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Customer customer : customers) {
            if (customer.getId() == customerId && customer.getRentedVehicle() != null) {
                Vehicle vehicle = customer.getRentedVehicle();
                vehicle.markAsReturned();
                customer.setRentedVehicle(null);
                System.out.println("تمت عملية الإرجاع بنجاح.");
                return;
            }
        }
        System.out.println("لم يتم العثور على العميل أو أن العميل لم يستأجر مركبة.");
    }

    private static void displayRentals() {
        if (rentals.isEmpty()) {
            System.out.println("لا توجد عمليات تأجير مسجلة.");
        } else {
            System.out.println("\n--- قائمة الإيجارات ---");
            for (String rental : rentals) {
                System.out.println(rental);
            }
        }
    }

    private static void generateReports(Scanner scanner) {
        System.out.println("\n--- تقارير ---");
        System.out.println("1. تقرير المركبات المتاحة");
        System.out.println("2. تقرير المركبات المؤجرة");
        System.out.print("اختر خيارًا: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                displayAvailableVehicles();
                break;
            case 2:
                displayRentedVehicles();
                break;
            default:
                System.out.println("خيار غير صالح.");
        }
    }

    private static void displayAvailableVehicles() {
        System.out.println("\n--- المركبات المتاحة ---");
        for (Vehicle vehicle : vehicles) {
            if (vehicle.isAvailable()) {
                System.out.println(vehicle);
            }
        }
    }

    private static void displayRentedVehicles() {
        System.out.println("\n--- المركبات المؤجرة ---");
        for (Vehicle vehicle : vehicles) {
            if (!vehicle.isAvailable()) {
                System.out.println(vehicle);
            }
        }
    }

    private static void showHelp() {
        System.out.println("\n--- مساعدة ---");
        System.out.println("1. إدارة المركبات: إضافة، تعديل، حذف، وعرض المركبات.");
        System.out.println("2. إدارة العملاء: إضافة، تعديل، حذف، وعرض العملاء.");
        System.out.println("3. عمليات التأجير: تأجير وإرجاع المركبات.");
        System.out.println("4. تقارير: عرض تقارير حول المركبات والعملاء.");
        System.out.println("5. مساعدة: عرض هذه القائمة.");
        System.out.println("6. خروج: إنهاء البرنامج.");
    }

    // Check the existence of the files and create them if missing
    private static void ensureFilesExist() {
        try {
            File vehiclesFile = new File(VEHICLES_FILE);
            if (vehiclesFile.createNewFile()) {
                System.out.println("تم إنشاء ملف المركبات: " + VEHICLES_FILE);
            }

            File customersFile = new File(CUSTOMERS_FILE);
            if (customersFile.createNewFile()) {
                System.out.println("تم إنشاء ملف العملاء: " + CUSTOMERS_FILE);
            }

            File rentalsFile = new File(RENTALS_FILE);
            if (rentalsFile.createNewFile()) {
                System.out.println("تم إنشاء ملف الإيجارات: " + RENTALS_FILE);
            }
        } catch (IOException e) {
            System.out.println("خطأ أثناء إنشاء الملفات: " + e.getMessage());
        }
    }

    // Load vehicle data from the file into the list and map
    private static void loadVehicles() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(VEHICLES_FILE), "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String model = parts[1];
                double pricePerDay = Double.parseDouble(parts[2]);
                Vehicle vehicle = new Vehicle(id, model, pricePerDay);
                vehicles.add(vehicle);
                vehicleMap.put(id, vehicle); // Populate HashMap
            }
        } catch (IOException e) {
            System.out.println("خطأ في تحميل بيانات المركبات.");
        }
    }

    // Load customer data from the file into the list and map
    private static void loadCustomers() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(CUSTOMERS_FILE), "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                String phone = parts[2];
                Customer customer = new Customer(id, name, phone, null);
                customers.add(customer);
                customerMap.put(id, customer); // Populate HashMap
            }
        } catch (IOException e) {
            System.out.println("خطأ في تحميل بيانات العملاء.");
        }
    }

    // Load rental data from the file into the list
    private static void loadRentals() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(RENTALS_FILE), "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                rentals.add(line);
            }
        } catch (IOException e) {
            System.out.println("خطأ في تحميل بيانات الإيجارات.");
        }
    }

    // Save all data to their respective files
    private static void saveData() {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(VEHICLES_FILE), "UTF-8"))) {
            for (Vehicle vehicle : vehicles) {
                bw.write(vehicle.getId() + "," + vehicle.getModel() + "," + vehicle.getPricePerDay() + "," + vehicle.isAvailable());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("خطأ في حفظ بيانات المركبات.");
        }

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(CUSTOMERS_FILE), "UTF-8"))) {
            for (Customer customer : customers) {
                bw.write(customer.getId() + "," + customer.getName() + "," + customer.getPhone());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("خطأ في حفظ بيانات العملاء.");
        }

        saveRentals(); // Save rental data
    }

    private static void saveRentals() {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(RENTALS_FILE), "UTF-8"))) {
            for (String rental : rentals) {
                bw.write(rental);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("خطأ في حفظ بيانات الإيجارات.");
        }
    }

    // Search functionality for vehicles and customers
    private static void searchData(Scanner scanner) {
        System.out.println("\n--- البحث ---");
        System.out.println("1. البحث عن مركبة");
        System.out.println("2. البحث عن عميل");
        System.out.print("اختر خيارًا: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                searchVehicle(scanner);
                break;
            case 2:
                searchCustomer(scanner);
                break;
            default:
                System.out.println("خيار غير صالح.");
        }
    }

    private static void searchVehicle(Scanner scanner) {
        System.out.print("أدخل معرف المركبة للبحث: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId() == id) {
                System.out.println(vehicle);
                return;
            }
        }
        System.out.println("لم يتم العثور على مركبة بالمعرف المدخل.");
    }

    private static void searchCustomer(Scanner scanner) {
        System.out.print("أدخل معرف العميل للبحث: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Customer customer : customers) {
            if (customer.getId() == id) {
                System.out.println(customer);
                return;
            }
        }
        System.out.println("لم يتم العثور على عميل بالمعرف المدخل.");
    }
}