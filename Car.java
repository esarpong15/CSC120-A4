import java.util.ArrayList;

public class Car implements CarRequirements{
    // Attributes
    private ArrayList<Passenger> passengersOnboard;
    private int maxCapacity;
    // Constructor that initilizes attributes
    public Car(ArrayList<Passenger> passengersOnboard, int maxCapacity ){
        this.passengersOnboard = passengersOnboard;
        this.maxCapacity = maxCapacity;
    }
    // Getter method for maxCapacity, return the maximum capacity
    public int getCapacity(){
        return maxCapacity;
    }
    // Getter method for seatsRemaining, return remaining seats
    public int seatsRemaining(){
        return maxCapacity-passengersOnboard.size();
    }
    
    public Boolean addPassenger(Passenger p){
        // Checks if the amount of Passengers is less than the max capacity
        if (passengersOnboard.size() < maxCapacity) {
            // if so, allows passengers onboard
            passengersOnboard.add(p);
            return true;
        } else {
            // does not allow passengers onboard
            System.out.println("Car is full");
            return false;
        }
    }

    public Boolean removePassenger(Passenger p){
        // Checks if passenger is already onboard
        if (passengersOnboard.contains(p)) {
            // Removes passenger
            passengersOnboard.remove(p);
            return true;            
        } else {
            return false;
        }
    }

    public void printManifest(){
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
}