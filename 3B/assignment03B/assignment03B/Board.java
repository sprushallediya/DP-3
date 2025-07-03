package assignment03B;

import static assignment03B.SquareColor.BLACK;
import static assignment03B.SquareColor.WHITE;

import assignment03Bmemento.Originator;

public class Board {
	private String[][] board = new String[8][8];
	private SquareColor[][] boardColors = new SquareColor[8][8];
	public Originator originator = new Originator();

	public Board() {
		for (byte i = 0; i < 8; i++) { // columns=files
			for (byte j = 0; j < 8; j++) { // rows=rank
				board[i][j] = makeOpenSquare(i + 1, j + 1);
				if ((i + j) % 2 == 0)
					boardColors[i][j] = BLACK;
				else
					boardColors[i][j] = WHITE;
			}
		}
		initializeBoard();
	}

	public String makeOpenSquare(int file, int rank) {
		return "  ";
	}

	public String getICCF(int code) { // 57
		int file = (code / 10);
		int rank = (code % 10);
		return board[file - 1][rank - 1];
	}

	public SquareColor getColor(int code) { // 57
		int file = (code / 10);
		int rank = (code % 10);
		return boardColors[file - 1][rank - 1];
	}

	public void setICCF(int iccf, String p) {
		int rank = iccf % 10;
		int file = iccf / 10;
		board[file - 1][rank - 1] = p;
	}

	public void setColor(int code, SquareColor col) { // 57
		int file = (code / 10);
		int rank = (code % 10);
		boardColors[file - 1][rank - 1] = col;
	}

	public void initializeBoard() {
		setICCF(11, "WR");
		setICCF(21, "WN");
		setICCF(31, "WB");
		setICCF(41, "WQ");
		setICCF(51, "WK");
		setICCF(61, "WB");
		setICCF(71, "WN");
		setICCF(81, "WR");
		for (int k = 1; k <= 8; k++) setICCF(10 * k + 2, "WP");
		for (int k = 1; k <= 8; k++) setICCF(10 * k + 7, "BP");
		setICCF(18, "BR");
		setICCF(28, "BN");
		setICCF(38, "BB");
		setICCF(48, "BQ");
		setICCF(58, "BK");
		setICCF(68, "BB");
		setICCF(78, "BN");
		setICCF(88, "BR");
	}

	public void doNewCommand(Command cm) {
		originator.createMemento(this, cm); // Save state before executing
		cm.execute(); // Perform the command
	}

	public void undoCommand() {
		originator.reset(this); // Restore from undo stack
	}

	public void redoCommand() {
		originator.redo(this); // Reapply from redo stack
	}
}
