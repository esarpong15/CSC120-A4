import java.util.ArrayList;

public class Passenger implements PassengerRequirements{
    
    private String name;

    /**
     * Creates a new Passenger with a specific name.
     * 
     * @param name the unique name for passenger
     */
    public Passenger(String name) {
        this.name = name;
    }

    /**
     * Getter for Passenger's name.
     * 
     * @return String name.
     */
    public String getName(){
        return name;
    }

    /**
     * Adds this passenger to the specified car.
     * 
     * @param c the car being boarded
     */
    public void boardCar(Car c){
        System.out.println(this.getName()+" is attempting to board...");
        c.addPassenger(this);   
    }

    /**
     * Removes this passenger from the specified car.
     * 
     * @param c the car being exited.
     */
    public void getOffCar(Car c){
        System.out.println(this.getName()+" is now getting off...");
        c.removePassenger(this);
    }

    public static void main(String[] args) {
        // Create a new passenger
        Passenger me = new Passenger("Elizabeth");

        System.out.println("Passenger created: "+me.getName());

        // Create a Car
        ArrayList<Passenger> passengersOnboard = new ArrayList<>();
        Car trainCar = new Car(passengersOnboard, 5);

        // Testing boardCar() method
        me.boardCar(trainCar);

        // Testing getOffCar() method
        me.getOffCar(trainCar);

        //End of Test!
        System.out.println("Testing Complete.");


    }
}
