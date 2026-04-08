import java.util.ArrayList;

public class Train implements TrainRequirements {

// Attributes
    private Engine engine;
    private ArrayList<Car> carList;


/**
 * Constructs a new Train with a specific engine configuration and car set.
 * 
 * @param fuelType the type of fuel used by the engine
 * @param currentFuelLevel the starting amount of fuel in the engine
 * @param fuelCapacity the maximum fuel the engine can hold
 * @param nCars the number of cars to attach to the train
 * @param passengerCapacity the maximum capacity for each individual car
 */
public Train(FuelType fuelType, double currentFuelLevel, double fuelCapacity, int nCars, int passengerCapacity) {
    this.engine = new Engine (fuelType, fuelCapacity, currentFuelLevel);
    this.carList = new ArrayList<>();

    for (int i = 0; i < nCars; i++) {
        // Creates a unique list for each car
        ArrayList<Passenger> passengersOnboard = new ArrayList<>();
        this.carList.add(new Car(passengersOnboard, passengerCapacity));
    }
}

/**
 * Accessor for the train's engine.
 * 
 * @return the Engine object currently powering this train
 */
public Engine getEngine(){
    return this.engine;
}

/**
 * Retrieves a specific car from the train based on its index.
 * 
 * @param i the index of the car to retrieve
 * @return the Car object at the specified index
 */
public Car getCar(int i){
    return this.carList.get(i);
}

/**
 * Calculates the total maximum capacity of all attached cars.
 * 
 * @return the sum of the maximum capacities of all cars in the train
 */
public int getMaxCapacity(){
    int total = 0;

    for(Car c : carList){
        // Summing up each car's limit
        total += c.getCapacity(); 
        }
    return total;
}

/**
 * Calculates the total number of unoccupied seats across the entire train.
 * 
 * @return the sum of remaining seats in all attached cars
 */
public int seatsRemaining() {
    int remainingSeats = 0;

    for(Car c : carList){
        // Sum up remaining seats from each car
        remainingSeats += c.seatsRemaining(); 
        }

    return remainingSeats;
    }

/**
 * Prints a full roster of all passengers currently on the train organized by car
 */
public void printManifest(){
    System.out.println("--- Full Train Manifest ---");
    for (int i = 0; i < carList.size(); i++) {
        System.out.println("Car #" + (i + 1) + ":");
        // This calls the Car's method to print name
        carList.get(i).printManifest();
        }
    }

public static void main(String[] args) {
    // Create my train
    Train oneTrain = new Train(FuelType.STEAM, 25.0, 50.0, 3, 50);

    // Checking seatsRemaining() method
    System.out.println("Initial total seats: " + oneTrain.seatsRemaining());

    // Testing Passenger Independence
    
    Passenger stewart = new Passenger("Stewart"); // Adding a passenger
    oneTrain.getCar(0).addPassenger(stewart);

    System.out.println("Car 0 seats: " + oneTrain.getCar(0).seatsRemaining());
    System.out.println("Car 1 seats: " + oneTrain.getCar(1).seatsRemaining()); 

    // Checking printManifest() method
    oneTrain.printManifest();
    }

}
