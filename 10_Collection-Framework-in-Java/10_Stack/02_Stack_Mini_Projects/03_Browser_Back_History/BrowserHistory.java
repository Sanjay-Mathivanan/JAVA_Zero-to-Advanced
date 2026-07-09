import java.util.ArrayDeque;
import java.util.Deque;

public class BrowserHistory {
    private final Deque<String> backStack = new ArrayDeque<>();
    private final Deque<String> forwardStack = new ArrayDeque<>();
    private String currentPage = "home.com";

    public void visit(String url) {
        backStack.push(currentPage); // Save history
        forwardStack.clear(); // Clear forward history
        currentPage = url;
        System.out.println("Visited: " + currentPage);
    }

    public void goBack() {
        if (!backStack.isEmpty()) {
            forwardStack.push(currentPage); // Save for forward
            currentPage = backStack.pop(); // Go back
            System.out.println("Back -> Current Page: " + currentPage);
        } else {
            System.out.println("No history to go back!");
        }
    }

    public void goForward() {
        if (!forwardStack.isEmpty()) {
            backStack.push(currentPage); // Save for back
            currentPage = forwardStack.pop(); // Go forward
            System.out.println("Forward -> Current Page: " + currentPage);
        } else {
            System.out.println("No history to go forward!");
        }
    }

    public static void main(String[] args) {
        BrowserHistory browser = new BrowserHistory();

        browser.visit("news.com");
        browser.visit("sports.com");
        browser.goBack(); // Reverts to news.com
        browser.goForward(); // Restores sports.com
    }
}
