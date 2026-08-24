import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        if (n <= 1) {
            System.out.println("Not Prime");
        } else {
        
            for (int i = 2; i <= n; i++) {
                if (n % i == 0) {
                    System.out.println("Prime");
                }
            }
        }
    }
}