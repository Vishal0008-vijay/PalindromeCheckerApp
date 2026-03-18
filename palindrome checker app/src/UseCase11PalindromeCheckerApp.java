import java.util.Scanner;

// Palindrome service class
class PalindromeChecker {

    // Method to check palindrome
    public boolean checkPalindrome(String input) {
        if (input == null || input.isEmpty()) return false;

        // Normalize string: remove spaces and lowercase
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        // Use two-pointer approach
        int left = 0;
        int right = normalized.length() - 1;

        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}

// Main application class
public class UseCase11PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        // Create PalindromeChecker object
        PalindromeChecker checker = new PalindromeChecker();

        // Check palindrome using the service
        if (checker.checkPalindrome(input)) {
            System.out.println("Result: It is a Palindrome");
        } else {
            System.out.println("Result: Not a Palindrome");
        }

        System.out.println("UC11 Execution Completed");

        scanner.close();
    }
}