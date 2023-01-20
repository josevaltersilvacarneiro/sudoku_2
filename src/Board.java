class Board {
	int dimension;
	int length;
	Section board[];

	int[] rowSum;
	int[] columnSum;
	int   diagonalSum;

	public Board() {
		this.dimension = 2;
		this.length = this.dimension * this.dimension;
		
		this.board = new Section[this.length];
		
		for (int i = 0; i < this.length; i++) {
			this.board[i]     = new Section();
			this.rowSum[i]    = 0;
			this.columnSum[i] = 0;
		}
		this.diagonalSum	  = 0;
	}

	public Section getSection(int section) {
		return this.board[section];
	}

	public boolean isSectionFree(int section) {
		return this.board[section].free;
	}

	public boolean isHouseFree(int section, int house) {
		return this.board[section].isHouseFree(house);
	}
}
