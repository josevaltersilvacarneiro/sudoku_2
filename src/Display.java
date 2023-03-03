import static pkg.Utils.*;

public abstract class Display implements Interaction {
	/**
	 * This abstract class implements the interface with
	 * the players.
	 *
	 * To be used, the class that represents the display
	 * type must extend it and implement the Interaction
	 * interface. For example:
	 *
	 * public TypeDisplay extends Display {
	 * 	[...]
	 * }
	 */

	private   final int     dimension;
	private   final int     length;
	protected final Board   board;

	private boolean quit;

	public Display() {
		this.dimension = this.getDimension();
		this.length    = (int) java.lang.Math.pow(this.dimension, 2);
		this.board     = new Board(this.dimension);
		this.quit      = false;
	}

	protected int getLength() {
		return this.length;
	}

	protected int convertToRow(int section, int house) {
		return convertToRowSection(this.dimension, section, house);  // See Utils.java
	}

	protected int convertToColumn(int section, int house) {
		return convertToColumnHouse(this.dimension, section, house); // See Utils.java
	}

	protected int convertToSection(int row, int column) {
		return convertToRowSection(this.dimension, row, column);     // See Utils.java
	}

	protected int convertToHouse(int row, int column) {
		return convertToColumnHouse(this.dimension, row, column);    // See Utils.java
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

			if (this.board.getSection(section).getHouse(house).isFree())
				return true;
		}

		return false;
	}

	public boolean isColumnFree(int column) {
		int section, house;

		for (int row = 0; row < this.getLength(); row++) {
			section = convertToSection(row, column);
			house   = convertToHouse(row, column);

			if (this.board.getSection(section).getHouse(house).isFree())
				return true;
		}

		return false;
	}

	public boolean isDiagonalFree() {
		int section, house;

		for (int i = 0; i < this.getLength(); i++) {
			section = convertToSection(i, i);
			house   = convertToHouse(i, i);

			if (this.board.getSection(section).getHouse(house).isFree())
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
