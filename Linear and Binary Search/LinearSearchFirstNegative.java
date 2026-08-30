import java.util.Scanner;

/** Finds the index of the first negative number using Linear Search. */
public class LinearSearchFirstNegative {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of integers: ");
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) numbers[i] = scanner.nextInt();

        int index = -1;
        for (int i = 0; i < n; i++) {
            if (numbers[i] < 0) { index = i; break; }
        }
        System.out.println("Index of the first negative number: " + index);
        scanner.close();
    }
}
