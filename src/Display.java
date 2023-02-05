public abstract class Display implements Interaction {
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
	
	protected boolean isOptionValid(int section, int number) {
		return section <= 4 && section > 0 && number <= 4 && number > 0;
	}

	public boolean getQuit() {
		for (int i = 0; i < this.getLength(); i++)
			if (this.board.isSectionFree(i))
				return false;

		return true;
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
		int section, house;
		int rowSum = 0;

		for (int column = 0; column < this.getLength(); column++) {
			section = convertToSection(row, column);
			house   = convertToHouse(row, column);

			rowSum += this.board.getSection(section).getHouse(house).getValue();
		}

		return rowSum;
	}

	public int columnSum(int column) {
		int section, house;
                int columnSum = 0; 
                
                for (int row = 0; row < this.getLength(); row++) {
                        section = convertToSection(row, column);
                        house   = convertToHouse(row, column);
                        
                        columnSum += this.board.getSection(section).getHouse(house).getValue();
                }       
                
                return columnSum;
	}

	public int diagonalSum() {
		int section, house;
                int diagonalSum = 0;

                for (int i = 0; i < this.getLength(); i++) {       
                        section = convertToSection(i, i);
                        house   = convertToHouse(i, i);
                        
                        diagonalSum += this.board.getSection(section).getHouse(house).getValue();
                }       
                
                return diagonalSum;
	}
}
