/**
 * Sudoku class, used to solve a sudoku.
 * 
 * @author Erik Jansson <br />
 *         Fredrik Nord
 */
public class Sudoku {
	private int[][] grid;
	public final static int GRID_SIZE = 9;

	/**
	 * Creates a new instance of the Sudoku class.
	 */
	public Sudoku() {
		grid = new int[GRID_SIZE][GRID_SIZE];
	}

	/**
	 * Retrieve the solution in the form of a multidimensional array.
	 * 
	 * @return The solution
	 */
	public int[][] getSolution() {
		return grid;
	}

	/**
	 * Sets the value of the specified square.
	 * 
	 * @param r
	 *            The row of the square
	 * @param c
	 *            The column of the square
	 * @param value
	 *            The value to be set
	 */
	public void setSquare(int r, int c, int value) {
		grid[r][c] = value;
	}

	/**
	 * Gets the value from the specified square.
	 * 
	 * @param r
	 *            The row of the square
	 * @param c
	 *            The column of the square
	 * @return The value in the square
	 */
	public int getSquare(int r, int c) {
		return grid[r][c];
	}

	/**
	 * Tries to solve the sudoku.
	 * 
	 * @return true if a solution was found
	 */
	public boolean solve() {
		return solve(0, 0);
	}

	/* Private recursive helper function to solve above :) */
	private boolean solve(int r, int c) {
		if (r == 9) {
			return true;
		}
		if (grid[r][c] == 0) {
			for (int i = 1; i < 10; i++) {
				if (row(r, c, i) && col(r, c, i) && region(r, c, i)) {
					grid[r][c] = i;
					boolean success = false;
					if (c == 8) {
						success = solve(r + 1, 0);
					} else {
						success = solve(r, c + 1);
					}

					if (success) {
						return true;
					}
				}
			}
		} else {
			if (row(r, c, grid[r][c]) && col(r, c, grid[r][c])
					&& region(r, c, grid[r][c])) {
				if (c == 8) {
					return solve(r + 1, 0);
				} else {
					return solve(r, c + 1);
				}
			}
		}
		grid[r][c] = 0;
		return false;
	}

	/**
	 * Checks if the value passed can be inserted in this row without breaking
	 * the sudoku rules.
	 * 
	 * @param r
	 *            The row to check
	 * @param c
	 *            The column to be skipped (i.e. the one we're standing on)
	 * @param value
	 *            The value to test
	 * @return true if it can be inserted without breaking sudoku rules of the
	 *         row
	 */
	private boolean row(int r, int c, int value) {
		for (int i = 0; i < GRID_SIZE; i++) {
			if (i != c) {
				if (grid[r][i] == value) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Checks if the value passed can be inserted in this column without
	 * breaking the sudoku rules.
	 * 
	 * @param r
	 *            The row to be skipped (i.e. the one we're standing on)
	 * @param c
	 *            The column to check
	 * @param value
	 *            The value to test
	 * @return true if it can be inserted without breaking sudoku rules of the
	 *         column
	 */
	private boolean col(int r, int c, int value) {
		for (int i = 0; i < GRID_SIZE; i++) {
			if (i != r) {
				if (grid[i][c] == value) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Checks if the value passed can be inserted in this 3x3 region without
	 * breaking the sudoku rules.
	 * 
	 * @param r
	 *            The row of the square
	 * @param c
	 *            The column of the square
	 * @param value
	 *            The value to test
	 * @return true if it can be inserted without breaking sudoku rules of the
	 *         region
	 */
	private boolean region(int r, int c, int value) {
		int sqrtGrid = (int) (Math.sqrt(GRID_SIZE));
		for (int regionR = (r / sqrtGrid) * sqrtGrid; regionR <= (r / sqrtGrid)
				* sqrtGrid + 2; regionR++) {
			for (int regionC = (c / sqrtGrid) * sqrtGrid; regionC <= (c / sqrtGrid)
					* sqrtGrid + 2; regionC++) {
				if (regionR != r && regionC != c) {
					if (grid[regionR][regionC] == value) {
						return false;
					}
				}
			}
		}
		return true;
	}

	/**
	 * Clears the sudoku grid.
	 */
	public void clear() {
		grid = new int[GRID_SIZE][GRID_SIZE];
	}
}