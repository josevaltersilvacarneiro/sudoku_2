class Board {
	int dimension;
	int length;
	Section board[];

	public Board() {
		this.dimension = 2;
		this.length = this.dimension * this.dimension;
		
		this.board = new Section[this.length];
		for (int i = 0; i < this.length; i++)
			this.board[i] = new Section();
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
