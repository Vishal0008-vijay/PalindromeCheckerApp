public class UseCase2PalindromeCheckerApp {

    public static void main(String[] args) {

        // Hardcoded string to check
        String input = "madam";

        // Reverse the string
        String reversed = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed = reversed + input.charAt(i);
        }

        // Display input
        System.out.println("Input String: " + input);

        // Check if palindrome
        if (input.equals(reversed)) {
            System.out.println("Result: It is a Palindrome");
        } else {
            System.out.println("Result: Not a Palindrome");
        }

        System.out.println("UC2 Execution Completed");
    }
}