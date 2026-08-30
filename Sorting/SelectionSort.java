import java.util.Arrays;
import java.util.Scanner;

/** Sorts exam scores in ascending order using Selection Sort. */
public class SelectionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of exam scores: ");
        int n = scanner.nextInt();
        int[] scores = new int[n];

        System.out.println("Enter " + n + " exam scores:");
        for (int i = 0; i < n; i++) scores[i] = scanner.nextInt();

        for (int i = 0; i < n - 1; i++) {
            int minimumIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minimumIndex]) minimumIndex = j;
            }
            int temp = scores[i]; scores[i] = scores[minimumIndex]; scores[minimumIndex] = temp;
        }
        System.out.println("Sorted exam scores: " + Arrays.toString(scores));
        scanner.close();
    }
}
