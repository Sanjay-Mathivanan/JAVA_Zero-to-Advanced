import java.util.ArrayDeque;
import java.util.Deque;

public class BalancedParentheses {
    public static boolean isBalanced(String expression) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : expression.toCharArray()) {
            // 1. Push opening brackets
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            // 2. Check closing brackets
            else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == ']' && top != '[') ||
                    (ch == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String expr1 = "{[()]}";
        String expr2 = "{[(])}";

        System.out.println("Expression: " + expr1 + " | Balanced? " + isBalanced(expr1)); // true
        System.out.println("Expression: " + expr2 + " | Balanced? " + isBalanced(expr2)); // false
    }
}
