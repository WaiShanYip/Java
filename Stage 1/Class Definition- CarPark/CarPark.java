
/**
 * The class CarPark stores the basic details about the state of an individual car park.
 * The class CarPark has three fields called location, capacity and occupancy.
 * 
 * @author Wai Shan (Karen) Yip
 * @version 2018.10.8
 */
public class CarPark
{
    
    //The car park's location is a string field which gives the destination of the car park
    private String location;
    
    //The capacity is an integer field which gives the maximum cars the car park can hold
    private int capacity;

    //The occupancy is an integer field which shows the current number of cars parked in the car park 
    private int occupancy;

    /**
     * The values of the location and capacity are received by the class constructor
     * The occupancy level is set to 0 when an instance is created
     */
    public CarPark(String location, int capacity )
    {
        this.location = location;
        occupancy = 0;
        this.capacity = capacity;

    }

    /**
     * Get the location of the car park.
     * @return the location of the car park.
     */ 
    public String getLocation()
    {
        return location;
    }

    /**
     * Get the capacity of the car park.
     * @return the capacity, which is the maximum amount of cars the car park can hold.
     */
    public int getCapacity()
    {
        return capacity;
    }

    /**
     * Get the occupancy of the car park.
     * @return the occupancy, which is the current amount of cars parked in the car park.
     */
    public int getOccupancy()
    {
        return occupancy;
    }

    /**
     * park is a method which holds no parameters.
     * If the occupancy of the car park is greater or equal to the capacity,
     * an error message will be printed to explain the car park is full.
     * If the occupancy level is less than the capacity,
     * the car can park and the occupancy is increased by 1.
     */
    public void park()
    {
        if (occupancy >= capacity) {
            System.out.println ("The car park is full"); 
        }
        else {
            occupancy = occupancy + 1;
        }

    }

    /**
     * leave is a method which holds no parameters.
     * If the occupancy of the car park is greater than 0, 
     * the occupancy is decreased by 1 as the car leaves the car park.
     * If the occupancy of the car park is not greater than 0,
     * an error message is printed to explain the car park is empty so no cars are leaving.
     */
    public void leave()
    {
        if (occupancy > 0) {
            occupancy = occupancy - 1;
        }
        else {
            System.out.println ("The car park is empty");
        }
    }

    /**
     * Change the capacity of the car park.
     * @param newCapacity 
     * If the occupancy is greater than 0 and adding newCapacity makes the capacity less than
     * the current occupancy level then the capacity remains unchanged
     * An error message is printed to explain the capacity must remain unchanged
     * If adding newCapacity would make the capacity negative then the capacity is set to 0
     * and error message is printed to state that the car park is closed
     */
    public void changeCapacity(int newCapacity)
    {
        capacity = capacity + newCapacity;
        
        if (occupancy > 0 && capacity < occupancy) {
            capacity = capacity - newCapacity; // the capacity remains unchanged
            System.out.println ("Error: the capacity cannot be changed");

        }

        if (capacity < 0){
            capacity = 0;
            System.out.println ("The car park is now closed");
        }
    }

    /**
     * Prints out the details of the car park.
     * This includes the location of the car park as well as the availability of parking spaces.
     */
    public void printDetails()
    {
        //Simulate the printing of a ticket.
        System.out.println("##################");
        System.out.println("#" + location + " car park has " + (capacity - occupancy) + " spaces.");
        System.out.println("##################");
        System.out.println();

    }
}

