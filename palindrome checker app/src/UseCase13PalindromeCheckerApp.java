import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Scanner;

public class UseCase13PalindromeCheckerApp {

    // Stack-based palindrome check
    public static boolean stackPalindrome(String input) {
        Stack<Character> stack = new Stack<>();
        String normalized = input.replaceAll("\\s+", "").toLowerCase();

        for (char ch : normalized.toCharArray()) {
            stack.push(ch);
        }

        String reversed = "";
        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        return normalized.equals(reversed);
    }

    // Deque-based palindrome check
    public static boolean dequePalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new LinkedList<>();

        for (char ch : normalized.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }

    // Two-pointer string approach
    public static boolean twoPointerPalindrome(String input) {
        String normalized = input.replaceAll("\\s+", "").toLowerCase();
        int left = 0;
        int right = normalized.length() - 1;

        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        // Stack approach timing
        long startStack = System.nanoTime();
        boolean stackResult = stackPalindrome(input);
        long endStack = System.nanoTime();
        long stackTime = endStack - startStack;

        // Deque approach timing
        long startDeque = System.nanoTime();
        boolean dequeResult = dequePalindrome(input);
        long endDeque = System.nanoTime();
        long dequeTime = endDeque - startDeque;

        // Two-pointer approach timing
        long startTwoPointer = System.nanoTime();
        boolean twoPointerResult = twoPointerPalindrome(input);
        long endTwoPointer = System.nanoTime();
        long twoPointerTime = endTwoPointer - startTwoPointer;

        // Display results
        System.out.println("\n--- Palindrome Check Results ---");
        System.out.println("Stack Result: " + stackResult + " | Time: " + stackTime + " ns");
        System.out.println("Deque Result: " + dequeResult + " | Time: " + dequeTime + " ns");
        System.out.println("Two-Pointer Result: " + twoPointerResult + " | Time: " + twoPointerTime + " ns");
        System.out.println("UC13 Execution Completed");

        scanner.close();
    }
}
