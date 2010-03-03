import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * The solve button in the sudoku GUI.
 * 
 * @author Erik Jansson <br />
 *         Fredrik Nord
 * 
 */
public class SolveButton extends JButton implements ActionListener {
	SudokuPanel sp;

	/**
	 * Creates a new solve button.
	 * 
	 * @param sp
	 *            the sudoku panel the button is going to interact with
	 */
	public SolveButton(SudokuPanel sp) {
		super("Solve");
		this.sp = sp;
		addActionListener(this);
	}

	/**
	 * Called when the button is clicked.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		sp.solve();

	}
}