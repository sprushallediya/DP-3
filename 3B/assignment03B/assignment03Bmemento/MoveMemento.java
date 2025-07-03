package assignment03Bmemento;

import assignment03B.Board;
import assignment03B.Command;

class MoveMemento implements Memento {
	String fromPieceName;
	String toPieceName;
	Board board;
	Command cm;

	MoveMemento(Board boardIn, Command cmIn) {
		board = boardIn;
		cm = cmIn;
		fromPieceName = board.getICCF(cm.getFrom());
		toPieceName = board.getICCF(cm.getTo());
	}

	int getFrom() {
		return cm.getFrom();
	}

	int getTo() {
		return cm.getTo();
	}

	String getFromPiece() {
		return fromPieceName;
	}

	String getToPiece() {
		return toPieceName;
	}

	public Command getCommand() {
		return cm;
	}

	public String toString() {
		return cm.getFrom() + "->" + cm.getTo() + "/" + fromPieceName + "/" + toPieceName;
	}
}
