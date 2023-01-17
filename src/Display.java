class Display {
	int dimension;
	int length;
	Board board;
	boolean quit;

	public Display() {
		this.dimension = this.get_dimension();
		this.length = this.dimension * this.dimension;
		this.board = new Board();
		this.quit = false;
	}

	String show() {
		String repr;

		repr = "";
		for (int i = 0; i < 30; i++)
			repr += "=";
		repr += "\n";
		repr += this.board.show();
		for (int i = 0; i < 30; i++)
			repr += "=";

		return repr;
	}

	int get_dimension() {
		return 2;
	}

	String[] getPlayers() {
		String[] playerNames = {"Jose", "Maria"};
		return playerNames;
	}
}
