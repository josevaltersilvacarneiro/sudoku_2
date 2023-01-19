class Display {
	int     dimension;
	int     length;
	boolean quit;

	Board   board;

	public Display() {
		this.dimension = this.get_dimension();
		this.length    = this.dimension * this.dimension;
		this.board     = new Board();
		this.quit      = false;
	}

	private int convertToRS(int sr, int hc) {
		return (sr / this.dimension) * this.dimension + hc / this.dimension;
	}

	private int convertToCH(int sr, int hc) {
		return (sr % this.dimension) * this.dimension + hc % this.dimension;
	}

	protected int convertToRow(int section, int house) {
		return this.convertToRS(section, house);
	}

	protected int convertToColumn(int section, int house) {
		return this.convertToCH(section, house);
	}

	protected int convertToSection(int row, int column) {
		return this.convertToRS(row, column);
	}

	protected int convertToHouse(int row, int column) {
		return this.convertToCH(row, column);
	}

	public Move getMove() {
		int section, house;
		int row, column;

		Move move;
		
		do {
			section = getNumber();
			house   = getNumber();

			row	= this.convertToRow(section, house);
			column	= this.convertToColumn(section, house);

			move    = new Move(
						this.length,
						row,
						column
					  );
		} while (
				!move.isOptionValid() ||
				!this.board.isSectionFree(section) ||
				!this.board.isHouseFree(section, house)
			);

		return move;
	}

	public boolean isRowFree(int row) {
		return true;
	}

	public boolean isColumnFree(int column) {
		return true;
	}

	public boolean isDiagonalFree() {
		return true;
	}

	public int rowSum(int row) {
		return 0;
	}

	public int columnSum(int column) {
		return 0;
	}

	public int diagonalSum() {
		return 1;
	}
}
