package assignment03Bmemento;

import java.util.Stack;
import assignment03B.Board;
import assignment03B.Command;

public class Originator {
    private Stack<Memento> executedStack = new Stack<>();
    private Stack<Command> redoStack = new Stack<>();

    public void createMemento(Board board, Command cm) {
        // Create the memento before the command changes the board
        MoveMemento m = new MoveMemento(board, cm);
        executedStack.push(m);
        redoStack.clear(); // Clear redo stack on new move
    }

    public void reset(Board board) {
        if (!executedStack.isEmpty()) {
            MoveMemento mmem = (MoveMemento) executedStack.pop();
            Command cm = mmem.getCommand();
            redoStack.push(cm);
            
            // Restore pieces to their original locations (Undo logic)
            board.setICCF(mmem.getFrom(), mmem.getFromPiece());
            board.setICCF(mmem.getTo(), mmem.getToPiece());
        }
    }

    public void redo(Board board) {
        if (!redoStack.isEmpty()) {
            Command cm = redoStack.pop();
            // Re-save state to executedStack before re-executing
            MoveMemento m = new MoveMemento(board, cm);
            executedStack.push(m);
            cm.execute();
        }
    }
}