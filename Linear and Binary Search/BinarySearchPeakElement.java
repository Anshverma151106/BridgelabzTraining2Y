import java.util.Scanner;

/** Finds any peak element using Binary Search. */
public class BinarySearchPeakElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of integers: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) array[i] = scanner.nextInt();

        int left = 0, right = n - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (array[middle] < array[middle + 1]) left = middle + 1;
            else right = middle;
        }
        System.out.println("Peak element index: " + left);
        System.out.println("Peak element: " + array[left]);
        scanner.close();
    }
}
