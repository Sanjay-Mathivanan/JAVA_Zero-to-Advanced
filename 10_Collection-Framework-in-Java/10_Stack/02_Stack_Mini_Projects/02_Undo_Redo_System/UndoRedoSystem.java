import java.util.ArrayDeque;
import java.util.Deque;

public class UndoRedoSystem {
    private final Deque<String> undoStack = new ArrayDeque<>();
    private final Deque<String> redoStack = new ArrayDeque<>();
    private String currentText = "";

    public void write(String newText) {
        undoStack.push(currentText); // Save state
        redoStack.clear(); // Clear redo on new action
        currentText += newText;
        System.out.println("Document: " + currentText);
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(currentText); // Save for redo
            currentText = undoStack.pop(); // Revert
            System.out.println("Undo -> Document: " + currentText);
        } else {
            System.out.println("Nothing to undo!");
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(currentText); // Save for undo
            currentText = redoStack.pop(); // Redo action
            System.out.println("Redo -> Document: " + currentText);
        } else {
            System.out.println("Nothing to redo!");
        }
    }

    public static void main(String[] args) {
        UndoRedoSystem doc = new UndoRedoSystem();

        doc.write("Hello ");
        doc.write("World!");
        doc.undo(); // Reverts "World!"
        doc.redo(); // Restores "World!"
    }
}
