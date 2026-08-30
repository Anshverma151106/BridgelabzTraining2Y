import java.util.Arrays;
import java.util.Scanner;

/** Sorts product prices in ascending order using Quick Sort. */
public class QuickSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of product prices: ");
        int n = scanner.nextInt();
        double[] prices = new double[n];

        System.out.println("Enter " + n + " product prices:");
        for (int i = 0; i < n; i++) prices[i] = scanner.nextDouble();

        quickSort(prices, 0, n - 1);
        System.out.println("Sorted product prices: " + Arrays.toString(prices));
        scanner.close();
    }

    private static void quickSort(double[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(double[] array, int low, int high) {
        double pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                double temp = array[i]; array[i] = array[j]; array[j] = temp;
            }
        }
        double temp = array[i + 1]; array[i + 1] = array[high]; array[high] = temp;
        return i + 1;
    }
}
