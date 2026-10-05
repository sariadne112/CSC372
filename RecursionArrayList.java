import java.util.Scanner;
import java.util.ArrayList;

public class RecursionArrayList {

    public static double multiplyNumbers(ArrayList<Double> numbers, int index) {

        // Base case
        if (index == numbers.size() - 1) {
            return numbers.get(index);
        }

        // Recursive case
        return numbers.get(index) * multiplyNumbers(numbers, index + 1);
    }

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        ArrayList<Double> numbers = new ArrayList<Double>();

        System.out.println("Enter five numbers:");

        // Ask the user for five numbers
        for (int i = 0; i < 5; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers.add(scnr.nextDouble());
        }

        // Call recursive method
        double product = multiplyNumbers(numbers, 0);

        // Display result
        System.out.printf(
            "The product of the five numbers is: %.2f%n", product);

        scnr.close();
    }
}