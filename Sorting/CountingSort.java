import java.util.Arrays;
import java.util.Scanner;

/** Sorts student ages (10 through 18) in ascending order using Counting Sort. */
public class CountingSort {
    private static final int MINIMUM_AGE = 10;
    private static final int MAXIMUM_AGE = 18;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of student ages: ");
        int n = scanner.nextInt();
        int[] ages = new int[n];

        System.out.println("Enter " + n + " student ages (10 to 18):");
        for (int i = 0; i < n; i++) {
            ages[i] = scanner.nextInt();
            if (ages[i] < MINIMUM_AGE || ages[i] > MAXIMUM_AGE) {
                System.out.println("Invalid age: " + ages[i] + ". Ages must be from 10 to 18.");
                scanner.close();
                return;
            }
        }

        int[] count = new int[MAXIMUM_AGE - MINIMUM_AGE + 1];
        for (int age : ages) count[age - MINIMUM_AGE]++;
        for (int i = 1; i < count.length; i++) count[i] += count[i - 1];

        int[] sortedAges = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            sortedAges[--count[ages[i] - MINIMUM_AGE]] = ages[i];
        }
        System.out.println("Sorted student ages: " + Arrays.toString(sortedAges));
        scanner.close();
    }
}
