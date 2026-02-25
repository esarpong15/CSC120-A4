public class Engine implements EngineRequirements {

    private FuelType fuelType;
    private double currentFuelLevel;
    private double maxFuelLevel;

    // Constructor to initialize the attributes
    public Engine(FuelType fuelType, double currentFuelLevel, double maxFuelLevel) {
        this.fuelType = fuelType;
        this.currentFuelLevel = currentFuelLevel;
        this.maxFuelLevel = maxFuelLevel;
    }

    // Getter method for the 'fuelType' variable
    public FuelType getFuelType(){
        return fuelType;
    }

    // Getter method for the 'currentFuelLevel' variable
    public double getCurrentFuel(){
        return currentFuelLevel;
    }

    // Getter method for the 'maxFuelLevel' variable
    public double getMaxFuel(){
        return maxFuelLevel;
    }

    public void refuel(){
        // Resets the `Engine`'s current fuel level to the maximum
        this.currentFuelLevel = this.maxFuelLevel;
    }

    public Boolean go(){
        // Decrease the current fuel level
        this.currentFuelLevel = this.currentFuelLevel-=1;
        // Print remaining fuel level
        System.out.println("Remaining fuel level: " + currentFuelLevel);
        if (currentFuelLevel > 0){
            // If the fuel level is above 0 
            return true;
        } else{
            // When fuel level is 0 or lower
            return false;
        }
    }
/* 
    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 0.0, 100.0);
        myEngine.refuel();
        while (myEngine.go()) {
            System.out.println("Choo choo!");
        }
        System.out.println("Out of fuel.");

        
    }
    */
    }
