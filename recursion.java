 import java.util.Scanner;
public class recursion {
   public static int multiplyNumbers(int[] numbers, int index) {
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
        int[] numbers = new int[5];//int 5 to loop 5 times

        System.out.println("Enter five numbers:");
//ask for 5 numbers
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scnr.nextInt();
        }

        int product = multiplyNumbers(numbers, 0);
//result of recursive method
        System.out.println("The product of the five numbers is: " + product);

        scnr.close();
    }
}
