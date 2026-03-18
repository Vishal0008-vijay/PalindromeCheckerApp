import java.util.Scanner;

public class UseCase10PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        // Normalize string: remove spaces and convert to lowercase
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // Reverse normalized string
        String reversed = "";
        for (int i = normalized.length() - 1; i >= 0; i--) {
            reversed += normalized.charAt(i);
        }

        // Compare normalized and reversed strings
        if (normalized.equals(reversed)) {
            System.out.println("Result: It is a Palindrome");
        } else {
            System.out.println("Result: Not a Palindrome");
        }

        System.out.println("UC10 Execution Completed");

        scanner.close();
    }
}
