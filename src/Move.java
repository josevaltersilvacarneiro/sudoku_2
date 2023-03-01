class Move {
	/**
	 * This class represents a move made by the player.
	 *
	 * To instantiate it, use the command below:
	 *
	 * int length = 4; // Board width
	 * int row    = 0; // Board row chosen by the user
	 * int column = 0; // Board column chosen by the user
	 *
	 * Move move = new Move(length, row, column);
	 *
	 * To access the row, use the command below:
	 *
	 * System.out.println(move.getRow());
	 *
	 * To access the column, use the command below:
	 *
	 * System.out.println(move.getColumn());
	 */

	private final int length;
	private int row;
	private int column;

	public Move(int length, int row, int column) {
		if (
			length < 4 ||
			row    < 0 ||
			column < 0 ||
			row    >= length ||
			column >= length
		   )
			throw new IllegalArgumentException("At least one argument is wrong");

		this.length = length;
		this.row    = row;
                this.column = column;
	}

	public int getRow() {
		return this.row;
	}

	public int getColumn() {
		return this.column;
	}
}
