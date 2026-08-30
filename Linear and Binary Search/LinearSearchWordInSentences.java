import java.util.Scanner;

/** Finds the first sentence containing a word using Linear Search. */
public class LinearSearchWordInSentences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of sentences: ");
        int n = Integer.parseInt(scanner.nextLine());
        String[] sentences = new String[n];
        System.out.println("Enter " + n + " sentences:");
        for (int i = 0; i < n; i++) sentences[i] = scanner.nextLine();
        System.out.print("Enter the word to search for: ");
        String word = scanner.nextLine();

        String result = "Not Found";
        for (String sentence : sentences) {
            if (sentence.toLowerCase().contains(word.toLowerCase())) {
                result = sentence;
                break;
            }
        }
        System.out.println("First matching sentence: " + result);
        scanner.close();
    }
}
