
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;
/**
 * This program reads a file containing operations to add or delete cars from a list,
 * processes these operations, and outputs the resulting list of cars to another file.
 *
 * CSC 1351 Programming Project No 1
 * Section 2
 *
 * @author Benny Ly
 * @since 3/17/24
 * */
public class Prog01_aOrderedList {

    /**
     * Main method to execute the program.
     *
     * @param args Command line arguments
     * @throws FileNotFoundException If the input file is not found
     *
     * CSC 1351 Programming Project No 1
     *
     * @author Benny Ly
     * @since 3/17/24
     *
     */
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = GetInputFile("Enter the input filename: ");
        aOrderedList list = clean(scan);
        PrintWriter write = GetOutputFile("Enter the output filename: ");
        String templateList = template(list);
        write.println(templateList);
        scan.close();
        write.close();
    }
    /**
     * Prompts the user for an input file name and returns a Scanner object for that file.
     *
     * @param UserPrompt The prompt message to display to the user
     * @return Scanner object for the input file
     * @throws FileNotFoundException If the input file is not found
     *
     * CSC 1351 Programming Project No 1
     *
     * @author Benny Ly
     * @since 3/17/24
     *
     */
    public static Scanner GetInputFile(String UserPrompt) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        String fileName;
        File file;
        do {
            System.out.print(UserPrompt);
            fileName = scan.nextLine();
            file = new File(fileName);
            if (!file.exists()) {
                boolean validInput = false;
                System.out.println("File specified <" + fileName + "> does not exist. Would you like to continue? <Y/N>");
                String answer = scan.nextLine().toUpperCase();
                while (!validInput) {
                    if (answer.equals("N")) {
                        throw new FileNotFoundException("Closing");
                    } else if (answer.equals("Y")) {
                        validInput = true;
                    } else {
                        System.out.println("Invalid input. Please enter <Y/N>");
                        answer = scan.nextLine().toUpperCase();
                    }
                }
            }

        } while (!file.exists());
        return new Scanner(file);
    }
    /**
     * Prompts the user for an output file name and returns a PrintWriter object for that file.
     *
     * @param UserPrompt The prompt message to display to the user
     * @return PrintWriter object for the output file
     * @throws FileNotFoundException If the output file cannot be written
     *
     * CSC 1351 Programming Project No 1
     *
     * @author Benny Ly
     * @since 3/17/24
     *
     */
    public static PrintWriter GetOutputFile(String UserPrompt) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        String fileName;
        boolean exit = false;
        do {
            System.out.print(UserPrompt);
            fileName = scan.nextLine();
            try {
                return new PrintWriter(fileName);
            } catch (FileNotFoundException e) {
                System.out.println("Unable to write to file specified <" + fileName + ">. Would you like to continue? <Y/N>");
                String answer = scan.nextLine().toUpperCase();
                boolean invalidInput = false;
                do {
                    if (answer.equals("N")) {
                        throw new FileNotFoundException("Program cancelled");
                    } else if (answer.equals("Y")) {
                        invalidInput = true;
                    } else {
                        System.out.println("Invalid input. Please enter <Y/N>");
                        answer = scan.nextLine().toUpperCase();
                    }
                } while (!invalidInput);
            }
        } while (!exit);
        return null;
    }
    /**
     * Formats the ordered list of cars into a string.
     *
     * @param orderedList The ordered list of cars
     * @return A formatted string representing the list of cars
     *
     * CSC 1351 Programming Project No 1
     *
     * @author Benny Ly
     * @since 3/17/24
     *
     */
    public static String template(aOrderedList orderedList){
        StringBuilder output = new StringBuilder();
        output.append("Number of cars:\t").append(orderedList.size());
        for (int i = 0; i < orderedList.size(); i++) {
            Car car = (Car) orderedList.get(i);

            output.append("\n\nMake:\t");
            if (car.getMake().isEmpty()) {
                output.append("null");
            } else {
                output.append(car.getMake());
            }

            output.append("\nYear:\t");
            if (car.getYear() == 0) {
                output.append("null");
            } else {
                output.append(car.getYear());
            }

            output.append("\nPrice:\t");
            if (car.getPrice() == 0) {
                output.append("null");
            } else {
                output.append(String.format("$%,d", car.getPrice()));
            }
        }
        return output.toString();
    }
    /**
     * Cleans and processes the input file, returning an ordered list of cars.
     *
     * @param scan The Scanner object for reading the input file
     * @return An ordered list of cars
     *
     * CSC 1351 Programming Project No 1
     *
     * @author Benny Ly
     * @since 3/17/24
     *
     */
    public static aOrderedList clean(Scanner scan) {
        aOrderedList list = new aOrderedList();
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            Scanner lineScan = new Scanner(line);
            lineScan.useDelimiter(",\\s*");
            if (lineScan.hasNext()) {
                String operation = lineScan.next();
                String make = "";
                int year = 0;
                int price = 0;

                if (lineScan.hasNext()) {
                    make = lineScan.next();
                }
                if (lineScan.hasNextInt()) {
                    year = lineScan.nextInt();
                }
                if (lineScan.hasNextInt()) {
                    price = lineScan.nextInt();
                }
                if (operation.equals("A")) {
                    Car car = new Car(make, year, price);
                    list.add(car);
                } else if (operation.equals("D")) {
                    list.reset();
                    while (list.hasNext()) {
                        Car currentCar = (Car) list.next();
                        if (currentCar.getMake().equals(make) && currentCar.getYear() == year) {
                            if (price == 0 || currentCar.getPrice() == price) {
                                list.remove();
                            }
                        }
                    }
                }
            }
            lineScan.close();
        }
        return list;
    }

}