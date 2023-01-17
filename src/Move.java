class Move {
	int length;
	int row, column;

	public Move(int length, int row, int column) {
		this.length = length;
		this.row    = row;
                this.column = column;
	}

	public boolean isOptionValid() {
		return 0 <= this.row && this.row < this.length && 0 <= this.column && this.column < this.length;
	}
}
