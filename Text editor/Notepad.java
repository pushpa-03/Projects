package notepad;

import action.Action;

import java.time.LocalDateTime;
import java.util.*;

public class Notepad {
    private int id = 1;
    private String notepad[];
    private Stack<Action> undoAction;
    private Stack<Action> redoAction;
    private Queue<String> clipBorad;
    private int capasity;

    public Notepad(int capasity) {
        notepad = new String[capasity];

        for (int i = 0; i < capasity; i++) {
            notepad[i] = "";
        }

        undoAction = new Stack<>();
        redoAction = new Stack<>();
        clipBorad = new LinkedList<>();
        this.capasity = capasity;
    }

    public void display() {
        System.out.println("________________________________________________");
        for (int i = 0; i < notepad.length; i++) {
            System.out.print("| ");
            System.out.println(notepad[i]);
        }
        System.out.println("________________________________________________");
    }

    public void display(int startingLine, int endingLine) {
        if (startingLine < 0 || startingLine > endingLine || endingLine > this.capasity) {
            System.out.println("Unable to display text! please check the input");
            return;
        }

        // Line index start from 0 therefore startingLine-1
        System.out.println("________________________________________________");
        for (int i = startingLine - 1; i < endingLine; i++) {
            System.out.print("| ");
            System.out.println(notepad[i]);
        }
        System.out.println("________________________________________________");
    }

    public void insertLine(int lineNumber, String text) {
        if (lineNumber > capasity) {
            System.out.println("Notepad limit crossed");
            return;
        }

        notepad[lineNumber - 1] = text;
        // if we want to undo then we can do it therefore here we push to stack
        undoAction.push(new Action(id++, LocalDateTime.now(), true, lineNumber, text));
        display();
    }

    // delete one line
    public void delete(int lineNumber) {
        if (lineNumber > capasity) {
            System.out.println("No such row to delete");
            return;
        }

        if (notepad[lineNumber - 1].isEmpty()) {
            System.out.println("Nothing to delete");
            return;
        }

        // before deleting store it in redo stack so that we can perfom redo action
        redoAction.push(new Action(id++, LocalDateTime.now(), false, lineNumber, notepad[lineNumber - 1]));
        notepad[lineNumber - 1] = ""; // deleteing line based on given linenumber
    }

    // delete multiple lines
    public void delete(int startingLine, int endingLine) {
        if (startingLine > endingLine || endingLine > capasity || startingLine < 0) {
            System.out.println("Unable to delete. please check the input");
            return;
        }

        for (int i = startingLine; i < endingLine; i++) {
            delete(i);
        }
    }

    public void copy(int startingLine, int endingLine) {
        if (startingLine > endingLine || endingLine > capasity) {
            System.out.println("Unable to copy");
        }

        String copytext = "";
        for (int i = startingLine - 1; i < endingLine; i++) {
            // copy the text as it is so use \n so that it
            copytext += (notepad[i]);
        }

        if (!copytext.isEmpty()) {
            // copyed text we can paste any time so store in queue
            clipBorad.add(copytext);
        }
    }

    // After pasteing it not caring about below lines
    public void paste(int lineNumber) {
        if (this.clipBorad.isEmpty()) {
            System.out.println("Nothing to paste");
            return;
        }

        // here we must perform peek not pop because if want to paste multiple time the
        // same copied text we can do it
        String text = clipBorad.peek();
        insertLine(lineNumber, text);
    }

    public void undo() {
        if (this.undoAction.isEmpty()) {
            System.out.println("Nothing to undo");
            return;
        }

        Action action = this.undoAction.peek();
        this.undoAction.pop();

        delete(action.getLineNumber());
    }

    public void redo() {
        if (this.redoAction.isEmpty()) {
            System.out.println("Nothing to redo");
            return;
        }

        Action action = redoAction.peek();
        redoAction.pop();

        insertLine(action.getLineNumber(), action.getText());

    }

}
