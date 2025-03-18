/*
 * Lab 2: Number Printing in Java
 * 
 * Description:
 * Involves creating a NumberPrinter class that prints numbers in different ways. 
 * It includes:
 * - A private method to print numbers between two given values, no matter their order.
 * - Public methods to print a sequence of numbers from an integer input, convert strings to numbers, 
 *   and generate random numbers using the private method.
 * The Main class tests all methods to ensure they work correctly.
 * 
 * Author: Amanda Ajredini
 * Date: 05/02/2025
*/

public class Main {
    public static void main(String[] args) {
        NumberPrinter np = new NumberPrinter();

        // Testing all methods from NumberPrinter
        System.out.println("Calling printFromXYtimes with arguments 4 and 10");
        System.out.print("Expected output: 4, 5, 6, 7, 8, 9, 10, 11, 12, 13\n");
        np.printFromXYtimes(4, 10); // Should print numbers from 4 to 13 
        
        System.out.println("Calling printFromStrings with arguments 9 and 15");
        System.out.print("Expected output: 9, 10, 11, 12, 13, 14, 15\n");
        np.printFromStrings("9", "15"); // Should print numbers from 9 to 15
        
        System.out.println("Calling printFromRandom with no arguments");
        System.out.print("Expected output: Range of random numbers\n");
        np.printFromRandom(); // Should print a random range of numbers
    }
}
