import java.util.Scanner;

/** Finds the rotation point (smallest element's index) in a rotated sorted array. */
public class BinarySearchRotationPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of integers: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the rotated sorted array:");
        for (int i = 0; i < n; i++) array[i] = scanner.nextInt();

        int left = 0, right = n - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (array[middle] > array[right]) left = middle + 1;
            else right = middle;
        }
        System.out.println("Rotation point index: " + left);
        System.out.println("Smallest element: " + array[left]);
        scanner.close();
    }
}
