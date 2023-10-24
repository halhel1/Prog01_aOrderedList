import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * <main class, involves a call to getInputFile where a line of input(from the input file)
 * is stored in a string,and then split into 4 elements.The first element in the first index
 * decides whether that instance of arrList is appended to object aList or removed.The next
 * elements represent the car make,year,and price respectively. When arrList is added to
 * aList, the last elements mentioned are stored in their own variables suitable for their
 * type.Then an object newCar of the car class is created with these variables passed in
 * the arguments.Then using a call to the add method newCar is appended to aList. >
 * CSC 1351 Programming Project No <1>
 *
 * Section <002>
 *
 * @author <Hussain Alhelfi>
 * @since <10/23/23>
 * */
public class Prog01_aOrderedList {
    public static void main(String[] args) throws FileNotFoundException {
        aOrderedList aList=new aOrderedList();
        Scanner in = GetInputFile("Enter input filename: ");
        while(in.hasNextLine()){
            String inputStr=in.nextLine();
            String[] inputArr = inputStr.split(",");
            if (inputArr[0].equals("A")) {
                String make = inputArr[1];
                int year = Integer.parseInt(inputArr[2]);
                int price = Integer.parseInt(inputArr[3]);
                Car newCar = new Car(make, year, price);
                aList.add(newCar);
            }
            else if(inputArr[0].equals("D")){
                String make = inputArr[1];
                int year = Integer.parseInt(inputArr[2]);
                for (int i = 0; i < aList.size(); i++) {
                    Car car = (Car) aList.get(i);
                    if (car.getMake().equals(make) && car.getYear() == year) {
                        aList.remove(i);
                    }
                }
            }
        }
        in.close();
        PrintWriter outputFile = GetOutputFile("Enter output filename: ");
        if (outputFile != null) {
            outputFile.println("Number of cars: " + aList.size());
            for (int i = 0; i < aList.size(); i++) {
                Car car = (Car) aList.get(i);
                outputFile.println("Make: " + car.getMake());
                outputFile.println("Year: " + car.getYear());
                outputFile.println("Price: $" + car.getPrice()+"\n");
            }
            outputFile.close();
        }
    }
    /**
     * <allows main method to access the input file object "in",also checks the validity
     * of the input text file name. prompts the user to try again if the file can not be
     * located and handles FileNotFoundException >
     *
     * CSC 1351 Programming Project No <1>
     * Section <002>
     *
     * @author <Hussain Alhelfi>
     * @since <10/23/23>
     *
     */
    public static Scanner GetInputFile(String UserPrompt) throws FileNotFoundException {
        Scanner in = null;
        boolean isValidFile = false;
        Scanner userInput = new Scanner(System.in);
        String inputFileName=null;


        while (!isValidFile) {
            try {
                System.out.print(UserPrompt);
                inputFileName = userInput.nextLine();
                in = new Scanner(new File(inputFileName));
                isValidFile = true;
            } catch (FileNotFoundException e) {
                System.out.println("File specified <" + inputFileName + "> does not exist.");
                System.out.print("Would you like to continue? <Y/N> ");
                String response = userInput.nextLine().toUpperCase();
                if (!response.equals("Y")) {
                    break;
                }
            }
        }
        return in;
    }
    /**
     * <allows main method to access the output file object "writer",and creates an output file>>
     *
     * CSC 1351 Programming Project No <1>
     * Section <002>
     *
     * @author <Hussain Alhelfi>
     * @since <10/23/23>
     */
    public static PrintWriter GetOutputFile(String UserPrompt) throws FileNotFoundException{
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = null;
        boolean validFileName = false;
        while (!validFileName) {
            System.out.print(UserPrompt);
            String filename = scanner.nextLine();
            try {
                File outputFile = new File(filename);
                writer = new PrintWriter(outputFile);
                validFileName = true;
            } catch (FileNotFoundException e) {
                System.out.println("Invalid filename or write-protected folder. Please enter a valid filename or 'cancel' to exit.");
                if (filename.equalsIgnoreCase("cancel")) {
                    throw new FileNotFoundException();
                }
            }
        }
        return writer;
    }
}
