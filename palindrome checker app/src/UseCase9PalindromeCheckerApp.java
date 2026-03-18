import java.util.Scanner;

public class UseCase9PalindromeCheckerApp {

    // Recursive function to check palindrome
    public static boolean isPalindrome(String str, int left, int right) {
        // Base case: crossed indices or empty string
        if (left >= right) {
            return true;
        }

        // Check characters at current positions
        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }

        // Recurse for inner substring
        return isPalindrome(str, left + 1, right - 1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        // Call recursive palindrome function
        if (isPalindrome(input, 0, input.length() - 1)) {
            System.out.println("Result: It is a Palindrome");
        } else {
            System.out.println("Result: Not a Palindrome");
        }

        System.out.println("UC9 Execution Completed");

        scanner.close();
    }
}