import java.util.Arrays;
import java.util.Scanner;

/** Sorts student marks in ascending order using Bubble Sort. */
public class BubbleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of student marks: ");
        int n = scanner.nextInt();
        int[] marks = new int[n];

        System.out.println("Enter " + n + " student marks:");
        for (int i = 0; i < n; i++) marks[i] = scanner.nextInt();

        for (int pass = 0; pass < n - 1; pass++) {
            boolean swapped = false;
            for (int i = 0; i < n - 1 - pass; i++) {
                if (marks[i] > marks[i + 1]) {
                    int temp = marks[i];
                    marks[i] = marks[i + 1];
                    marks[i + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        System.out.println("Sorted student marks: " + Arrays.toString(marks));
        scanner.close();
    }
}
