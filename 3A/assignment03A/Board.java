package assignment03A;

import static assignment03A.SquareColor.BLACK;
import static assignment03A.SquareColor.WHITE;

import java.util.Stack;

public class Board {
	private Piece[][] board2 = new Piece[8][8];
	private SquareColor[][] boardColors = new SquareColor[8][8];
	private Stack<Command> executedStack = new Stack<>();
	private Stack<Command> undoneStack = new Stack<>();

	public Board() {
		for(byte i = 0; i < 8; i++) { // columns=files
			for(byte j = 0; j < 8; j++) { // rows=rank
				board2[i][j] = makeOpenSquare(i+1, j+1);
				if((i+j)%2 == 0) 
					boardColors[i][j] = BLACK;
				else
					boardColors[i][j] = WHITE;
			}
		}
		initializeBoard();
	}

	public Piece makeOpenSquare(int file, int rank) {
		return Piece.NONE;
	}

	public Piece getICCF(int code) {
		int file = (code / 10);
		int rank = (code % 10);
		return board2[file - 1][rank - 1];
	}

	public SquareColor getColor(int code) {
		int file = (code / 10);
		int rank = (code % 10);
		return boardColors[file - 1][rank - 1];
	}

	public void setICCF(int iccf, Piece p) {
		int rank = iccf % 10;
		int file = iccf / 10;
		board2[file - 1][rank - 1] = p;
	}

	public void setColor(int code, SquareColor col) {
		int file = (code / 10);
		int rank = (code % 10);
		boardColors[file - 1][rank - 1] = col;
	}

	public void initializeBoard() {
		setICCF(11, new Piece(WHITE, "R", "\u2656"));
		setICCF(21, new Piece(WHITE, "N", "\u2658"));
		setICCF(31, new Piece(WHITE, "B", "\u2657"));
		setICCF(41, new Piece(WHITE, "Q", "\u2655"));
		setICCF(51, new Piece(WHITE, "K", "\u2654"));
		setICCF(61, new Piece(WHITE, "B", "\u2657"));
		setICCF(71, new Piece(WHITE, "N", "\u2658"));
		setICCF(81, new Piece(WHITE, "R", "\u2656"));
		for(int k = 1; k <= 8; k++) setICCF(10*k+2, new Piece(WHITE, "P", "\u2659"));
		for(int k = 1; k <= 8; k++) setICCF(10*k+7, new Piece(BLACK, "P", "\u2659"));
		setICCF(18, new Piece(BLACK, "R", "\u2656"));
		setICCF(28, new Piece(BLACK, "N", "\u2658"));
		setICCF(38, new Piece(BLACK, "B", "\u2657"));
		setICCF(48, new Piece(BLACK, "Q", "\u2655"));
		setICCF(58, new Piece(BLACK, "K", "\u2654"));
		setICCF(68, new Piece(BLACK, "B", "\u2657"));
		setICCF(78, new Piece(BLACK, "N", "\u2658"));
		setICCF(88, new Piece(BLACK, "R", "\u2656"));
	}

	public void doNewCommand(Command cm) {
		// Clear the redo history
		undoneStack.clear();

		// Push command to executed history
		executedStack.push(cm);

		// Execute it
		cm.execute();
	}

	public void undoCommand() {
		if (!executedStack.isEmpty()) {
			Command cm = executedStack.pop();
			undoneStack.push(cm);
			cm.undo();
		}
	}

	public void redoCommand() {
		if (!undoneStack.isEmpty()) {
			Command cm = undoneStack.pop();
			executedStack.push(cm);
			cm.execute();
		}
	}
}
