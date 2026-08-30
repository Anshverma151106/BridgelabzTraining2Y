import java.util.Arrays;
import java.util.Scanner;

/** Sorts employee IDs in ascending order using Insertion Sort. */
public class InsertionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of employee IDs: ");
        int n = scanner.nextInt();
        int[] employeeIds = new int[n];

        System.out.println("Enter " + n + " employee IDs:");
        for (int i = 0; i < n; i++) employeeIds[i] = scanner.nextInt();

        for (int i = 1; i < n; i++) {
            int key = employeeIds[i];
            int j = i - 1;
            while (j >= 0 && employeeIds[j] > key) {
                employeeIds[j + 1] = employeeIds[j];
                j--;
            }
            employeeIds[j + 1] = key;
        }
        System.out.println("Sorted employee IDs: " + Arrays.toString(employeeIds));
        scanner.close();
    }
}
