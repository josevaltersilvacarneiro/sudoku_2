import static pkg.Utils.*;

class Board {
	int dimension;
	int length;
	Section board[];

	public Board(int dimension) {
		this.dimension = dimension;
		this.length    = this.dimension * this.dimension;
		
		this.board = new Section[this.length];
		for (int i = 0; i < this.length; i++)
			this.board[i] = new Section(this.dimension);
	}

	@Override
	public String toString() {
		String str = "";
		int section, house;

		for (int row = 0; row < this.length; row++) {
			for (int column = 0; column < this.length; column++) {
				section = convertToRowSection(this.dimension, row, column);  // See Utils.java
				house   = convertToColumnHouse(this.dimension, row, column); // See Utils.java

				if (!this.getSection(section).getHouse(house).isFree())
					str += String.format("%02d|",
							this.getSection(section).getHouse(house).getValue());
				else
					str += "XX|";
			}
			str += "\n";
		}

		return str;
	}

	public Section getSection(int section) {
		return this.board[section];
	}

	public boolean isSectionFree(int section) {
		return this.board[section].isFree();
	}

	public boolean isHouseFree(int section, int house) {
		return this.board[section].getHouse(house).isFree();
	}
}
