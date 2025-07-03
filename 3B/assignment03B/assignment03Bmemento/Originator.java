package assignment03Bmemento;

import java.util.Stack;
import assignment03B.Board;
import assignment03B.Command;

public class Originator {
	private Stack<Memento> executedStack = new Stack<>();
	private Stack<Command> redoStack = new Stack<>();

	public void createMemento(Board board, Command cm) {
		MoveMemento m = new MoveMemento(board, cm);
		executedStack.push(m);
		redoStack.clear();
	}

	public void reset(Board board) {
		if (!executedStack.isEmpty()) {
			MoveMemento mmem = (MoveMemento) executedStack.pop();
			Command cm = mmem.getCommand();
			redoStack.push(cm);
			board.setICCF(mmem.getFrom(), mmem.getFromPiece());
			board.setICCF(mmem.getTo(), mmem.getToPiece());
		}
	}

	public void redo(Board board) {
		if (!redoStack.isEmpty()) {
			Command cm = redoStack.pop();
			MoveMemento m = new MoveMemento(board, cm);
			executedStack.push(m);
			cm.execute();
		}
	}
}
