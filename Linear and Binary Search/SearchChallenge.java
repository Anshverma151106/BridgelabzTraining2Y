import java.util.Arrays;
import java.util.Scanner;

/** Finds the first missing positive, then binary-searches a target in the sorted input. */
public class SearchChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of integers: ");
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) numbers[i] = scanner.nextInt();
        System.out.print("Enter the target value: ");
        int target = scanner.nextInt();

        boolean[] present = new boolean[n + 2];
        for (int number : numbers) if (number > 0 && number < present.length) present[number] = true;
        int firstMissingPositive = 1;
        while (present[firstMissingPositive]) firstMissingPositive++;

        Arrays.sort(numbers);
        int index = Arrays.binarySearch(numbers, target);
        System.out.println("First missing positive integer: " + firstMissingPositive);
        System.out.println("Sorted array: " + Arrays.toString(numbers));
        System.out.println("Target index after sorting: " + index);
        scanner.close();
    }
}
