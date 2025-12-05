package assignment03A;

public class Capture implements Command {
    int from;
    int to;
    Piece captured;
    Board board;

    public Capture(Board brd, int iccf) {
        board = brd;
        from = iccf / 100;
        to = iccf % 100;
    }

    @Override
    public void execute() {
        // Store the captured piece
        captured = board.getICCF(to);

        // Remove the captured piece
        board.setICCF(to, Piece.NONE);

        // Move the attacking piece
        Piece attacker = board.getICCF(from);
        board.setICCF(from, Piece.NONE);
        board.setICCF(to, attacker);
    }

    @Override
    public void undo() {
        
        Piece attacker = board.getICCF(to);
        board.setICCF(to, captured);       
        board.setICCF(from, attacker);     
    }
}
