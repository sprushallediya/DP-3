package assignment03B;

public class Move implements Command {
	int from;
	int to;
	Board board;

	public Move(Board brd, int from, int to) {
		board = brd;
		this.from = from;
		this.to = to;
	}

	public int getFrom() {
		return from;
	}

	public int getTo() {
		return to;
	}

	@Override
	public void execute() {
		String p = board.getICCF(from);     
		board.setICCF(from, "  ");          
		board.setICCF(to, p);               
	}
}
