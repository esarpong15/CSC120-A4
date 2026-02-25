import java.util.ArrayList;

public class Train implements TrainRequirements {
// Attributes
    private Engine engine;
    private ArrayList<Car> carList;
// Constructer that initializes attributes
public Train(FuelType fuelType, double currentFuelLevel, double fuelCapacity, int nCars, int passengerCapacity) {
    this.engine = new Engine (fuelType, fuelCapacity, currentFuelLevel);
    this.carList = new ArrayList<>(nCars);
    }
        for (int i = 0; i < nCars; i++) {
            this.carsList.add(new Car (passengersOnboard, passengerCapacity));
    }

/*public Engine getEngine(){
    return engine;
}

public Car getCar(int i){

}

public int getMaxCapacity(){

}

public int seatsRemaining() {

}

public void printManifest(){

}*/

}
