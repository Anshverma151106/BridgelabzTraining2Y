import java.util.Scanner;

/** Finds the first and last occurrence of a target in a sorted array. */
public class BinarySearchFirstLastOccurrence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of integers: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the sorted array:");
        for (int i = 0; i < n; i++) array[i] = scanner.nextInt();
        System.out.print("Enter the target value: ");
        int target = scanner.nextInt();

        System.out.println("First occurrence index: " + findBoundary(array, target, true));
        System.out.println("Last occurrence index: " + findBoundary(array, target, false));
        scanner.close();
    }

    private static int findBoundary(int[] array, int target, boolean first) {
        int left = 0, right = array.length - 1, answer = -1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (array[middle] == target) {
                answer = middle;
                if (first) right = middle - 1; else left = middle + 1;
            } else if (array[middle] < target) left = middle + 1;
            else right = middle - 1;
        }
        return answer;
    }
}
