import javax.swing.*;
import java.awt.*;

/**
 * The graphical interface of the sudoku application.
 * 
 * @author Erik Jansson <br />
 *         Fredrik Nord
 * 
 */
public class SudokuGUI {
	JFrame frame;
	SudokuPanel sPanel;
	CommandPanel cPanel;
	SolveButton sButton;
	ClearButton cButton;

	/**
	 * Creates a new GUI containing a sudoku panel and a command panel.
	 * 
	 * @see SudokuPanel
	 * @see CommandPanel
	 */
	public SudokuGUI() {
		frame = new JFrame("Sudoku Solver");
		sPanel = new SudokuPanel();
		cPanel = new CommandPanel(sPanel);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(sPanel, BorderLayout.NORTH);
		frame.add(cPanel, BorderLayout.SOUTH);

		frame.setResizable(false);
		frame.setVisible(true);
		frame.pack();
	}

	/**
	 * Creates a new instance of the sudoku GUI (i.e. runs the program).
	 * 
	 * @param args
	 *            arguments to the program, not implemented
	 */
	public static void main(String[] args) {
		new SudokuGUI();
	}
}