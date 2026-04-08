public class Engine implements EngineRequirements {

    private FuelType fuelType;
    private double currentFuelLevel;
    private double maxFuelLevel;

    /**
     * Creates a new Engine with specific fueltype and fuel levels
     * 
     * @param fuelType
     * @param currentFuelLevel
     * @param maxFuelLevel
     */ 
    public Engine(FuelType fuelType, double currentFuelLevel, double maxFuelLevel) {
        this.fuelType = fuelType;
        this.currentFuelLevel = currentFuelLevel;
        this.maxFuelLevel = maxFuelLevel;
    }

    
    /**
     *  Getter method for the 'fuelType' variable
     * 
     * @return fuelType The type of fuel the engine uses
     */
    public FuelType getFuelType(){
        return fuelType;
    }

    /**
     * Getter method for the 'currentFuelLevel' variable
     * 
     * @return currentFuelLevel The current fuel level of the engine
     */
    public double getCurrentFuel(){
        return currentFuelLevel;
    }

    /**
     * Getter method for the 'maxFuelLevel' variable
     * 
     * @return maxFuelLevel The max amount of fuel that an engine can have
     */
    public double getMaxFuel(){
        return maxFuelLevel;
    }

    /**
     * Resets the `Engine`'s current fuel level to the maximum
     * 
     */
    public void refuel(){
        this.currentFuelLevel = this.maxFuelLevel;
        System.out.println("The Engine's fuel level is now refueled.");
    }

    /**
     * Decreases the current fuel level
     * 
     * @return True if the fuel level is above 0 and False otherwise
     */
    public Boolean go(){
        // Decrease the current fuel level
        if (this.currentFuelLevel > 0){
            this.currentFuelLevel-=1;
            // Print remaining fuel level
            System.out.println("Remaining fuel level: " + this.currentFuelLevel);
            return true;
        } else{
            System.out.println("Out of fuel!");
            return false;
        }
    }

    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 0.0, 10.0);
        myEngine.refuel();
        while (myEngine.go()) {
            System.out.println("Choo choo!");
        }
        System.out.println("Out of fuel.");
        System.out.println(myEngine.currentFuelLevel);

        
    }
    }
