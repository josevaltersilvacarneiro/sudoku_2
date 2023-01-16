class Board {
	int dimension;
	int length;
	Section board[];

	public Board() {
		this.dimension = 2;
		this.length = this.dimension * this.dimension;
		
		board = new Section[this.length];
		
		for (int i = 0; i < this.length; i++)
			board[i] = new Section();
	}

	String show() {
		String repr = "";

		for (int row = 0; row < this.length; row++) {
			for (int column = 0; column < this.length; column++) {
				int section, house;

				section = (row / this.dimension) * this.dimension + column / this.dimension;
    				house = (row % this.dimension) * this.dimension + column % this.dimension;

				repr += Integer.toString(this.board[section].index(house));
			}
			repr += "\n";
		}
		
		return repr;
	}
}
