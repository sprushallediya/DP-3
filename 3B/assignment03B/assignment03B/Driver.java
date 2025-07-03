package assignment03B;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

// https://en.wikipedia.org/wiki/Algebraic_notation_(chess)
// https://en.wikipedia.org/wiki/ICCF_numeric_notation
public class Driver {
	static JFrame frame = new JFrame("Chess Board");
	static Board board = new Board();
	static boolean showSteps = true;

	static void step(int n) throws InterruptedException {
		if (showSteps) Thread.sleep(1000);
		Command c = new Move(board, n/100, n%100);
		board.doNewCommand(c);
		if (showSteps) {
			frame.add(ChessBoard.drawGui(frame, board ));
			frame.validate();
		}
		printBoard();
	}

	public static void main(String[] args) {		
		Runnable r = new Runnable() {
			@Override
			public void run() {				
				JPanel controls = new JPanel(new GridLayout(0, 2, 4, 4));
				JButton undoButton = new JButton("Undo");
				undoButton .setFont(new Font("SansSerif", Font.BOLD, 24));
				controls.add(undoButton);
				JButton redoButton = new JButton("Redo");
				redoButton .setFont(new Font("SansSerif", Font.BOLD, 24));
				controls.add(redoButton);
				frame.add(controls, BorderLayout.PAGE_END);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.add(ChessBoard.drawGui(frame, board));
				frame.setSize(600, 750);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		};
		SwingUtilities.invokeLater(r);
		try {
			showSteps = true;
			step(7163);
			step(7866);
			step(3234);
			step(7776);
			step(2133);
			step(6877);
			step(4244);
			step(8868);
			step(5878);
			step(3164);
			step(4745);
			step(4123);
			step(4534);
			step(2334);
			step(3736);
			step(5254);
			step(2847);
			step(1141);
			step(4726);
			step(3435);
			step(3874);
			step(6475);
			step(2614);
			step(3513);
			step(1433);
			step(2233);
			step(6654);
			step(7557);
			step(4826);
			step(6134);
			step(5433);
			step(5735);
			step(6858);
			step(5161);
			step(7456);
			step(3526);
			step(5634);
			step(6171);
			step(3352);
			step(7161);
			step(5244);
			step(6171);
			step(4452);
			step(7161);
			step(5233);
			step(6171);
			step(1726);
			step(1324);
			step(1814);
			step(2426);
			step(3341);
			step(8283);
			step(1412);
			step(7182);
			step(4162);
			step(8151);
			step(5851);
			step(2648);
			step(7768);
			step(6351);
			step(3445);
			step(5163);
			step(6254);
			step(4828);
			step(2725);
			step(8384);
			step(8785);
			step(6355);
			step(7877);
			step(8271);
			step(6835);
			step(7161);
			step(5473);
			step(6151);
			step(3524);
			step(5141);
			step(4523);
			step(4131);
			step(7352);
			step(3121);
			step(5233);
			step(2131);
			step(1232);
			frame.add(ChessBoard.drawGui(frame, board ));
			frame.validate();		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void printBoard() {
		for(int i = 1; i <= 8; i++) {
			for(int j = 1; j <= 8; j++) {
				String p = board.getICCF(10*i+j);
				System.out.print(p + ",");
			}
		}
		System.out.println();
	}
}
