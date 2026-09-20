 import java.util.Scanner;
public class recursion {
   public static double multiplyNumbers(double[] numbers, int index) {
        // Base case
        if (index == numbers.length - 1) {
            return numbers[index];
        }
        // Recursive case
        return numbers[index] * multiplyNumbers(numbers, index + 1);
    }
//main
    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        double[] numbers = new double[5];//loop 5 times

        System.out.println("Enter five numbers:");
//ask for 5 numbers
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scnr.nextDouble();
        }

        double product = multiplyNumbers(numbers, 0);
//result of recursive method
        System.out.printf("The product of the five numbers is: %.2f%n", product);

        scnr.close();
    }
}
