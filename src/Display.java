public abstract class Display {
	int     dimension;
	int     length;
	boolean quit;

	Board   board;

	public Display() {
		this.dimension = this.getDimension();
		this.length    = this.dimension * this.dimension;
		this.board     = new Board();
		this.quit      = false;
	}

	protected int getLength() {
		return this.length;
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

	public int getDimension() {
		// Not implemented
		throw new UnsupportedOperationException();
	}

	public String[] getPlayers() {
		// Not implemented
		throw new UnsupportedOperationException();
	}
	
	public void update() {
		// Not implemented
		throw new UnsupportedOperationException();
	}

	public Move getMove(String playerName) {
		// Not implemented
		throw new UnsupportedOperationException();
	}

	public boolean isRowFree(int row) {
		int section, house;

		for (int column = 0; column < this.getLength(); column++) {
			section = convertToSection(row, column);
			house   = convertToHouse(row, column);

			if (this.board.getSection(section).getHouse(house).getFree())
				return true;
		}

		return false;
	}

	public boolean isColumnFree(int column) {
		int section, house;

		for (int row = 0; row < this.getLength(); row++) {
			section = convertToSection(row, column);
			house   = convertToHouse(row, column);

			if (this.board.getSection(section).getHouse(house).getFree())
				return true;
		}

		return false;
	}

	public boolean isDiagonalFree() {
		int section, house;

		for (int i = 0; i < this.getLength(); i++) {
			section = convertToSection(i, i);
			house   = convertToHouse(i, i);

			if (this.board.getSection(section).getHouse(house).getFree())
				return true;
		}

		return false;
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
