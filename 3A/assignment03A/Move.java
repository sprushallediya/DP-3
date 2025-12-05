package assignment03A;

public class Move implements Command {
    int from;
    int to;
    Board board;

    public Move(Board brd, int iccf) {
        board = brd;
        from = iccf / 100;
        to = iccf % 100;
    }

    @Override
    public void execute() {
        // Getting the piece at the 'from' location
        Piece p = board.getICCF(from);

        // Here we are setting 'from' to NONE
        board.setICCF(from, Piece.NONE);

        // Set 'to' to the piece p
        board.setICCF(to, p);
    }

    @Override
    public void undo() {
        Piece p = board.getICCF(to);

        // Set 'to' to NONE
        board.setICCF(to, Piece.NONE);

        // Restore the piece to 'from'
        board.setICCF(from, p);
    }
}
