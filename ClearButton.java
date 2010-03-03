import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

/**
 * Class for the clear button in the sudoku GUI.
 * 
 * @author Erik Jansson <br />
 *         Fredrik Nord
 */
public class ClearButton extends JButton implements ActionListener {
	SudokuPanel sp;

	/**
	 * Creates a new clear button.
	 * 
	 * @param sp
	 *            the sudoku panel the button is going to interact with
	 */
	public ClearButton(SudokuPanel sp) {
		super("Clear");
		this.sp = sp;
		addActionListener(this);
	}

	/**
	 * Called when the button is clicked.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		sp.clear();
	}
}