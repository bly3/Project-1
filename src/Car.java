/**
 * Represents a Car object with make, year, and price attributes.
 *
 * CSC 1351 Programming Project No 1
 * Section 2
 *
 * @author Benny Ly
 * @since 3/17/24
 * */
public class Car implements Comparable<Car>{
    private String make;
    private int year;
    private int price;
    /**
     * Constructs a Car object with the specified make, year, and price.
     *
     * @param Make The make of the car
     * @param Year The year of the car
     * @param Price The price of the car
     *
     * CSC 1351 Programming Project No 1
     *
     * @author Benny Ly
     * @since 3/17/24
     *
     */
    public Car(String Make, int Year, int Price){
        make = Make;
        year = Year;
        price = Price;
    }
    /**
     * Gets the make of the car.
     *
     * @return The make of the car
     *
     * CSC 1351 Programming Project No 1
     *
     * @author Benny Ly
     * @since 3/17/24
     *
     */
    public String getMake(){
        return make;
    }
    /**
     * Gets the year of the car.
     *
     * @return The year of the car
     *
     * CSC 1351 Programming Project No 1
     *
     * @author Benny Ly
     * @since 3/17/24
     *
     */
    public int getYear(){
        return year;
    }
    /**
     * Gets the price of the car.
     *
     * @return The price of the car
     *
     * CSC 1351 Programming Project No 1
     *
     * @author Benny Ly
     * @since 3/17/24
     *
     */
    public int getPrice(){
        return price;
    }
    /**
     * Compares this Car with another Car based on their make and year.
     *
     * @param other The other Car object to compare
     * @return A negative integer, zero, or a positive integer if this Car is less than, equal to, or greater than the specified Car
     *
     * CSC 1351 Programming Project No 1
     *
     * @author Benny Ly
     * @since 3/17/24
     *
     */
    public int compareTo(Car other){
        if (make.compareTo(other.make)!=0){
            return make.compareTo(other.make);
        }
        else {
            return Integer.compare(year, other.year);
        }
    }
    /**
     * Returns a string representation of the Car object.
     *
     * @return A string representation of the Car object
     *
     * CSC 1351 Programming Project No 1
     *
     * @author Benny Ly
     * @since 3/17/24
     *
     */
    public String toString(){
        return "Make: " + make + ", Year : " + year + ", Price: " + price + ";";
    }



}
