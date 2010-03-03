import java.awt.*;
import javax.swing.*;

/**
 * The command panel at the bottom of the sudoku GUI, contains the buttons.
 * 
 * @author Erik Jansson <br />
 *         Fredrik Nord
 * 
 */
public class CommandPanel extends JPanel {
	private SolveButton sButton;
	private ClearButton cButton;

	/**
	 * Creates a new command panel with default layout (FlowLayout.LEFT). Also
	 * creates a SolveButton and a ClearButton and adds them to the panel.
	 * 
	 * @see SolveButton
	 * @see ClearButton
	 */
	public CommandPanel(SudokuPanel sp) {
		sButton = new SolveButton(sp);
		cButton = new ClearButton(sp);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		add(sButton);
		add(cButton);
	}
}
