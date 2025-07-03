package assignment03Bmemento;

public class BoardMemento implements Memento {
    private final String[][] state;

    public BoardMemento(String[][] currentBoard) {
        this.state = new String[8][8];
        for (int i = 0; i < 8; i++) {
            System.arraycopy(currentBoard[i], 0, this.state[i], 0, 8);
        }
    }

    public String[][] getState() {
        return state;
    }
}
