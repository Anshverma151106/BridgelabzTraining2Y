import java.util.Arrays;
import java.util.Scanner;

/** Sorts job applicants' salary demands in ascending order using Heap Sort. */
public class HeapSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of salary demands: ");
        int n = scanner.nextInt();
        double[] salaries = new double[n];

        System.out.println("Enter " + n + " salary demands:");
        for (int i = 0; i < n; i++) salaries[i] = scanner.nextDouble();

        heapSort(salaries);
        System.out.println("Sorted salary demands: " + Arrays.toString(salaries));
        scanner.close();
    }

    private static void heapSort(double[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) heapify(array, array.length, i);
        for (int end = array.length - 1; end > 0; end--) {
            double temp = array[0]; array[0] = array[end]; array[end] = temp;
            heapify(array, end, 0);
        }
    }

    private static void heapify(double[] array, int heapSize, int root) {
        int largest = root, left = 2 * root + 1, right = 2 * root + 2;
        if (left < heapSize && array[left] > array[largest]) largest = left;
        if (right < heapSize && array[right] > array[largest]) largest = right;
        if (largest != root) {
            double temp = array[root]; array[root] = array[largest]; array[largest] = temp;
            heapify(array, heapSize, largest);
        }
    }
}
