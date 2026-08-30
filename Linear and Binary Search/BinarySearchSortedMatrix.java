import java.util.Scanner;

/** Searches for a target in a row-wise sorted matrix using Binary Search. */
public class BinarySearchSortedMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int columns = scanner.nextInt();
        int[][] matrix = new int[rows][columns];
        System.out.println("Enter the matrix values row by row:");
        for (int row = 0; row < rows; row++)
            for (int column = 0; column < columns; column++) matrix[row][column] = scanner.nextInt();
        System.out.print("Enter the target value: ");
        int target = scanner.nextInt();

        int left = 0, right = rows * columns - 1;
        boolean found = false;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            int value = matrix[middle / columns][middle % columns];
            if (value == target) { found = true; break; }
            if (value < target) left = middle + 1;
            else right = middle - 1;
        }
        System.out.println("Target found: " + found);
        scanner.close();
    }
}
