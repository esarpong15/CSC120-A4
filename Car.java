import java.util.ArrayList;

public class Car implements CarRequirements{
    
    private ArrayList<Passenger> passengersOnboard;
    private int maxCapacity;

    /**
     * Creates a new Train Car with passengers and a limit of passengers
     * 
     * @param passengersOnboard
     * @param maxCapacity
     */
    public Car(ArrayList<Passenger> passengersOnboard, int maxCapacity ){
        this.passengersOnboard = passengersOnboard;
        this.maxCapacity = maxCapacity;
    }

    /**
     * Getter method for maxCapacity return 
     * 
     * @return The maximum capacity
     */
    public int getCapacity(){
        return maxCapacity;
    }

    /**
     * Getter method for seatsRemaining
     * 
     * @return Remaining seats
     */
    public int seatsRemaining(){
        return maxCapacity-passengersOnboard.size();
    }
    
    /**
     * Adds Passenger into Car
     * 
     * @param p Onboarding Passenger
     * @return True if the operation was successful, and False otherwise. 
     * 
     */
    public Boolean addPassenger(Passenger p){
        // Checks if passenger is already onboard
        if (passengersOnboard.contains(p)) {
            System.out.println("Cannot add this Passenger: already onboard.");
            return false;
        }else{
            
            // Checks if the amount of Passengers is less than the max capacity
            if (passengersOnboard.size() < maxCapacity) {
                passengersOnboard.add(p);
                System.out.println("Passenger: "+p.getName()+" has been added");
                return true;
        }else {
            System.out.println("Cannot add this passenger: Car is full");
            return false;
            }
        }
    }

    /**
     * Removes Passenger from Car
     * 
     * @param p Passenger
     * @return True if the operation was successful, and False otherwise.
     */
    public Boolean removePassenger(Passenger p){
        // Checks if passenger is already onboard
        if (passengersOnboard.contains(p)) {
            // Removes passenger
            passengersOnboard.remove(p);
            System.out.println("Passenger: "+p.getName()+ " has been removed.");
            return true;            
        } else {
            return false;
        }
    }

    /**
     * Prints out a list of all `Passenger`s aboard the car
     * 
     */
    public void printManifest(){
        System.out.println("Train Manifest: ");
        // if there is no one on board
        if (this.seatsRemaining() == this.maxCapacity) {
            System.out.println("This car is EMPTY.");            
        } 
         // prints out a list of all `Passenger`s aboard the car
        for (int i = 0; i < passengersOnboard.size(); i++) {
            String person = passengersOnboard.get(i).getName();
            System.out.println(person);
        }
    }

    public static void main(String[] args) {
        // Making Passengers
        Passenger jode = new Passenger("Jode");
        Passenger arri = new Passenger("Arriana");
        Passenger lizzy = new Passenger("Elizabeth");
        Passenger alice = new Passenger("Alice");
        Passenger bob = new Passenger("Bob");
        Passenger steve = new Passenger("Steve");

        ArrayList<Passenger> passengersOnboard = new ArrayList<>();

        // Passengers already onboard
        passengersOnboard.add(jode);
        passengersOnboard.add(arri);
        passengersOnboard.add(bob);

        // Creating a new Train Car 
        Car trainCar = new Car(passengersOnboard, 5);

        // Adding two passengers onboard
        trainCar.addPassenger(lizzy);
        trainCar.addPassenger(alice);

        trainCar.printManifest();

        // Checking if it'll add a passenger already onboard
        trainCar.addPassenger(jode);

        //Checking to see if it'll add a passener when already at max capacity
        trainCar.addPassenger(steve);

        //Checking it it'll remove a passenger
        trainCar.removePassenger(jode);

        trainCar.printManifest();

        // Adding a passenger onboard
        trainCar.addPassenger(steve);

        trainCar.printManifest();

    }
}