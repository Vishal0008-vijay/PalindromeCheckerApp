import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

// Strategy Interface
interface PalindromeStrategy {
    boolean isPalindrome(String input);
}

// Stack-based strategy
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
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
}

// Deque-based strategy
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean isPalindrome(String input) {
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
}

// Context class
class PalindromeContext {
    private PalindromeStrategy strategy;

    // Inject strategy
    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    // Execute selected strategy
    public boolean check(String input) {
        if (strategy == null) throw new IllegalStateException("Strategy not set!");
        return strategy.isPalindrome(input);
    }
}

// Main Application
public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        System.out.println("Choose strategy: 1=Stack, 2=Deque");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        PalindromeContext context = new PalindromeContext();

        switch (choice) {
            case 1:
                context.setStrategy(new StackStrategy());
                break;
            case 2:
                context.setStrategy(new DequeStrategy());
                break;
            default:
                System.out.println("Invalid choice, defaulting to StackStrategy");
                context.setStrategy(new StackStrategy());
        }

        if (context.check(input)) {
            System.out.println("Result: It is a Palindrome");
        } else {
            System.out.println("Result: Not a Palindrome");
        }

        System.out.println("UC12 Execution Completed");

        scanner.close();
    }
}
