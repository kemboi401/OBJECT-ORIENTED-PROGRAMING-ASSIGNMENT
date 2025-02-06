import java.util.ArrayList;
import java.util.List;
// This class represents a customer
class Customer {
    private String name;
    private String customerId;

    // Constructor to initialize a customer with a name.
    public Customer(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public String getCustomerId() {
        return customerId;
    }
}
// This class represents a car that can be rented or returned.
class Car {
    // Attributes of the car
    private String licensePlate;
    private String model;
    private boolean isRented;
    // Constructor to initialize a car with a given license plate and model.
    public Car(String licensePlate, String model) {
        this.licensePlate = licensePlate;
        this.model = model;
        this.isRented = false;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getModel() {
        return model;
    }

    public boolean isRented() {
        return isRented;
    }

    public void rentCar() {
        this.isRented = true;
    }

    public void returnCar() {
        this.isRented = false;
    }
}

// This class manages the rental agency.
class RentalAgency {
    private List<Car> cars;
    private List<Customer> customers;

    // Constructor to initialize empty lists of cars and customers.
    public RentalAgency() {
        this.cars = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Car rentCar(String licensePlate, String customerId) {
        for (Car car : cars) {
            if (car.getLicensePlate().equals(licensePlate) && !car.isRented()) {
                car.rentCar();
                System.out.println("Car rented to customer " + customerId);
                return car;
            }
        }
        System.out.println("Car not available for rent.");
        return null;
    }

    public boolean returnCar(String licensePlate) {
        for (Car car : cars) {
            if (car.getLicensePlate().equals(licensePlate) && car.isRented()) {
                car.returnCar();
                System.out.println("Car returned successfully.");
                return true; // Indicate success
            }
        }
        System.out.println("Car not found or not rented.");
        return false; // Indicate failure
    }

    public int getNumberOfCars() {
        return cars.size(); // Returns the number of cars in the agency
    }
}

// The main class that runs the car rental system.
public class carrental {
    public static void main(String[] args) {
        // Create a rental agency system
        RentalAgency agency = new RentalAgency();

        // Add cars to the system
        Car car1 = new Car("KCC", "Mazda CX-5");
        Car car2 = new Car("KAV", "Peugeot 504");

        agency.addCar(car1);
        agency.addCar(car2);

        // Display the number of vehicles listed
        System.out.println("Number of vehicles listed: " + agency.getNumberOfCars());

        // Add customers to the system
        Customer customer1 = new Customer("Kimani Larry", "C002");
        Customer customer2 = new Customer("Kameme John", "C001");

        agency.addCustomer(customer1);
        agency.addCustomer(customer2);

        // Rent and return a car
        agency.rentCar("KCC", "C001");
        agency.returnCar("KCC");
    }
}