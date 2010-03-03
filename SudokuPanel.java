import java.awt.*;
import javax.swing.*;

/**
 * The sudoku panel containing the grid of text fields representing the squares.
 * 
 * @author Erik Jansson <br />
 *         Fredrik Nord
 * 
 */
public class SudokuPanel extends JPanel {
	JTextField[][] textFields;
	Sudoku sudoku;
	boolean paint;

	/**
	 * Creates a new sudoku panel.
	 */
	public SudokuPanel() {
		super();
		textFields = new JTextField[Sudoku.GRID_SIZE][Sudoku.GRID_SIZE];
		sudoku = new Sudoku();
		this.setLayout(new GridLayout(Sudoku.GRID_SIZE, Sudoku.GRID_SIZE));

		paint = true;
		for (int r = 0; r < Sudoku.GRID_SIZE; r++) {
			for (int c = 0; c < Sudoku.GRID_SIZE; c++) {
				textFields[r][c] = new JTextField(2);
				paintSquare(r, c);
				if ((c + 1) % 3 == 0) {
					paint = !paint;
				}
				Font f = new Font("Dialog", Font.PLAIN, 18);
				textFields[r][c].setFont(f);
				textFields[r][c].setHorizontalAlignment(JTextField.CENTER);
				this.add(textFields[r][c]);
			}
			if ((r + 1) / 3 == 1) {
				paint = false;
			} else {
				paint = true;
			}
		}
	}

	/**
	 * Clears the grid by emptying the text fields and calling the clear method
	 * in the sudoku class.
	 */
	public void clear() {
		for (int r = 0; r < Sudoku.GRID_SIZE; r++) {
			for (int c = 0; c < Sudoku.GRID_SIZE; c++) {
				textFields[r][c].setText("");
			}
		}
		sudoku.clear();
	}

	/**
	 * Solves the sudoku. Before actually solving the sudoku it checks if the
	 * input was correct (only numbers 1-9) an if it is it calls the solve
	 * method in the sudoku class. If any of the controls fails or if the sudoku
	 * doesn't have a solution it displays a messagebox stating that.
	 * 
	 */
	public void solve() {
		int[][] sudokuNumbers = new int[Sudoku.GRID_SIZE][Sudoku.GRID_SIZE];
		boolean notANumber = false;
		boolean illegalNumber = false;
		for (int r = 0; r < Sudoku.GRID_SIZE; r++) {
			for (int c = 0; c < Sudoku.GRID_SIZE; c++) {

				String currentNumber = textFields[r][c].getText();
				int number = 0;
				try {
					if (!currentNumber.equals("")) {
						number = Integer.parseInt(currentNumber);
						if (!legalNumber(number)) {
							illegalNumber = true;
						}
					}
					sudoku.setSquare(r, c, number);
				} catch (NumberFormatException e) {
					notANumber = true;
				}
			}
		}
		if (notANumber) {
			JOptionPane.showMessageDialog(this, "Only numbers can be entered");
		} else if (illegalNumber) {
			JOptionPane.showMessageDialog(this,
					"Only numbers between 1 and 9 can be entered");
		} else {
			boolean solved = sudoku.solve();
			if (solved) {
				sudokuNumbers = sudoku.getSolution();
				for (int r = 0; r < Sudoku.GRID_SIZE; r++) {
					for (int c = 0; c < Sudoku.GRID_SIZE; c++) {
						textFields[r][c].setText("" + sudokuNumbers[r][c]);
					}
				}
			} else {
				JOptionPane.showMessageDialog(this,
						"The entered sudoku has no solution");
			}
		}
	}

	/**
	 * Private method for checking if the number is okay in a sudoku.
	 * 
	 * @param n
	 *            the number to check
	 * @return true if the number is between 1 and 9
	 */
	private boolean legalNumber(int n) {
		return n >= 1 && n <= 9;
	}

	/**
	 * Private method to paint some of the squares with a grey background.
	 * 
	 * @param r
	 *            the row of the square to paint
	 * @param c
	 *            the column of the square to paint
	 */
	private void paintSquare(int r, int c) {
		if (paint) {
			textFields[r][c].setBackground(new Color(200, 200, 200));
		}
	}
}