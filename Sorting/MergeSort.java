import java.util.Arrays;
import java.util.Scanner;

/** Sorts book prices in ascending order using Merge Sort. */
public class MergeSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of book prices: ");
        int n = scanner.nextInt();
        double[] prices = new double[n];

        System.out.println("Enter " + n + " book prices:");
        for (int i = 0; i < n; i++) prices[i] = scanner.nextDouble();

        mergeSort(prices, 0, n - 1);
        System.out.println("Sorted book prices: " + Arrays.toString(prices));
        scanner.close();
    }

    private static void mergeSort(double[] array, int left, int right) {
        if (left >= right) return;
        int middle = left + (right - left) / 2;
        mergeSort(array, left, middle);
        mergeSort(array, middle + 1, right);
        merge(array, left, middle, right);
    }

    private static void merge(double[] array, int left, int middle, int right) {
        double[] temp = new double[right - left + 1];
        int i = left, j = middle + 1, k = 0;
        while (i <= middle && j <= right) temp[k++] = array[i] <= array[j] ? array[i++] : array[j++];
        while (i <= middle) temp[k++] = array[i++];
        while (j <= right) temp[k++] = array[j++];
        System.arraycopy(temp, 0, array, left, temp.length);
    }
}
