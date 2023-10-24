/**
 * <class that creates Car objects and implements Comparable interface>
 *
 * CSC 1351 Programming Project No <1>
 * Section <002>
 *
 * @author <Hussain Alhelfi>
 * @since <10/23/23>
 * */
public class Car implements Comparable<Car>{
    private String make;
    //make is a characteristic of the Car object and will be used in the constructor
    private int year;
    //year is a characteristic of the Car object and will be used in the constructor
    private int price;
    //price is a characteristic of the Car object and will be used in the constructor

    /**
     * <constructor of the Car class, creates the objects that will be elements in the main array>
     *
     * CSC 1351 Programming Project No <1>
     * Section <002>
     *
     * @author <Hussain Alhelfi>
     * @since <10/23/23>
     *
     */

    //Make,Year,Price are the parameters that must be met when an object of type Car is created
    public Car(String Make, int Year, int Price){
        make=Make;
        year=Year;
        price=Price;
    }
    /**
     * <the following three methods are getters that will allow the private variables
     * make,year,and price to be accessed in the main method(principal of least privilege)>
     *
     * CSC 1351 Programming Project No <1>
     * Section <002>
     *
     * @author <Hussain Alhelfi>
     * @since <10/23/23>
     *
     */
    public String getMake(){
        return make;
    }
    public int getYear(){
        return year;
    }
    public int getPrice(){
        return price;
    }
    /**
     * <compares Car based on make if they are not equal otherwise compare by year,
     * helps sort the array in order>
     *
     * CSC 1351 Programming Project No <1>
     * Section <002>
     *
     * @author <Hussain Alhelfi>
     * @since <10/23/23>
     *
     */
    public int compareTo(Car other){
        if(make.compareTo(other.make)!=0){
            return (make.compareTo(other.make));
        }
        else{
            return Integer.compare(year,other.year);
        }
    }
    /**
     * <returns a String with the Car object characteristics>
     *
     * CSC 1351 Programming Project No <1>
     * Section <002>
     *
     * @author <Hussain Alhelfi>
     * @since <10/23/23>
     *
     */
    public String toString(){
        return "Make: "+ make + ", Year : " + year + ", Price: " + price + ";";
    }

}
